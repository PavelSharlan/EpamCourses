import by.bsu.audioservice.pool.ConnectionPool;
import by.bsu.audioservice.pool.ProxyConnection;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class ConnectionPoolTest {
    private static final int POOL_SIZE = 5;

    @Test
    public void poolInit(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Assert.assertTrue(pool.size() == POOL_SIZE);
    }

    @Test
    public void takingConnectionTest(){
        try{
            ProxyConnection cn = ConnectionPool.getInstance().takeConnection();
            Assert.assertTrue(ConnectionPool.getInstance().size() == POOL_SIZE - 1);
            cn.close();
            Assert.assertTrue(ConnectionPool.getInstance().size() == POOL_SIZE);
        } catch (SQLException e) {
            Assert.fail("SQLException");
        }
    }
}
