package com.raylabz.servexpresso.exception;

/**
 * An exception thrown when a parameter cannot be casted to its corresponding expected type.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public class InvalidCastException extends RuntimeException {

    /**
     * Constructs a new InvalidCastException.
     * @param paramName The parameter's name.
     * @param attemptedCastClass The expected type.
     * @param valueClass The actual value.
     */
    public InvalidCastException(final String paramName, Class<?> attemptedCastClass, Class<?> valueClass) {
        super("Parameter '" + paramName + "' (" + valueClass.getSimpleName() + ") cannot be casted to type " + attemptedCastClass.getSimpleName() + ".");
    }

}
