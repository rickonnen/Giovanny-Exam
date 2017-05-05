package com.jalasoft.selenium.pivotaltracker.api;

import com.jalasoft.selenium.pivotaltracker.framework.util.PropertiesInfo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Class for API connection.
 */
public final class Connection {

    private static Connection instance;

    private RequestSpecification requestSpecification;

    private static final String TOKEN_HEADER = "X-TrackerToken";

    /**
     * class constructor.
     */
    private Connection() {
        initApi();
    }

    /**
     * gets the instance of the class.
     * @return the instance
     */
    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    /**
     * Connection initializer.
     */
    private void initApi() {
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .addHeader(TOKEN_HEADER, PropertiesInfo.getInstance().getApiToken())
                .build();
        requestSpecification.baseUri(PropertiesInfo.getInstance().getUrlApi());
        if (PropertiesInfo.getInstance().getProxy() != null) {
            requestSpecification.proxy(PropertiesInfo.getInstance().getProxy());
        }
    }

    /**
     * get request spec.
     *
     * @return the value for spec
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
