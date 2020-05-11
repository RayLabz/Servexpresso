package com.raylabz.servexpresso.error;

import com.raylabz.servexpresso.ServiceInputParam;

/**
 * Models a type mismatch error.
 */
public class TypeMismatchParamError extends ServiceParamError {

    /**
     * Constructos a TypeMismatchParamError.
     * @param serviceParam The parameter related to the error.
     */
    public TypeMismatchParamError(ServiceInputParam serviceParam) {
        super(serviceParam, ServiceParamErrorType.TYPE_MISMATCH);
    }

    @Override
    public String getMessage() {
        final ServiceInputParam param = (ServiceInputParam) serviceParam;
        return "Expected type " + param.getType() + " for parameter '" + param.getName() + "', but '" + param.getValue() + "' found.";
    }

}
