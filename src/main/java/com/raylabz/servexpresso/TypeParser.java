package com.raylabz.servexpresso;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.raylabz.servexpresso.exception.InvalidValueException;

/**
 * Helper class used to check if a given raw corresponds to a value of a ServiceParameterType.
 */
public class TypeParser {

    /**
     * Checks if a given raw value is a boolean.
     * @param raw The raw to check.
     * @return Returns true if the value is a boolean, false otherwise.
     */
    public static boolean isBoolean(final String raw) {
        return raw.trim().equals("true") || raw.trim().equals("false");
    }

    /**
     * Retrieves a boolean value from a raw value.
     * @param raw The raw value.
     * @return Returns a boolean.
     */
    public static boolean getBoolean(final String raw) {
        try {
            return Boolean.parseBoolean(raw);
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.BOOLEAN);
        }
    }

    /**
     * Checks if a given raw value is an unsigned double.
     * @param raw The raw to check.
     * @return Returns true if the value is an unsigned double, false otherwise.
     */
    public static boolean isUnsignedDouble(final String raw) {
        try {
            final double v = Double.parseDouble(raw);
            return (v >= 0);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves an unsigned double value from a raw value.
     * @param raw The raw value.
     * @return Returns a double.
     */
    public static double getUnsignedDouble(final String raw) {
        try {
            final double v = Double.parseDouble(raw);
            if (v >= 0) {
                return v;
            }
            else {
                throw new InvalidValueException(raw, ParamType.UNSIGNED_DOUBLE);
            }
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.UNSIGNED_DOUBLE);
        }
    }

    /**
     * Checks if a given raw value is a double.
     * @param raw The raw to check.
     * @return Returns true if the value is a double, false otherwise.
     */
    public static boolean isDouble(final String raw) {
        try {
            Double.parseDouble(raw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves a double value from a raw value.
     * @param raw The raw value.
     * @return Returns a double.
     */
    public static double getDouble(final String raw) {
        try {
            return Double.parseDouble(raw);
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.DOUBLE);
        }
    }

    /**
     * Checks if a given raw value is an unsigned integer.
     * @param raw The raw to check.
     * @return Returns true if the value is an unsigned integer, false otherwise.
     */
    public static boolean isUnsignedInteger(final String raw) {
        try {
            Integer.parseUnsignedInt(raw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves an unsigned integer value from a raw value.
     * @param raw The raw value.
     * @return Returns an integer.
     */
    public static int getUnsignedInteger(final String raw) {
        try {
            return Integer.parseUnsignedInt(raw);
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.UNSIGNED_INTEGER);
        }
    }

    /**
     * Checks if a given raw value is an integer.
     * @param raw The raw to check.
     * @return Returns true if the value is an integer, false otherwise.
     */
    public static boolean isInteger(final String raw) {
        try {
            Integer.parseInt(raw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves an integer value from a raw value.
     * @param raw The raw value.
     * @return Returns an integer.
     */
    public static int getInteger(final String raw) {
        try {
            return Integer.parseInt(raw);
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.INTEGER);
        }
    }

    /**
     * Checks if a given raw value is an unsigned long.
     * @param raw The raw to check.
     * @return Returns true if the value is an unsigned long, false otherwise.
     */
    public static boolean isUnsignedLong(final String raw) {
        try {
            Long.parseUnsignedLong(raw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves an unsigned long value from a raw value.
     * @param raw The raw value.
     * @return Returns an unsigned long.
     */
    public static long getUnsignedLong(final String raw) {
        try {
            return Long.parseUnsignedLong(raw);
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.UNSIGNED_LONG);
        }
    }

    /**
     * Checks if a given raw value is a long.
     * @param raw The raw to check.
     * @return Returns true if the value is a long, false otherwise.
     */
    public static boolean isLong(final String raw) {
        try {
            Long.parseLong(raw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves a long value from a raw value.
     * @param raw The raw value.
     * @return Returns a long.
     */
    public static long getLong(final String raw) {
        try {
            return Long.parseLong(raw);
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.LONG);
        }
    }

    /**
     * Checks if a given raw value is an unsigned short.
     * @param raw The raw to check.
     * @return Returns true if the value is an unsigned short, false otherwise.
     */
    public static boolean isUnsignedShort(final String raw) {
        try {
            final short i = Short.parseShort(raw);
            return (i >= 0);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves an unsigned short value from a raw value.
     * @param raw The raw value.
     * @return Returns a short.
     */
    public static short getUnsignedShort(final String raw) {
        try {
            short i = Short.parseShort(raw);
            if (i >= 0) {
                return i;
            }
            else {
                throw new InvalidValueException(raw, ParamType.UNSIGNED_SHORT);
            }
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.UNSIGNED_SHORT);
        }
    }

    /**
     * Checks if a given raw value is a short.
     * @param raw The raw to check.
     * @return Returns true if the value is a short, false otherwise.
     */
    public static boolean isShort(final String raw) {
        try {
            Short.parseShort(raw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves a short value from a raw value.
     * @param raw The raw value.
     * @return Returns a short.
     */
    public static short getShort(final String raw) {
        try {
            return Short.parseShort(raw);
        } catch (Exception e) {
            throw new InvalidValueException(raw, ParamType.SHORT);
        }
    }

    /**
     * Checks if a given raw value is in JSON format.
     * @param raw The raw to check.
     * @return Returns true if the value is in JSON format, false otherwise.
     */
    public static boolean isJSON(final String raw) {
        try {
            new Gson().fromJson(raw, Object.class);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    /**
     * Retrieves a JSON-formatted string passed as a raw value.
     * @param raw The raw value.
     * @return Returns a JSON-formatted string parsed from the JSON string.
     */
    public static String getJSON(final String raw) {
        return raw;
    }

    /**
     * Returns an array of raw values as object based on their raw (String) value.
     * @param param The parameter to parse the values for.
     * @param expectedType The expected type.
     * @return Returns a generic object array constricted to the types listed in ServiceParamType.
     */
    public static void parseValues(final InputParam param, final ExpectedParam expectedParam) {
        //Important note: The parsing order matters.

        final ParamType expectedType = expectedParam.getType();
        final String[] rawValues = param.getRawValues();
        Object[] rawObjects = new Object[rawValues.length];

        for (int i = 0; i < rawValues.length; i++) {

            if (isBoolean(rawValues[i]) && expectedType == ParamType.BOOLEAN) {
                rawObjects[i] = getBoolean(rawValues[i]);
            }
            else if (isUnsignedInteger(rawValues[i]) && expectedType == ParamType.UNSIGNED_INTEGER) {
                rawObjects[i] = getUnsignedInteger(rawValues[i]);
            }
            else if (isInteger(rawValues[i]) && expectedType == ParamType.INTEGER) {
                rawObjects[i] = getInteger(rawValues[i]);
            }
            else if (isUnsignedLong(rawValues[i]) && expectedType == ParamType.UNSIGNED_LONG) {
                rawObjects[i] = getUnsignedLong(rawValues[i]);
            }
            else if (isLong(rawValues[i]) && expectedType == ParamType.LONG) {
                rawObjects[i] = getLong(rawValues[i]);
            }
            else if (isUnsignedShort(rawValues[i]) && expectedType == ParamType.UNSIGNED_SHORT) {
                rawObjects[i] = getUnsignedShort(rawValues[i]);
            }
            else if (isShort(rawValues[i]) && expectedType == ParamType.SHORT) {
                rawObjects[i] = getShort(rawValues[i]);
            }
            else if (isUnsignedDouble(rawValues[i]) && expectedType == ParamType.UNSIGNED_DOUBLE) {
                rawObjects[i] = getUnsignedDouble(rawValues[i]);
            }
            else if (isDouble(rawValues[i]) && expectedType == ParamType.DOUBLE) {
                rawObjects[i] = getDouble(rawValues[i]);
            }
            else if (isJSON(rawValues[i]) && expectedType == ParamType.JSON) {
                rawObjects[i] = getJSON(rawValues[i]);
            }
            else if (expectedType == ParamType.STRING){
                rawObjects[i] = rawValues[i];
            }

        }
        param.setValues(rawObjects);
    }

    /**
     * Gets the type of a parameter based on its raw values.
     * @param param The parameter.
     * @return Returns a ParamType.
     */
    public static ParamType findType(final InputParam param, final ParamType expectedType) {

        ParamType previousType = null;
        ParamType currentType = null;

        for (int i = 0; i < param.getRawValues().length; i++) {

            if (isBoolean(param.getRawValues()[i])) {
                currentType = ParamType.BOOLEAN;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isUnsignedInteger(param.getRawValues()[i])) {
                currentType = ParamType.UNSIGNED_INTEGER;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isInteger(param.getRawValues()[i])) {
                currentType = ParamType.INTEGER;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isUnsignedLong(param.getRawValues()[i])) {
                currentType = ParamType.UNSIGNED_LONG;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isLong(param.getRawValues()[i])) {
                currentType = ParamType.LONG;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isUnsignedShort(param.getRawValues()[i])) {
                currentType = ParamType.UNSIGNED_SHORT;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isShort(param.getRawValues()[i])) {
                currentType = ParamType.SHORT;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isUnsignedDouble(param.getRawValues()[i])) {
                currentType = ParamType.UNSIGNED_DOUBLE;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isDouble(param.getRawValues()[i])) {
                currentType = ParamType.DOUBLE;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else if (isJSON(param.getRawValues()[i])) {
                currentType = ParamType.JSON;
                if (previousType != null && currentType != previousType) {
                    if (currentType.isCastableTo(expectedType)) {
                        return expectedType;
                    }
                    return ParamType.STRING;
                }
                previousType = currentType;
            }
            else {
                return ParamType.STRING;
            }
        }
        return currentType;
    }

}
