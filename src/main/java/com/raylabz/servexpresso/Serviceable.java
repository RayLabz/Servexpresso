package com.raylabz.servexpresso;

import com.raylabz.responz.Response;

/**
 * Defines the implementation of Services.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public interface Serviceable {

    /**
     * Executes logic for a serviceable and returns a response.
     * @param params The parameters provided to the serviceable.
     * @return Returns a response.
     */
    Response serve(InputParams params);

}
