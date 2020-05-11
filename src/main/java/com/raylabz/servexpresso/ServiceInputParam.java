package com.raylabz.servexpresso;

/**
 * Models a service param that has been attached an input value.
 */
public class ServiceInputParam extends ServiceParam {

    /**
     * The parsed values.
     */
    private final Object[] values;

    /**
     * The raw string-based values (Array of Strings).
     */
    private final String[] rawValues;

    /**
     * Instantiates a new input parameter.
     * @param name The name of the parameter.
     * @param type The type of the parameter.
     * @param rawValues The raw values of the parameter - in string format.
     */
    public ServiceInputParam(String name, ParamType type, String... rawValues) {
        super(name, type, false);
        this.rawValues = rawValues;
        this.values = TypeParser.parseValues(rawValues);
    }

    /**
     * Instantiates a new input parameter.
     * @param name The name of the parameter.
     * @param type The type of the parameter.
     * @param values The raw value of the parameter as an object.
     */
    public ServiceInputParam(String name, ParamType type, Object... values) {
        super(name, type, false);
        this.values = values;
        this.rawValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            rawValues[i] = values[i].toString();
        }
    }

    /**
     * Retrieves the values of this parameter.
     * @return Returns a generic Object.
     */
    public Object[] getValues() {
        return values;
    }

    /**
     * Retrieves the raw values of this input parameter.
     * @return Returns an array of string-formatted values.
     */
    public String[] getRawValues() {
        return rawValues;
    }

}
