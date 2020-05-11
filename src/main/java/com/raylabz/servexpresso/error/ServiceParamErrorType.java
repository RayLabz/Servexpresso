package com.raylabz.servexpresso.error;

/**
 * Enumerates an service parameter error type.
 */
public enum ServiceParamErrorType {

    TYPE_MISMATCH, //The type given as input does not match the expected type.
    MISSING_PARAM //The parameter was required but missing.

    ;

}
