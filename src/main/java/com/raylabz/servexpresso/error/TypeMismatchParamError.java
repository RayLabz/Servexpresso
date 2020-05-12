package com.raylabz.servexpresso.error;

import com.raylabz.servexpresso.ParamType;
import com.raylabz.servexpresso.InputParam;

/**
 * Models a type mismatch error.
 */
public class TypeMismatchParamError extends ServiceParamError {

    /**
     * The type expected for this parameter.
     */
    private final ParamType expectedType;

    /**
     * The actual type found from parsing the raw values.
     */
    private final ParamType actualType;

    /**
     * Constructs a TypeMismatchParamError.
     * @param serviceParam The parameter related to the error.
     */
    public TypeMismatchParamError(InputParam serviceParam, final ParamType expectedType, final ParamType actualType) {
        super(serviceParam, ServiceParamErrorType.TYPE_MISMATCH);
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    /**
     * Retrieves the error message.
     * @return Returns a String.
     */
    @Override
    public String getMessage() {
        return "Expected type " + expectedType + " for parameter '" + serviceParam.getName() + "', but " + actualType + " found.";
    }

}
