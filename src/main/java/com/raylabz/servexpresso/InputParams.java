package com.raylabz.servexpresso;

import com.raylabz.servexpresso.exception.ValueIndexOutOfRangeException;

import java.util.HashMap;
import java.util.Map;

/**
 * Models an input parameters map.
 */
public class InputParams extends HashMap<String, ServiceInputParam> {

    /**
     * Checks if values exist for a parameter name.
     * @param paramName The parameter name.
     * @return Returns boolean - true if the parameter exists, false otherwise.
     */
    public final boolean paramExists(final String paramName) {
        return get(paramName) != null;
    }

    /**
     * Retrieves the number of values provided for a parameter.
     * @param paramName The parameter's name.
     * @return Returns an integer.
     */
    public final int countParamValues(final String paramName) {
        return get(paramName).getValues().length;
    }

    /**
     * Retrieves a boolean parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a boolean.
     */
    public boolean getBoolean(final String paramName) {
        return (boolean) get(paramName).getValues()[0];
    }

    /**
     * Retrieves a boolean value for a parameter.
     * @param paramName The parameter's name to retrieve.
     * @param index The index of the value.
     * @return Returns a boolean.
     */
    public boolean getBoolean(final String paramName, final int index) throws ValueIndexOutOfRangeException {
        final int valueCount = countParamValues(paramName);
        if (index >= valueCount) {
            throw new ValueIndexOutOfRangeException(index, paramName, valueCount);
        }
        return (boolean) get(paramName).getValues()[index];
    }

    /**
     * Retrieves a boolean array for a parameter.
     * @param paramName The parameter's name.
     * @return Returns a boolean array.
     */
    public boolean[] getBooleanArray(final String paramName) {
        boolean[] values = new boolean[countParamValues(paramName)];
        for (int i = 0; i < countParamValues(paramName); i++) {
            values[i] = getBoolean(paramName, i);
        }
        return values;
    }

    /**
     * Retrieves an integer parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns an integer.
     */
    public int getInt(final String paramName) {
        return (int) get(paramName).getValues()[0];
    }

    /**
     * Retrieves an integer value for a parameter.
     * @param paramName The parameter's name to retrieve.
     * @param index The index of the value.
     * @return Returns an integer.
     */
    public int getInt(final String paramName, final int index) throws ValueIndexOutOfRangeException {
        final int valueCount = countParamValues(paramName);
        if (index >= valueCount) {
            throw new ValueIndexOutOfRangeException(index, paramName, valueCount);
        }
        return (int) get(paramName).getValues()[index];
    }

    /**
     * Retrieves an integer array for a parameter.
     * @param paramName The parameter's name.
     * @return Returns an integer array.
     */
    public int[] getIntegerArray(final String paramName) {
        int[] values = new int[countParamValues(paramName)];
        for (int i = 0; i < countParamValues(paramName); i++) {
            values[i] = getInt(paramName, i);
        }
        return values;
    }

    /**
     * Retrieves a long parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a long.
     */
    public long getLong(final String paramName) {
        return (long) get(paramName).getValues()[0];
    }

    /**
     * Retrieves a long value for a parameter.
     * @param paramName The parameter's name to retrieve.
     * @param index The index of the value.
     * @return Returns a long.
     */
    public long getLong(final String paramName, final int index) throws ValueIndexOutOfRangeException {
        final int valueCount = countParamValues(paramName);
        if (index >= valueCount) {
            throw new ValueIndexOutOfRangeException(index, paramName, valueCount);
        }
        return (long) get(paramName).getValues()[index];
    }

    /**
     * Retrieves a long array for a parameter.
     * @param paramName The parameter's name.
     * @return Returns a long array.
     */
    public long[] getLongArray(final String paramName) {
        long[] values = new long[countParamValues(paramName)];
        for (int i = 0; i < countParamValues(paramName); i++) {
            values[i] = getLong(paramName, i);
        }
        return values;
    }

    /**
     * Retrieves a short parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a short.
     */
    public short getShort(final String paramName) {
        return (short) get(paramName).getValues()[0];
    }

    /**
     * Retrieves a short value for a parameter.
     * @param paramName The parameter's name to retrieve.
     * @param index The index of the value.
     * @return Returns a short.
     */
    public short getShort(final String paramName, final int index) throws ValueIndexOutOfRangeException {
        final int valueCount = countParamValues(paramName);
        if (index >= valueCount) {
            throw new ValueIndexOutOfRangeException(index, paramName, valueCount);
        }
        return (short) get(paramName).getValues()[index];
    }

    /**
     * Retrieves a short array for a parameter.
     * @param paramName The parameter's name.
     * @return Returns a short array.
     */
    public short[] getShortArray(final String paramName) {
        short[] values = new short[countParamValues(paramName)];
        for (int i = 0; i < countParamValues(paramName); i++) {
            values[i] = getShort(paramName, i);
        }
        return values;
    }

    /**
     * Retrieves a double parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a double.
     */
    public double getDouble(final String paramName) {
        return (double) get(paramName).getValues()[0];
    }

    /**
     * Retrieves a double value for a parameter.
     * @param paramName The parameter's name to retrieve.
     * @param index The index of the value.
     * @return Returns a double.
     */
    public double getDouble(final String paramName, final int index) throws ValueIndexOutOfRangeException {
        final int valueCount = countParamValues(paramName);
        if (index >= valueCount) {
            throw new ValueIndexOutOfRangeException(index, paramName, valueCount);
        }
        return (double) get(paramName).getValues()[index];
    }

    /**
     * Retrieves a double array for a parameter.
     * @param paramName The parameter's name.
     * @return Returns a double array.
     */
    public double[] getDoubleArray(final String paramName) {
        double[] values = new double[countParamValues(paramName)];
        for (int i = 0; i < countParamValues(paramName); i++) {
            values[i] = getDouble(paramName, i);
        }
        return values;
    }

    /**
     * Retrieves a JSON-formatted string parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a JSON-formatted string.
     */
    public String getJSON(final String paramName) {
        return (String) get(paramName).getValues()[0];
    }

    /**
     * Retrieves a JSON text value for a parameter.
     * @param paramName The parameter's name to retrieve.
     * @param index The index of the value.
     * @return Returns a JSON text string.
     */
    public String getJSON(final String paramName, final int index) throws ValueIndexOutOfRangeException {
        final int valueCount = countParamValues(paramName);
        if (index >= valueCount) {
            throw new ValueIndexOutOfRangeException(index, paramName, valueCount);
        }
        return (String) get(paramName).getValues()[index];
    }

    /**
     * Retrieves a JSON text array for a parameter.
     * @param paramName The parameter's name.
     * @return Returns a JSON string text array.
     */
    public String[] getJSONArray(final String paramName) {
        String[] values = new String[countParamValues(paramName)];
        for (int i = 0; i < countParamValues(paramName); i++) {
            values[i] = getJSON(paramName, i);
        }
        return values;
    }

    /**
     * Retrieves a string parameter from the map.
     * @param paramName The parameter's name to retrieve.
     * @return Returns a string.
     */
    public String getString(final String paramName) {
        return (String) get(paramName).getValues()[0];
    }

    /**
     * Retrieves a String value for a parameter.
     * @param paramName The parameter's name to retrieve.
     * @param index The index of the value.
     * @return Returns a string.
     */
    public String getString(final String paramName, final int index) throws ValueIndexOutOfRangeException {
        final int valueCount = countParamValues(paramName);
        if (index >= valueCount) {
            throw new ValueIndexOutOfRangeException(index, paramName, valueCount);
        }
        return (String) get(paramName).getValues()[index];
    }

    /**
     * Retrieves a JSON text array for a parameter.
     * @param paramName The parameter's name.
     * @return Returns a JSON string text array.
     */
    public String[] getStringArray(final String paramName) {
        String[] values = new String[countParamValues(paramName)];
        for (int i = 0; i < countParamValues(paramName); i++) {
            values[i] = getString(paramName, i);
        }
        return values;
    }

    /**
     * Converts a servlet parameter map (a raw Map) into an InputParamsMap.
     * @param servletParamsMap The servlet input parameters.
     * @return Returns an InputParamsMap.
     */
    public static InputParams fromServletParams(final Map servletParamsMap) {
        final Map<String, String[]> servletParamsStringMap = (Map<String, String[]>) servletParamsMap;
        InputParams inputParams = new InputParams();
        for (Map.Entry<String, String[]> entry : servletParamsStringMap.entrySet()) {
            final String paramName = entry.getKey();
            final String[] paramRawValue = entry.getValue();
            final ParamType paramType = ParamType.fromRawValues(paramRawValue);
            ServiceInputParam inputParam = new ServiceInputParam(paramName, paramType, paramRawValue);
            inputParams.put(inputParam.getName(), inputParam);
        }
        return inputParams;
    }

}
