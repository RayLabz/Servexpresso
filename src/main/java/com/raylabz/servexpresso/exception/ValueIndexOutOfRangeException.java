package com.raylabz.servexpresso.exception;

/**
 * An exception thrown when the index of a parameter value is out of range.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public class ValueIndexOutOfRangeException extends RuntimeException {

    /**
     * Constructs a new ValueIndexOutOfRangeException.
     * @param index The index.
     * @param paramName The parameter's name.
     * @param paramSize The total number of values for this parameter.
     */
    public ValueIndexOutOfRangeException(final int index, final String paramName, final int paramSize) {
        super("The index " + index + " is out of range - The number of values for parameter '" + paramName + "' is " + paramSize + ".");
    }

}
