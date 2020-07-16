package com.raylabz.servexpresso;

/**
 * Models expected parameters that are passed to services.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public class ExpectedParam extends ServiceParam {

    /**
     * The parameter's type.
     */
    private final ParamType type;

    /**
     * Determines whether or not a parameter is required when a service is called.
     */
    private final boolean required;

    /**
     * Constructs a new ServiceParam.
     * @param name The parameter name.
     * @param type The parameter type.
     * @param required Whether or not the parameter will be required.
     */
    public ExpectedParam(String name, ParamType type, boolean required) {
        super(name);
        this.type = type;
        this.required = required;
    }

    /**
     * Retrieves the parameter's type.
     * @return Returns a ParamType.
     */
    public final ParamType getType() {
        return type;
    }

    /**
     * Retrieves the parameter's require attribute.
     * @return Returns true if the parameter is required, false otherwise.
     */
    public final boolean isRequired() {
        return required;
    }

}
