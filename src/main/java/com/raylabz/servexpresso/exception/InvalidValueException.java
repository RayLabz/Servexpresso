package com.raylabz.servexpresso.exception;

import com.raylabz.servexpresso.ParamType;

/**
 * Defines an exception that occurs when a value cannot be converted into an expected type.
 */
public class InvalidValueException extends RuntimeException {

    /**
     * Constructs an InvalidValueException,
     * @param rawValue The raw value received.
     * @param type The expected type.
     */
    public InvalidValueException(final String rawValue, final ParamType type) {
        super("The string value '" + rawValue + "' cannot be converted into type " + type);
    }

}
