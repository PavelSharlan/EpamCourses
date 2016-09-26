package by.bsu.audioservice.manager;

import java.util.ResourceBundle;

/**
 * Created by 7 on 17.08.2016.
 */
public class ConfigurationManager {
    private static ConfigurationManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "config";

    public static final String LOGIN_PAGE_PATH = "LOGIN_JSP";
    public static final String AUDIOS_FOR_GUESTS_PAGE_PATH = "AUDIOS_FOR_GUESTS";
    public static final String ABOUT_US_PAGE_PATH = "ABOUT_US_JSP";
    public static final String USER_CABINET_PAGE_PATH = "USER_CABINET_JSP";
    public static final String ADMIN_CABINET_PAGE_PATH = "ADMIN_CABINET_JSP";
    public static final String AUDIOS_FOR_REGISTERED_PAGE_PATH = "AUDIOS_JSP";
    public static final String ORDERS_PAGE_PATH = "ORDERS_JSP";
    public static final String MAIN_PAGE_PATH = "MAIN_PAGE_JSP";
    public static final String USER_SETTINGS_PATH = "USER_SETTINGS_JSP";
    public static final String USER_LIST_PATH = "USER_LIST_JSP";
    public static final String COMMENTS_PAGE_PATH = "COMMENTS_JSP";
    public static final String AUDIO_INFO_PAGE_PATH = "AUDIO_INFO_JSP";
    public static final String ERROR_PAGE_PATH = "ERROR_PAGE_JSP";

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String)resourceBundle.getObject(key);
    }
}
