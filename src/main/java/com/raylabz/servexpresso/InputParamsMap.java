package com.raylabz.servexpresso;

import java.util.HashMap;
import java.util.Map;

/**
 * Models an input parameters map.
 */
public class InputParamsMap extends HashMap<String, ServiceInputParam> {

    /**
     * Retrieves a boolean parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a boolean.
     */
    public boolean getBoolean(final String paramName) {
        return (boolean) get(paramName).getValue();
    }

    /**
     * Retrieves an integer parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns an integer.
     */
    public int getInt(final String paramName) {
        return (int) get(paramName).getValue();
    }

    /**
     * Retrieves a long parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a long.
     */
    public long getLong(final String paramName) {
        return (long) get(paramName).getValue();
    }

    /**
     * Retrieves a short parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a short.
     */
    public short getShort(final String paramName) {
        return (short) get(paramName).getValue();
    }

    /**
     * Retrieves a double parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a double.
     */
    public double getDouble(final String paramName) {
        return (double) get(paramName).getValue();
    }

    /**
     * Retrieves a JSON-formatted string parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a JSON-formatted string.
     */
    public String getJSON(final String paramName) {
        return (String) get(paramName).getValue();
    }

    /**
     * Retrieves a string parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a string.
     */
    public String getString(final String paramName) {
        return (String) get(paramName).getValue();
    }

    /**
     * Converts a servlet parameter map (a raw Map) into an InputParamsMap.
     * @param servletParamsMap The servlet input parameters.
     * @return Returns an InputParamsMap.
     */
    public static InputParamsMap fromServletParams(final Map servletParamsMap) {
        final Map<String, String> servletParamsStringMap = (Map<String, String>) servletParamsMap;
        InputParamsMap inputParamsMap = new InputParamsMap();
        for (Map.Entry<String, String> entry : servletParamsStringMap.entrySet()) {
            final String paramName = entry.getKey();
            final String paramRawValue = entry.getValue();
            final ParamType paramType = ParamType.fromRawValue(paramRawValue);
            ServiceInputParam inputParam = new ServiceInputParam(paramName, paramType, paramRawValue);
            inputParamsMap.put(inputParam.getName(), inputParam);
        }
        return inputParamsMap;
    }

}
