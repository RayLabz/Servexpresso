package com.raylabz.servexpresso.exception;

public class ValueIndexOutOfRangeException extends RuntimeException {

    public ValueIndexOutOfRangeException(final int index, final String paramName, final int paramSize) {
        super("The index " + index + " is out of range - The number of values for parameter '" + paramName + "' is " + paramSize + ".");
    }

}
