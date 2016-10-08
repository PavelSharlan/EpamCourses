package by.bsu.audioservice.pool;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;


/**
 * Class ProxyConnection
 *
 * Created by 7 on 18.08.2016.
 */
public class ProxyConnection implements Connection {
    /** Field connection */
    private Connection connection;

    /**
     * Instantiates a new Proxy connection.
     *
     * @param connection the connection
     */
    ProxyConnection(Connection connection) {
        if (connection != null) {
            this.connection = connection;
        }
    }

    /**
     * Method createStatement
     *
     * @return Statement
     * @throws SQLException
     */
    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    /**
     * Method prepareStatement
     *
     * @param sql of type String
     * @return PreparedStatement
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    /**
     * Method callableStatement
     *
     * @param sql of type String
     * @return CallableStatement
     * @throws SQLException
     */
    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return connection.prepareCall(sql);
    }

    /**
     * Method nativeSQL
     *
     * @param sql of type String
     * @return String
     * @throws SQLException
     */
    @Override
    public String nativeSQL(String sql) throws SQLException {
        return connection.nativeSQL(sql);
    }

    /**
     * Method setAutoCommit
     *
     * @param autoCommit of type boolean
     * @throws SQLException
     */
    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    /**
     * Method getAutoCommit
     *
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean getAutoCommit() throws SQLException {
        return connection.getAutoCommit();
    }

    /**
     * Method commit
     *
     * @throws SQLException
     */
    @Override
    public void commit() throws SQLException {
        connection.commit();
    }

    /**
     * Method rollback
     *
     * @throws SQLException
     */
    @Override
    public void rollback() throws SQLException {
        connection.rollback();
    }

    /**
     * Method close
     *
     * @throws SQLException
     */
    @Override
    public void close() throws SQLException {
        ConnectionPool.getInstance().returnConnection(this);
    }

    /**
     * Method closeConnection.
     *
     * @throws SQLException the sql exception
     */
    void closeConnection() throws SQLException {
        connection.close();
    }

    /**
     * Method isClosed
     *
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean isClosed() throws SQLException {
        return connection.isClosed();
    }

    /**
     * Method getMetaData
     *
     * @return DatabaseMetaData
     * @throws SQLException
     */
    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return connection.getMetaData();
    }

    /**
     * Method setReadOnly
     *
     * @param readOnly of type boolean
     * @throws SQLException
     */
    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        connection.setReadOnly(readOnly);
    }

    /**
     * Method isReadOnly
     *
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean isReadOnly() throws SQLException {
        return connection.isReadOnly();
    }

    /**
     * Method setCatalog
     *
     * @param catalog of type String
     * @throws SQLException
     */
    @Override
    public void setCatalog(String catalog) throws SQLException {
        connection.setCatalog(catalog);
    }

    /**
     * Method getCatalog
     *
     * @return String
     * @throws SQLException
     */
    @Override
    public String getCatalog() throws SQLException {
        return connection.getCatalog();
    }

    /**
     * Method setTransactionIsolation
     *
     * @param level of type int
     * @throws SQLException
     */
    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        connection.setTransactionIsolation(level);
    }

    /**
     * Method getTransactionIsolation
     *
     * @return int
     * @throws SQLException
     */
    @Override
    public int getTransactionIsolation() throws SQLException {
        return connection.getTransactionIsolation();
    }

    /**
     * Method getWarnings
     *
     * @return SQLWarning
     * @throws SQLException
     */
    @Override
    public SQLWarning getWarnings() throws SQLException {
        return connection.getWarnings();
    }

    /**
     * Method clearWarnings
     *
     * @throws SQLException
     */
    @Override
    public void clearWarnings() throws SQLException {
        connection.clearWarnings();
    }

    /**
     * Method createStatement
     *
     * @param resultSetType of type int
     * @param resultSetConcurrency of type int
     * @return Statement
     * @throws SQLException
     */
    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.createStatement(resultSetType, resultSetConcurrency);
    }

    /**
     * Method prepareStatement
     *
     * @param sql of type String
     * @param resultSetType of type int
     * @param resultSetConcurrency of type int
     * @return PreparedStatement
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    /**
     * Method prepareCall
     *
     * @param sql of type String
     * @param resultSetType of type int
     * @param resultSetConcurrency of type int
     * @return CallableStatement
     * @throws SQLException
     */
    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    /**
     * Method getTypeMap
     *
     * @return Map<String, Class<?>>
     * @throws SQLException
     */
    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return connection.getTypeMap();
    }

    /**
     * Method setTypeMap
     *
     * @param map of type Map<String, Class<?>>
     * @throws SQLException
     */
    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        connection.setTypeMap(map);
    }

    /**
     * Method setHoldability
     *
     * @param holdability of type
     * @throws SQLException
     */
    @Override
    public void setHoldability(int holdability) throws SQLException {
        connection.setHoldability(holdability);
    }

    /**
     * Method getHoldability
     *
     * @return int
     * @throws SQLException
     */
    @Override
    public int getHoldability() throws SQLException {
        return connection.getHoldability();
    }

    /**
     * Method setSavepoint
     *
     * @return Savepoint
     * @throws SQLException
     */
    @Override
    public Savepoint setSavepoint() throws SQLException {
        return connection.setSavepoint();
    }

    /**
     * Method setSavepoint
     *
     * @param name of type String
     * @return Savepoint
     * @throws SQLException
     */
    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        return connection.setSavepoint(name);
    }

    /**
     * Method rollback
     *
     * @param savepoint of type String
     * @throws SQLException
     */
    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        connection.rollback(savepoint);
    }

    /**
     * Method releaseSavepoint
     *
     * @param savepoint of type Savepoint
     * @throws SQLException
     */
    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        connection.releaseSavepoint(savepoint);
    }

    /**
     * Method createStatement
     *
     * @param resultSetType of type int
     * @param resultSetConcurrency of type int
     * @param resultSetHoldability of type int
     * @return Statement
     * @throws SQLException
     */
    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    /**
     * Method prepareStatement
     *
     * @param sql of type String
     * @param resultSetType of type int
     * @param resultSetConcurrency of type int
     * @param resultSetHoldability of type int
     * @return PreparedStatement
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    /**
     * Method prepareCall
     *
     * @param sql of type String
     * @param resultSetType of type int
     * @param resultSetConcurrency of type int
     * @param resultSetHoldability of type int
     * @return CallableStatement
     * @throws SQLException
     */
    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    /**
     * Method prepareStatement
     *
     * @param sql of type String
     * @param autoGeneratedKeys of type int
     * @return PreparedStatement
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return connection.prepareStatement(sql, autoGeneratedKeys);
    }

    /**
     * Method prepareStatement
     *
     * @param sql of type String
     * @param columnIndexes of type int[]
     * @return PreparedStatement
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return connection.prepareStatement(sql, columnIndexes);
    }

    /**
     * Method prepareStatement
     *
     * @param sql of type String
     * @param columnNames of type String[]
     * @return PreparedStatement
     * @throws SQLException
     */
    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return connection.prepareStatement(sql, columnNames);
    }

    /**
     * Method createClob
     *
     * @return Clob
     * @throws SQLException
     */
    @Override
    public Clob createClob() throws SQLException {
        return connection.createClob();
    }

    /**
     * Method createBlob
     *
     * @return Blob
     * @throws SQLException
     */
    @Override
    public Blob createBlob() throws SQLException {
        return connection.createBlob();
    }

    /**
     * Method createNClob
     *
     * @return NClob
     * @throws SQLException
     */
    @Override
    public NClob createNClob() throws SQLException {
        return connection.createNClob();
    }

    /**
     * Method createSQLXML
     *
     * @return SQLXML
     * @throws SQLException
     */
    @Override
    public SQLXML createSQLXML() throws SQLException {
        return connection.createSQLXML();
    }

    /**
     * Method isValid
     *
     * @param timeout of type int
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean isValid(int timeout) throws SQLException {
        return connection.isValid(timeout);
    }

    /**
     * Method setClientInfo
     *
     * @param name of type String
     * @param value of type String
     * @throws SQLClientInfoException
     */
    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        connection.setClientInfo(name, value);
    }

    /**
     * Method setClientInfo
     *
     * @param properties of type Properties
     * @throws SQLClientInfoException
     */
    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        connection.setClientInfo(properties);
    }

    /**
     * Method getClientInfo
     *
     * @param name of type String
     * @return String
     * @throws SQLException
     */
    @Override
    public String getClientInfo(String name) throws SQLException {
        return connection.getClientInfo(name);
    }

    /**
     * Method getClientInfo
     *
     * @return Properties
     * @throws SQLException
     */
    @Override
    public Properties getClientInfo() throws SQLException {
        return connection.getClientInfo();
    }

    /**
     * Method createArrayOf
     *
     * @param typeName of type String
     * @param elements of type Object[]
     * @return Array
     * @throws SQLException
     */
    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        return connection.createArrayOf(typeName, elements);
    }

    /**
     * Method createStruct
     *
     * @param typeName of type String
     * @param attributes of type Object[]
     * @return Struct
     * @throws SQLException
     */
    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        return connection.createStruct(typeName, attributes);
    }

    /**
     * Method setSchema
     *
     * @param schema of type String
     * @throws SQLException
     */
    @Override
    public void setSchema(String schema) throws SQLException {
        connection.setSchema(schema);
    }

    /**
     * Method getSchema
     *
     * @return String
     * @throws SQLException
     */
    @Override
    public String getSchema() throws SQLException {
        return connection.getSchema();
    }

    /**
     * Method abort
     *
     * @param executor of type Executor
     * @throws SQLException
     */
    @Override
    public void abort(Executor executor) throws SQLException {
        connection.abort(executor);
    }

    /**
     * Method setNetworkTimeout
     *
     * @param executor of type Executor
     * @param milliseconds of type int
     * @throws SQLException
     */
    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        connection.setNetworkTimeout(executor, milliseconds);
    }

    /**
     * Method getNetworkTimeout
     *
     * @return int
     * @throws SQLException
     */
    @Override
    public int getNetworkTimeout() throws SQLException {
        return connection.getNetworkTimeout();
    }

    /**
     * Method unwrap
     *
     * @param iface of type Class<T>
     * @param <T>
     * @return
     * @throws SQLException
     */
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return connection.unwrap(iface);
    }

    /**
     * Method isWrapperFor
     *
     * @param iface of type Class<?>
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return connection.isWrapperFor(iface);
    }
}
