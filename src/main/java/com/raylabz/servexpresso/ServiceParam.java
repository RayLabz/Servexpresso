package com.raylabz.servexpresso;

/**
 * Abstract ServiceParam used for extension into InputServiceParam and ExpectedParam.
 */
public abstract class ServiceParam {

    /**
     * The parameter's name.
     */
    private final String name;

    /**
     * Constructs a new ServiceParam.
     * @param name The name of this parameter.
     */
    public ServiceParam(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of this input parameter.
     * @return Returns a String.
     */
    public String getName() {
        return name;
    }

}
