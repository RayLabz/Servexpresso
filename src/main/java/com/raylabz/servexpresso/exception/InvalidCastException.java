package com.raylabz.servexpresso.exception;

import com.raylabz.servexpresso.ParamType;

public class InvalidCastException extends RuntimeException {

    public InvalidCastException(final String paramName, Class<?> attemptedCastClass, Class<?> valueClass) {
        super("Parameter '" + paramName + "' (" + valueClass.getSimpleName() + ") cannot be casted to type " + attemptedCastClass.getSimpleName() + ".");
    }
}
