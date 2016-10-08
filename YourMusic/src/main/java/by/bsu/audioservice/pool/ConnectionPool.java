package by.bsu.audioservice.pool;

import by.bsu.audioservice.manager.ConfigurationManager;
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

/**
 * Class ConnectionPool
 *
 * Created by 7 on 18.08.2016.
 */
public class ConnectionPool {
    /** Field instance */
    private static ConnectionPool instance;

    /** Field connections */
    private BlockingDeque<ProxyConnection> connections;

    /** Field isCreated */
    private static AtomicBoolean isCreated = new AtomicBoolean(false);

    /** Field lock */
    private static Lock lock = new ReentrantLock();

    /** Field LOGGER */
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    /** Field url */
    private String url;

    /** Field login */
    private String login;

    /** Field password */
    private String password;

    /**
     * Instantiates a new ConnectionPool
     *
     * @param url of type String
     * @param login of type String
     * @param password of type String
     * @param connectionsCount of type String
     */
    private ConnectionPool(String url, String login, String password, int connectionsCount){
        this.connections = new LinkedBlockingDeque<ProxyConnection>();
        this.url = url;
        this.login = login;
        this.password = password;

        try {
            String driver = ConfigurationManager.getInstance().getProperty(ConfigurationManager.DRIVER);
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            LOGGER.error("ClassNotFoundException", e);
        }
        for (int i = 0; i < connectionsCount; i++){
            connections.add(createConnection());
        }

    }

    /**
     * Method createConnection
     *
     * @return ProxyConnection
     */
    private ProxyConnection createConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            LOGGER.error("SQLException", e);
        }
        return new ProxyConnection(connection);
    }

    /**
     * Take connection proxy connection.
     *
     * @return the proxy connection
     */
    public ProxyConnection takeConnection(){
        ProxyConnection connection = null;
        try {
            connection = connections.take();
        } catch (InterruptedException e) {
            LOGGER.error("InterruptedException", e);
        }
        return connection;
    }

    /**
     * Get instance connection pool.
     *
     * @return the connection pool
     */
    public static ConnectionPool getInstance(){
        if (!isCreated.get()){
            lock.lock();
            try {
                if (instance == null) {
                    String url = ConfigurationManager.getInstance().getProperty(ConfigurationManager.DB_ADDRESS);
                    String admin = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN);
                    String password = ConfigurationManager.getInstance().getProperty(ConfigurationManager.PASSWORD);
                    int poolSize = Integer.parseInt(ConfigurationManager.getInstance().getProperty(ConfigurationManager.POOL_SIZE));
                    instance = new ConnectionPool(url, admin, password, poolSize);
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return connections.size();
    }

    /**
     * Return connection.
     *
     * @param connection the connection
     */
    public void returnConnection(ProxyConnection connection){
        connections.add(connection);
    }

    /**
     * Close pool.
     */
    public void closePool(){
        while (!isEmpty()){
            try {
                takeConnection().closeConnection();
            } catch (SQLException e) {
                LOGGER.error("SQLException", e);
            }
        }
    }

    /**
     * Method isEmpty
     *
     * @return boolean
     */
    private boolean isEmpty(){
        lock.lock();
        try{
            return connections.isEmpty();
        } finally {
            lock.unlock();
        }
    }
}
