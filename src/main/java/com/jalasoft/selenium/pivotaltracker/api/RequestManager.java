package com.jalasoft.selenium.pivotaltracker.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Created by Carlos Gonzales on 4/10/2017.
 */
public final class RequestManager {

    /**
     * Class constructor.
     */
    private RequestManager() {
    }

    /**
     * method that gets a spec.
     *
     * @param endpoint the endpoint to use on API
     * @return the request
     */
    public static Response get(String endpoint) {
        return RestAssured.given(Connection.getInstance().getRequestSpecification())
                .get(endpoint);
    }

    /**
     * method that deletes given the request.
     *
     * @param endpoint the endpoint
     * @return the request
     */
    public static Response delete(String endpoint) {
        return RestAssured.given(Connection.getInstance().getRequestSpecification())
                .delete(endpoint);
    }

}
