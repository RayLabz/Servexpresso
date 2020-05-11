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
 */
public class TypeMismatchResponse extends ErrorResponse {

    /**
     * Constructs a TypeMismatchResponse.
     * @param typeMismatchParamErrors A list of TypeMismatchParamError that occurred.
     */
    public TypeMismatchResponse(ArrayList<TypeMismatchParamError> typeMismatchParamErrors) {
        super("Invalid parameters", "");
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<SimpleError> simpleErrors = new ArrayList<>();
        for (TypeMismatchParamError error : typeMismatchParamErrors) {
            stringBuilder.append(error.getMessage()).append(System.lineSeparator());
            simpleErrors.add(new SimpleError(ServiceParamErrorType.TYPE_MISMATCH, error.getServiceParam().getName()));
        }
        if (typeMismatchParamErrors.size() < 2) {
            stringBuilder.delete(stringBuilder.length() - System.lineSeparator().length(), stringBuilder.length());
        }
        setMessage(stringBuilder.toString());
        JsonObject data = new JsonObject();
        data.add("errors", JsonUtil.listToJsonArray(simpleErrors));
        setData(data);
    }

}
