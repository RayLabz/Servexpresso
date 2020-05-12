package com.raylabz.servexpresso.error;

import com.raylabz.servexpresso.ParamType;
import com.raylabz.servexpresso.ServiceInputParam;

/**
 * Models a type mismatch error.
 */
public class TypeMismatchParamError extends ServiceParamError {


    private final ParamType actualType;

    /**
     * Constructs a TypeMismatchParamError.
     * @param serviceParam The parameter related to the error.
     */
    public TypeMismatchParamError(ServiceInputParam serviceParam, final ParamType actualType) {
        super(serviceParam, ServiceParamErrorType.TYPE_MISMATCH);
        this.actualType = actualType;
    }

    @Override
    public String getMessage() {
        final ServiceInputParam param = (ServiceInputParam) serviceParam;
        return "Expected type " + param.getType() + " for parameter '" + param.getName() + "', but " + actualType + " '" + ((ServiceInputParam) serviceParam).getValues()[0].toString() + "' found.";
    }

}
