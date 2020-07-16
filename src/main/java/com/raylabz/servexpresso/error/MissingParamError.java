package com.raylabz.servexpresso.error;

import com.raylabz.servexpresso.ExpectedParam;

/**
 * Models a missing parameter error.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public class MissingParamError extends ServiceParamError {

    /**
     * Constructs an error based on a specified service parameter.
     * @param expectedParam The service parameter.
     */
    public MissingParamError(ExpectedParam expectedParam) {
        super(expectedParam, ServiceParamErrorType.MISSING_PARAM);
    }

    /**
     * Retrieves the error message.
     * @return Returns a String.
     */
    @Override
    public String getMessage() {
        return "Expected parameter '" + serviceParam.getName() + "' was not provided.";
    }

}
