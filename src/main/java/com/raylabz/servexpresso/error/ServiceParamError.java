package com.raylabz.servexpresso.error;

import com.raylabz.servexpresso.ServiceParam;

/**
 * Models a generic service parameter error.
 */
public abstract class ServiceParamError {

    /**
     * The error service parameter.
     */
    protected final ServiceParam serviceParam;

    /**
     * The error type.
     */
    protected final ServiceParamErrorType errorType;

    /**
     * Constructs a service parameter error.
     * @param serviceParam The service parameter.
     * @param errorType The error type.
     */
    ServiceParamError(ServiceParam serviceParam, ServiceParamErrorType errorType) {
        this.serviceParam = serviceParam;
        this.errorType = errorType;
    }

    /**
     * Retrieves the service parameter of this error.
     * @return Returns a ServiceParam.
     */
    public final ServiceParam getServiceParam() {
        return serviceParam;
    }

    /**
     * Retrieves the error type.
     * @return Returns a ServiceParamErrorType.
     */
    public ServiceParamErrorType getErrorType() {
        return errorType;
    }

    /**
     * Outputs a user-friendly error message depending on the error and service parameter.
     * @return Returns a String.
     */
    public abstract String getMessage();

}
