package com.raylabz.servexpresso;

/**
 * Models a service param that has been attached an input value.
 */
public class ServiceInputParam extends ServiceParam {

    /**
     * The parsed value.
     */
    private final Object value;

    /**
     * The raw string-based value.
     */
    private final String rawValue;

    /**
     * Instantiates a new input parameter.
     * @param name The name of the parameter.
     * @param type The type of the parameter.
     * @param rawValue The raw value of the parameter - in string format.
     */
    public ServiceInputParam(String name, ParamType type, String rawValue) {
        super(name, type, false);
        this.rawValue = rawValue;
        this.value = TypeParser.parseValue(rawValue);
    }

    /**
     * Instantiates a new input parameter.
     * @param name The name of the parameter.
     * @param type The type of the parameter.
     * @param rawValue The raw value of the parameter as an object.
     */
    public ServiceInputParam(String name, ParamType type, Object rawValue) {
        super(name, type, false);
        this.rawValue = rawValue.toString();
        this.value = TypeParser.parseValue(rawValue.toString());
    }

    /**
     * Retrieves the value of this input parameter.
     * @return Returns a generic Object.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Retreieves the raw value of this input parameter.
     * @return Returns a string-formatted value.
     */
    public String getRawValue() {
        return rawValue;
    }

}
