import org.junit.Assert;
import org.junit.Test;

import java.util.ResourceBundle;

/**
 * Created by 7 on 06.10.2016.
 */
public class PropertiesTest {
    @Test
    public void pageContentPropertiesExist(){
        Assert.assertNotNull(ResourceBundle.getBundle("config"));
    }
}
