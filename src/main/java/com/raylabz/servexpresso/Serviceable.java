package com.raylabz.servexpresso;

import com.raylabz.responz.Response;

import java.util.HashMap;

/**
 * Defines the implementation of Services.
 * @author Nicos Kasenides
 * @version 1.1.0
 */
public interface Serviceable {

    /**
     * Executes logic for a serviceable and returns a response.
     * @param params The parameters provided to the serviceable.
     * @param attributes A map of special attributes statically passed to this service.
     * @return Returns a response.
     */
    Response serve(InputParams params, HashMap<String, Object> attributes);

}
