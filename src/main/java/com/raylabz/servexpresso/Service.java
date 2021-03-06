package com.raylabz.servexpresso;

import com.raylabz.responz.ErrorResponse;
import com.raylabz.responz.Response;
import com.raylabz.servexpresso.error.MissingParamError;
import com.raylabz.servexpresso.error.TypeMismatchParamError;
import com.raylabz.servexpresso.exception.NoImplementationException;
import com.raylabz.servexpresso.exception.ServiceParamNameException;
import com.raylabz.servexpresso.response.MissingParametersResponse;
import com.raylabz.servexpresso.response.TypeMismatchResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Models a service.
 * @author Nicos Kasenides
 * @version 1.1.0
 */
public class Service {

    /**
     * Determines the set of possible service parameter names.
     * Parameter names must begin with a letter or underscore, followed by any number of letters, numbers or underscores.
     */
    private static final String SERVICE_PARAM_NAME_REGEX = "\\b([A-Za-z_][A-Za-z0-9_]*)\\b";

    /**
     * A map of all expected parameters.
     */
    private final Params expectedParams;

    /**
     * A map of all received parameters.
     */
    private final InputParams receivedParams = new InputParams();

    /**
     * A map of special attributes passed to the service statically.
     */
    private HashMap<String, Object> specialAttributes = new HashMap<>();

    /**
     * The serviceable of this Service, which determines what happens when this service is called. Must be non-null before calling,
     * otherwise a NoImplementationException will occur.
     */
    private final Serviceable serviceable;

    /**
     * Instantiates a service - this method is called by Service.Builder.
     * @param expectedParams The parameters expected by this service.
     */
    private Service(Params expectedParams, Serviceable serviceable) {
        this.expectedParams = expectedParams;
        this.serviceable = serviceable;
    }

    /**
     * Checks if all required params have been specified. Does not check for type match.
     * @param receivedParams The provided params.
     * @return Returns an ArrayList of MissingParamError.
     */
    private ArrayList<MissingParamError> checkForMissingParams(InputParams receivedParams) {
        ArrayList<MissingParamError> errors = new ArrayList<>();

        for (Params.Entry<String, ExpectedParam> entry : expectedParams.entrySet()) {
            final ExpectedParam expectedParam = entry.getValue();
            final InputParam inputParam = receivedParams.get(expectedParam.getName());

            if (expectedParam.isRequired()) {

                //Missing both declaration and value:
                if (inputParam == null) {
                    errors.add(new MissingParamError(expectedParam));
                }
                else {
                    //Declaration exists, but no value provided:
                    if (inputParam.getRawValues() == null || inputParam.getRawValues().length == 0) {
                        errors.add(new MissingParamError(expectedParam));
                    }
                }

            }
        }
        return errors;
    }

    /**
     * Checks if the parameters provided have types that match those expected or are at least castable to those expected.
     * @param receivedParams The provided params.
     * @return Returns an ArrayList of TypeMismatchParamError.
     */
    private ArrayList<TypeMismatchParamError> checkForParamTypes(InputParams receivedParams) {
        ArrayList<TypeMismatchParamError> errors = new ArrayList<>();

        for (Params.Entry<String, ExpectedParam> entry : expectedParams.entrySet()) {

            final ExpectedParam expectedParam = entry.getValue();
            final InputParam inputParam = receivedParams.get(expectedParam.getName());

            if (inputParam != null) {
                final ParamType actualParamType = TypeParser.findType(inputParam, expectedParam.getType());

//                System.out.println("actualParamType: " + actualParamType);
//                System.out.println("Expected type: " + expectedParam.getType());

                if (expectedParam.getType() != ParamType.STRING && (!actualParamType.isCastableTo(expectedParam.getType()) && expectedParam.getType() != actualParamType)) {
                    errors.add(new TypeMismatchParamError(inputParam, expectedParam.getType(), actualParamType));
                }
            }

        }
        return errors;
    }

    /**
     * Processes a request for this service using the specified input parameters.
     * @param inputParams A map containing the parameters provided to this service.
     * @return Returns a Response object.
     */
    public Response processRequest(final InputParams inputParams) {

        //Parse the input parameters:
        for (Map.Entry<String, InputParam> inputParamEntry : inputParams.entrySet()) {
            final ExpectedParam expectedParam = expectedParams.get(inputParamEntry.getKey());
            if (expectedParam != null) {
                TypeParser.parseValues(inputParamEntry.getValue(), expectedParam);
            }
        }

        //Check for missing parameters:
        ArrayList<MissingParamError> missingParamErrors = checkForMissingParams(inputParams);
        if (missingParamErrors.size() > 0) {
            return new MissingParametersResponse(missingParamErrors);
        }

        //Check for invalid types:
        ArrayList<TypeMismatchParamError> typeMismatchParamErrors = checkForParamTypes(inputParams);
        if (typeMismatchParamErrors.size() > 0) {
            return new TypeMismatchResponse(typeMismatchParamErrors);
        }

        //If no errors, serve but catch any exceptions that the service fails to catch:
        try {
            return serviceable.serve(inputParams, specialAttributes);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse("Unexpected error", "The service has encountered an unexpected error.");
        }
    }

    /**
     * Processes a request for this service using the specified input parameters.
     * @param inputParams An array containing the parameters provided to this service.
     * @return Returns a Response object.
     */
    public Response processRequest(InputParam... inputParams) {
        InputParams map = new InputParams();
        for (final InputParam param : inputParams) {
            map.put(param.getName(), param);
        }
        return processRequest(map);
    }

    /**
     * Sets a special attribute for this service.
     * @param key The key of this attribute.
     * @param value The value of this attribute.
     */
    public void setAttribute(String key, Object value) {
        specialAttributes.put(key, value);
    }

    /**
     * Retrieves the value of an attribute.
     * @param key The key of the attribute to retrieve.
     * @return Returns an Object.
     */
    public Object getAttribute(String key) {
        return specialAttributes.get(key);
    }

    /**
     * Removes a special attribute for this service.
     * @param key The key of the attribute to remove.
     */
    public void removeAttribute(String key) {
        specialAttributes.remove(key);
    }

    /**
     * Checks if an attribute exists or not.
     * @param key The key of the attribute.
     * @return Returns true if the attribute exists, false otherwise.
     */
    public boolean attributeExists(String key) {
        return specialAttributes.containsKey(key);
    }

    /**
     * Constructs Services by specifying their expected parameters.
     */
    public static class Builder {

        /**
         * A map of a service's expected parameters.
         */
        private final Params expectedParameters = new Params();

        /**
         * Instantiates a new Service.Builder.
         */
        public Builder() { }

        /**
         * Adds an expected parameter to the service builder.
         * @param paramName The parameter's name.
         * @param paramType The parameter's type.
         * @param required Whether or not this parameter is required.
         * @return Returns a builder.
         */
        public Builder expectParam(final String paramName, final ParamType paramType, final boolean required) {
            expectedParameters.put(paramName, new ExpectedParam(paramName, paramType, required));
            return this;
        }

        /**
         * Adds an expected parameter to the service builder.
         * @param param The parameter to add.
         * @return Returns a builder.
         */
        public Builder expectParam(final ExpectedParam param) {
            return expectParam(param.getName(), param.getType(), param.isRequired());
        }

        /**
         * Implements this service and returns an ImplementedBuilder.
         * @param serviceable A serviceable, provided as an implementation of this service.
         * @return Returns an ImplementedBuilder.
         */
        public ImplementedBuilder implement(final Serviceable serviceable) {
            return new ImplementedBuilder(serviceable, expectedParameters);
        }

    }

    /**
     * Builds services based on an implementation.
     */
    public static class ImplementedBuilder  {

        /**
         * The service's implementation.
         */
        private final Serviceable serviceable;

        /**
         * The service's expected parameters.
         */
        private final Params expectedParameters;

        /**
         * Constructs an ImplementedBuilder.
         * @param serviceable The serviceable.
         * @param expectedParameters The expected parameters.
         */
        public ImplementedBuilder(Serviceable serviceable, Params expectedParameters) {
            this.serviceable = serviceable;
            this.expectedParameters = expectedParameters;
        }

        /**
         * Builds a service object out of an ImplementedBuilder.
         * @return Returns a Service.
         * @throws ServiceParamNameException thrown when a parameter name is empty or invalid.
         * @throws NoImplementationException thrown when an implementation of this service was not provided.
         */
        public Service build() throws ServiceParamNameException, NoImplementationException {
            if (serviceable == null) {
                throw new NoImplementationException();
            }

            //Check param names:
            for (Map.Entry<String, ExpectedParam> parameter : expectedParameters.entrySet()) {
                final String paramName = parameter.getKey();
                if (paramName.trim().isEmpty()) {
                    throw new ServiceParamNameException("Service parameter names cannot be blank.");
                }
                if (!paramName.matches(SERVICE_PARAM_NAME_REGEX)) {
                    throw new ServiceParamNameException("The service parameter name '" + paramName + "' provided is not valid. Service parameter names must start with a letter or underscore, followed by letters, numbers or underscores.");
                }
            }
            return new Service(expectedParameters, serviceable);
        }

    }

    /**
     * Retrieves the map of expected parameters for this service.
     * @return Returns a ParamsMap.
     */
    public Params getExpectedParams() {
        return expectedParams;
    }

    /**
     * Retrieves the map of received parameters for this service.
     * @return Returns an InputParamsMap.
     */
    public InputParams getReceivedParams() {
        return receivedParams;
    }

    /**
     * Retrieves the serviceable for this service.
     * @return Returns a Serviceable.
     */
    public Serviceable getServiceable() {
        return serviceable;
    }

}
