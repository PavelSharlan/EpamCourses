package test.by.bsu.file;

import by.bsu.parsing.main.Main;
import org.junit.Test;
import org.junit.Assert;

import java.io.File;

/**
 * Created by 7 on 22.06.2016.
 */
public class FileFoundTest {
    @Test
    public void checkXMLFile(){
        boolean expected = true;
        boolean actual = false;

        File xml = new File(Main.FILE_XML);
        if (xml.exists()){
            actual = true;
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkXSDFile(){
        boolean expected = true;
        boolean actual = false;

        File xsd = new File(Main.FILE_XSD);
        if (xsd.exists()){
            actual = true;
        }
        Assert.assertEquals(expected, actual);
    }
}
