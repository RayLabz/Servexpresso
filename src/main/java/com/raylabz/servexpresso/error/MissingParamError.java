package com.raylabz.servexpresso.error;

import com.raylabz.servexpresso.ServiceParam;

/**
 * Models a missing parameter error.
 */
public class MissingParamError extends ServiceParamError {

    /**
     * Constructs an error based on a specified service parameter.
     * @param serviceParam The service parameter.
     */
    public MissingParamError(ServiceParam serviceParam) {
        super(serviceParam, ServiceParamErrorType.MISSING_PARAM);
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
