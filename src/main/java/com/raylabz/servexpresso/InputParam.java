package com.raylabz.servexpresso;

/**
 * Models a service param that has been attached an input value.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public class InputParam extends ServiceParam {

    /**
     * The parsed values.
     */
    private Object[] values;

    /**
     * The raw string-based values (Array of Strings).
     */
    private final String[] rawValues;

    /**
     * Instantiates a new input parameter.
     * @param name The name of the parameter.
     * @param rawValues The raw values of the parameter - in string format.
     */
    public InputParam(String name, String... rawValues) {
        super(name);
        this.rawValues = rawValues;
    }

    /**
     * Instantiates a new input parameter.
     * @param name The name of the parameter.
     * @param values The raw value of the parameter as an object.
     */
    public InputParam(String name, Object... values) {
        super(name);
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
     * Sets the values for this parameter.
     * @param values The values (Object[]).
     */
    public void setValues(Object[] values) {
        this.values = values;
    }

    /**
     * Retrieves the raw values of this input parameter.
     * @return Returns an array of string-formatted values.
     */
    public String[] getRawValues() {
        return rawValues;
    }

}
