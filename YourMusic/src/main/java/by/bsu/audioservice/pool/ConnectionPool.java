package by.bsu.audioservice.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static ConnectionPool instance;
    private BlockingDeque<ProxyConnection> connections;
    private static AtomicBoolean isCreated = new AtomicBoolean(false);
    private static Lock lock = new ReentrantLock();
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_ADDRESS = "jdbc:mysql://localhost:3306/audio_service";
    private static String ADMIN = "root";
    private static String PASSWORD = "password";

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private String url;
    private String login;
    private String password;

    private ConnectionPool(String url, String login, String password, int connectionsCount){
        this.connections = new LinkedBlockingDeque<ProxyConnection>();
        this.url = url;
        this.login = login;
        this.password = password;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < connectionsCount; i++){
            connections.add(createConnection());
        }

    }

    private ProxyConnection createConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return new ProxyConnection(connection);
    }

    public ProxyConnection takeConnection(){
        ProxyConnection connection = null;
        try {
            connection = connections.take();
        } catch (InterruptedException e) {
            LOGGER.error("InterruptedException", e);
        }
        return connection;
    }

    public static ConnectionPool getInstance(){
        if (!isCreated.get()){
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPool(DB_ADDRESS, ADMIN, PASSWORD, 5);
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    public void returnConnection(ProxyConnection connection){
        connections.add(connection);
    }

    public void closePool(){
        while (!isEmpty()){
            try {
                takeConnection().closeConnection();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }
        }
    }

    private boolean isEmpty(){
        lock.lock();
        try{
            return connections.isEmpty();
        } finally {
            lock.unlock();
        }
    }
}
