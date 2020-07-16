package com.raylabz.servexpresso.response;

import com.google.gson.JsonObject;
import com.raylabz.responz.ErrorResponse;
import com.raylabz.responz.JsonUtil;
import com.raylabz.servexpresso.error.ServiceParamErrorType;
import com.raylabz.servexpresso.error.SimpleError;
import com.raylabz.servexpresso.error.TypeMismatchParamError;

import java.util.ArrayList;

/**
 * Models a parameter type mismatch error response.
 * @author Nicos Kasenides
 * @version 1.0.0
 */
public class TypeMismatchResponse extends ErrorResponse {

    /**
     * Constructs a TypeMismatchResponse.
     * @param typeMismatchParamErrors A list of TypeMismatchParamError that occurred.
     */
    public TypeMismatchResponse(ArrayList<TypeMismatchParamError> typeMismatchParamErrors) {
        super("Invalid parameters", "");
        StringBuilder errorStringBuilder = new StringBuilder();
        ArrayList<SimpleError> simpleErrors = new ArrayList<>();
        for (TypeMismatchParamError error : typeMismatchParamErrors) {
            simpleErrors.add(new SimpleError(ServiceParamErrorType.TYPE_MISMATCH, error.getServiceParam().getName()));
        }

        if (simpleErrors.size() > 1) {
            errorStringBuilder = new StringBuilder("Invalid parameters: ");
            for (SimpleError e : simpleErrors) {
                errorStringBuilder.append(e.getParamName()).append(", ");
            }
            errorStringBuilder.delete(errorStringBuilder.length() - 2, errorStringBuilder.length());
            errorStringBuilder.append(".");
        }
        else {
            errorStringBuilder.append(typeMismatchParamErrors.get(0).getMessage());
        }

        setMessage(errorStringBuilder.toString());
        JsonObject data = new JsonObject();
        data.add("errors", JsonUtil.listToJsonArray(simpleErrors));
        setData(data);
    }

}
