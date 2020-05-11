package com.raylabz.servexpresso.error;

/**
 * Down-casts a specific ServiceParamError into a leaner form that can be returned to a client.
 */
public class SimpleError {

    /**
     * The error type.
     */
    private final ServiceParamErrorType type;

    /**
     * The parameter name involved in the error.
     */
    private final String paramName;

    /**
     * Constructs a new SimpleError.
     * @param type The type of error.
     * @param paramName The parameter involved in the error.
     */
    public SimpleError(ServiceParamErrorType type, String paramName) {
        this.type = type;
        this.paramName = paramName;
    }

    /**
     * Retrieves the error type.
     * @return Returns SimpleErrorType.
     */
    public ServiceParamErrorType getType() {
        return type;
    }

    /**
     * Retrieves the error parameter's name.
     * @return Returns a String.
     */
    public String getParamName() {
        return paramName;
    }

}