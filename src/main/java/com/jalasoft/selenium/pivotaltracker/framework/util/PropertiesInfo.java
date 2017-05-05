package com.jalasoft.selenium.pivotaltracker.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class that has the parameters to gather from gradle properties.
 */
public final class PropertiesInfo {

    private static final String CONFIG_PROPERTIES = "gradle.properties";

    private static final String URL = "url";

    private static final String BROWSER = "browser";

    private static final String URL_API = "urlApi";

    private static final String API_TOKEN = "apiToken";

    private static final String PROXY_PORT = "proxyPort";

    private static final String PROXY_HOST = "proxyHost";

    private static final String EMAIL = "email";

    private static final String ACCESS_SECURITY = "password";

    private static PropertiesInfo instance;

    private Properties properties;

    /**
     * Class constructor.
     */
    private PropertiesInfo() {
        loadProperties();
    }

    /**
     * gets the instance.
     *
     * @return the instance.
     */
    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return  instance;
    }

    /**
     * loads properties.
     */
    private  void loadProperties() {
        try {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(CONFIG_PROPERTIES);
                properties = new Properties();
                properties.load(fileInputStream);
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        }  catch (FileNotFoundException e) {
            System.out.println("The properties file couldn't be found: " + e);
        } catch (IOException e) {
            System.out.println("A problem of type " + e);
        }
    }

    /**
     * Method that returns the properties of a given value.
     *
     * @param propertyKey the element to check if is present
     * @return the values of the properties
     */
    public String getProperty(String propertyKey) {
        String propertyValue = System.getProperty(propertyKey);
        if (propertyValue == null) {
            propertyValue = properties.getProperty(propertyKey);
        }
        return propertyValue;
    }

    /**
     * Method that returns the url property.
     *
     * @return the url property
     */
    public String getUrl() {
        return getProperty(URL);
    }

    /**
     * Method that returns the browser property.
     *
     * @return the required browser property
     */
    public String getBrowser() {
        return getProperty(BROWSER);
    }

    /**
     * Method that returns the url of the API property.
     *
     * @return url of the API
     */
    public String getUrlApi() {
        return getProperty(URL_API);
    }

    /**
     * Method that returns the API token property.
     *
     * @return the API token required property
     */
    public String getApiToken() {
        return getProperty(API_TOKEN);
    }

    /**
     * Method that returns the proxy property.
     *
     * @return the required proxy property
     */
    public String getProxy() {
        return !getProxyHost().isEmpty() ? String.format("http://%s:%s", getProxyHost(), getProxyPort()) : null;
    }

    /**
     * Method that returns the proxy host property.
     *
     * @return the required proxy host property
     */
    public String getProxyHost() {
        return getProperty(PROXY_HOST);
    }

    /**
     * Method that returns the proxy port property.
     *
     * @return the required proxy port property
     */
    public String getProxyPort() {
        return getProperty(PROXY_PORT);
    }

    /**
     * Method that returns the email property.
     *
     * @return the email property
     */
    public String getEmail() {
        return getProperty(EMAIL);
    }

    /**
     * Method that returns the password property.
     *
     * @return the password property
     */
    public String getPassword() {
        return getProperty(ACCESS_SECURITY);
    }
}
