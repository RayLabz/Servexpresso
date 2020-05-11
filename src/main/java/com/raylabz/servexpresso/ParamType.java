package com.raylabz.servexpresso;

import com.google.gson.JsonElement;

/**
 * Models the possible types of service parameters.
 */
public enum ParamType {

    BOOLEAN(boolean.class),
    UNSIGNED_DOUBLE(double.class),
    DOUBLE(double.class),
    UNSIGNED_INTEGER(int.class),
    INTEGER(int.class),
    UNSIGNED_LONG(long.class),
    LONG(long.class),
    UNSIGNED_SHORT(short.class),
    SHORT(short.class),
    JSON(JsonElement.class),
    STRING(String.class),

    ;

    /**
     * Retrieves the translated type for a ServiceParameterType
     */
    private Class<?> translatedType;

    /**
     * Instantiates a new ServiceParameterType
     * @param translatedType The runtime class that this ServiceParameterType will be translated into.
     */
    ParamType(Class<?> translatedType) {
        this.translatedType = translatedType;
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
     * @param rawValue A rawValue value.
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
        if (isUnsignedInt) return BOOLEAN;

        //TODO - DO THIS FOR THE REST OF THESE TYPES.


        if (TypeParser.isBoolean(rawValue)) return BOOLEAN;
        if (TypeParser.isUnsignedInteger(rawValue)) return UNSIGNED_INTEGER;
        if (TypeParser.isInteger(rawValue)) return INTEGER;
        if (TypeParser.isUnsignedLong(rawValue)) return UNSIGNED_LONG;
        if (TypeParser.isLong(rawValue)) return LONG;
        if (TypeParser.isUnsignedShort(rawValue)) return UNSIGNED_SHORT;
        if (TypeParser.isShort(rawValue)) return SHORT;
        if (TypeParser.isUnsignedDouble(rawValue)) return UNSIGNED_DOUBLE;
        if (TypeParser.isDouble(rawValue)) return DOUBLE;
        if (TypeParser.isJSON(rawValue)) return JSON;
        return STRING;
    }

}
