package com.raylabz.servexpresso.exception;

/**
 * Defines an exception that occurs when a service has not been implemented but called.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public class NoImplementationException extends RuntimeException {

    /**
     * Constructs a new NoImplementationException.
     */
    public NoImplementationException() {
        super("Service has no implementation - use the implement() method to provide an implementation for this service.");
    }

}
