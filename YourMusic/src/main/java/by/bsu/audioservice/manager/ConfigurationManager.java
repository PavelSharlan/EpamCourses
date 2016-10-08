package by.bsu.audioservice.manager;

import java.util.ResourceBundle;

/**
 * Class ConfigurationManager
 *
 * Created by 7 on 17.08.2016.
 */
public class ConfigurationManager {
    /** Field instance */
    private static ConfigurationManager instance;

    /** Field resourceBundle */
    private ResourceBundle resourceBundle;

    /** Field BUNDLE_NAME */
    private static final String BUNDLE_NAME = "config";

    /** Field DB_ADDRESS */
    public static final String DB_ADDRESS = "database.url";

    /** Field DRIVER */
    public static final String DRIVER = "database.driver";

    /** Field LOGIN */
    public static final String LOGIN = "database.login";

    /** Field PASSWORD */
    public static final String PASSWORD = "database.password";

    /** Field POOL_SIZE */
    public static final String POOL_SIZE = "database.pool.size";

    /** Field LOGIN_PAGE_PATH */
    public static final String LOGIN_PAGE_PATH = "LOGIN_JSP";

    /** Field AUDIOS_FOR_GUESTS_PAGE_PATH */
    public static final String AUDIOS_FOR_GUESTS_PAGE_PATH = "AUDIOS_FOR_GUESTS";

    /** Field ABOUT_US_PAGE_PATH */
    public static final String ABOUT_US_PAGE_PATH = "ABOUT_US_JSP";

    /** Field USER_CABINET_PAGE_PATH */
    public static final String USER_CABINET_PAGE_PATH = "USER_CABINET_JSP";

    /** Field ADMIN_CABINET_PAGE_PATH */
    public static final String ADMIN_CABINET_PAGE_PATH = "ADMIN_CABINET_JSP";

    /** Field AUDIOS_FOR_REGISTERED_PAGE_PATH */
    public static final String AUDIOS_FOR_REGISTERED_PAGE_PATH = "AUDIOS_JSP";

    /** Field ORDERS_PAGE_PATH */
    public static final String ORDERS_PAGE_PATH = "ORDERS_JSP";

    /** Field MAIN_PAGE_PATH */
    public static final String MAIN_PAGE_PATH = "MAIN_PAGE_JSP";

    /** Field USER_SETTINGS_PATH */
    public static final String USER_SETTINGS_PATH = "USER_SETTINGS_JSP";

    /** Field USER_LIST_PATH */
    public static final String USER_LIST_PATH = "USER_LIST_JSP";

    /** Field COMMENTS_PAGE_PATH */
    public static final String COMMENTS_PAGE_PATH = "COMMENTS_JSP";

    /** Field AUDIO_INFO_PAGE_PATH */
    public static final String AUDIO_INFO_PAGE_PATH = "AUDIO_INFO_JSP";

    /** Field ERROR+PAGE_PATH */
    public static final String ERROR_PAGE_PATH = "ERROR_PAGE_JSP";


    /**
     * Method getInstance
     *
     * @return ConfigurationManager
     */
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    /**
     * Method getProperty
     *
     * @param key of type String
     * @return String
     */
    public String getProperty(String key) {
        return (String)resourceBundle.getObject(key);
    }
}
