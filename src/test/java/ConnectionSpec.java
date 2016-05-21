import io.veronicacrowe.Connection;
import io.veronicacrowe.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by veronicacrowe on 5/20/16.
 */
public class ConnectionSpec {

    @Test
    public void checkConnectionLimitTest(){
        ConnectionManager connectionManager = new ConnectionManager(0);
        Connection connection = connectionManager.requestConnection("", 0, "");
        Assert.assertNull(connection);


    }

    @Test
    public void closeTest(){
        ConnectionManager connectionManager = new ConnectionManager(4);
        Connection connection1 = connectionManager.requestConnection("", 0, "");
        Connection connection2 = connectionManager.requestConnection("", 0, "");
        int expectedValue= 1;
        connection1.close();
        int actualValue = connectionManager.getCounter();
        Assert.assertEquals("A connection spot should be removed.", actualValue, expectedValue);
    }
}
