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
     * Returns the value of an input parameter using its raw (String) value.
     * @param rawValue The string-formatted raw value of the input parameter.
     * @return Returns a generic object constricted to the types listed in ServiceParamType.
     */
    public static Object parseValue(final String rawValue) {
        //Important note: The parsing order matters.
        if (isBoolean(rawValue)) return getBoolean(rawValue);
        if (isUnsignedInteger(rawValue)) return getUnsignedInteger(rawValue);
        if (isInteger(rawValue)) return getInteger(rawValue);
        if (isUnsignedLong(rawValue)) return getUnsignedLong(rawValue);
        if (isLong(rawValue)) return getLong(rawValue);
        if (isUnsignedShort(rawValue)) return getUnsignedShort(rawValue);
        if (isShort(rawValue)) return getShort(rawValue);
        if (isUnsignedDouble(rawValue)) return getUnsignedDouble(rawValue);
        if (isDouble(rawValue)) return getDouble(rawValue);
        if (isJSON(rawValue)) return getJSON(rawValue);
        return rawValue;
    }

    /**
     * Checks if a specified parameter's raw value is a valid type.
     * @param param The parameter.
     * @return Returns true if the parameter's raw value is a valid type, false otherwise.
     */
    public static boolean checkParamType(final ServiceInputParam param) {
        switch (param.getType()) {

            case BOOLEAN:
                return isBoolean(param.getRawValue());

            case UNSIGNED_DOUBLE:
                return isUnsignedDouble(param.getRawValue());

            case DOUBLE:
                return isDouble(param.getRawValue());

            case UNSIGNED_INTEGER:
                return isUnsignedInteger(param.getRawValue());

            case INTEGER:
                return isInteger(param.getRawValue());

            case UNSIGNED_LONG:
                return isUnsignedLong(param.getRawValue());

            case LONG:
                return isLong(param.getRawValue());

            case UNSIGNED_SHORT:
                return isUnsignedShort(param.getRawValue());

            case SHORT:
                return isShort(param.getRawValue());

            case JSON:
                return isJSON(param.getRawValue());

            case STRING:
                return true;

            default:
                return false;

        }
    }

}
