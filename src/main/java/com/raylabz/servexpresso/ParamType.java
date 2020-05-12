package com.raylabz.servexpresso;

import com.google.gson.JsonElement;

/**
 * Models the possible types of service parameters.
 */
public enum ParamType {

    BOOLEAN(boolean.class),

    DOUBLE(double.class),
    LONG(long.class),
    INTEGER(int.class, LONG),
    SHORT(short.class, INTEGER, LONG),

    UNSIGNED_DOUBLE(double.class, DOUBLE),
    UNSIGNED_LONG(long.class, LONG),
    UNSIGNED_INTEGER(int.class, UNSIGNED_LONG, LONG),
    UNSIGNED_SHORT(short.class, UNSIGNED_LONG, UNSIGNED_INTEGER, LONG, INTEGER),

    STRING(String.class),
    JSON(JsonElement.class, STRING),

    ;

    /**
     * Retrieves the translated type for a ServiceParameterType
     */
    private final Class<?> translatedType;

    /**
     * Defines which other ParamTypes this type can be casted into, without loss of data.
     */
    private final ParamType[] validCastTypes;

    /**
     * Instantiates a new ServiceParameterType
     * @param translatedType The runtime class that this ServiceParameterType will be translated into.
     */
    ParamType(Class<?> translatedType, ParamType... validCastTypes) {
        this.translatedType = translatedType;
        this.validCastTypes = validCastTypes;
    }

    /**
     * Retrieves the translation type for this ServiceParameterType.
     * @return Returns the translation type class.
     */
    public Class<?> getTranslatedType() {
        return translatedType;
    }

    /**
     * Parses a given rawValue and determines the type of ServiceParameterType it represents.
     * @param rawValues The array of rawValues received from the inputs.
     * @return Returns a ServiceParameterType.
     */
    public static ParamType fromRawValues(String[] rawValues) {
        //Important note: The parsing order matters.

        //Boolean check:
        boolean isBoolean = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isBoolean(rawValue)) {
                isBoolean = false;
                break;
            }
        }
        if (isBoolean) return BOOLEAN;

        //Unsigned integer check:
        boolean isUnsignedInt = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isUnsignedInteger(rawValue)) {
                isUnsignedInt = false;
                break;
            }
        }
        if (isUnsignedInt) return UNSIGNED_INTEGER;

        //Integer check:
        boolean isInt = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isInteger(rawValue)) {
                isInt = false;
                break;
            }
        }
        if (isInt) return INTEGER;

        //Unsigned long check:
        boolean isUnsignedLong = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isUnsignedLong(rawValue)) {
                isUnsignedLong = false;
                break;
            }
        }
        if (isUnsignedLong) return UNSIGNED_LONG;

        //Long check:
        boolean isLong = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isLong(rawValue)) {
                isLong = false;
                break;
            }
        }
        if (isLong) return LONG;

        //Unsigned short check:
        boolean isUnsignedShort = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isUnsignedShort(rawValue)) {
                isUnsignedShort = false;
                break;
            }
        }
        if (isUnsignedShort) return UNSIGNED_SHORT;

        //Short check:
        boolean isShort = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isShort(rawValue)) {
                isShort = false;
                break;
            }
        }
        if (isShort) return SHORT;

        //Unsigned double check:
        boolean isUnsignedDouble = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isUnsignedDouble(rawValue)) {
                isUnsignedDouble = false;
                break;
            }
        }
        if (isUnsignedDouble) return UNSIGNED_DOUBLE;

        //Double check:
        boolean isDouble = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isDouble(rawValue)) {
                isDouble = false;
                break;
            }
        }
        if (isDouble) return DOUBLE;


        //JSON check:
        boolean isJSON = true;
        for (final String rawValue : rawValues) {
            if (!TypeParser.isJSON(rawValue)) {
                isJSON = false;
                break;
            }
        }
        if (isJSON) return JSON;

        return STRING;
    }

}
