package by.bsu.logistics.manager;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by 7 on 11.06.2016.
 */
public enum MessageManager {

    EN(ResourceBundle.getBundle("messages", new Locale("en", "EN"))),
    RU(ResourceBundle.getBundle("messages", new Locale("ru", "RU")));

    MessageManager(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    private ResourceBundle resourceBundle;

    public static final String VAN = "van";
    public static final String SERVICE = "service";

    public String getProperty(String key){
        return (String)resourceBundle.getObject(key);
    }
}
