package com.raylabz.servexpresso.exception;

/**
 * Defines an exception that occurs when a service's parameter name is invalid.
 */
public class ServiceParamNameException extends RuntimeException {

    /**
     * Constructs a ServiceParamNameException.
     * @param message The message of the exception.
     */
    public ServiceParamNameException(String message) {
        super(message);
    }

}
