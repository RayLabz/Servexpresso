package com.raylabz.servexpresso.response;

import com.google.gson.JsonObject;
import com.raylabz.responz.ErrorResponse;
import com.raylabz.responz.JsonUtil;
import com.raylabz.servexpresso.error.MissingParamError;
import com.raylabz.servexpresso.error.ServiceParamErrorType;
import com.raylabz.servexpresso.error.SimpleError;

import java.util.ArrayList;

/**
 * Models a missing parameter error response.
 */
public class MissingParametersResponse extends ErrorResponse {

    /**
     * Constructs a MissingParametersResponse.
     * @param missingParamErrors A list of MissingParamError that occurred.
     */
    public MissingParametersResponse(ArrayList<MissingParamError> missingParamErrors) {
        super("Missing parameters", "");
        StringBuilder errorStringBuilder = new StringBuilder();
        ArrayList<SimpleError> simpleErrors = new ArrayList<>();
        for (MissingParamError error : missingParamErrors) {
            simpleErrors.add(new SimpleError(ServiceParamErrorType.MISSING_PARAM, error.getServiceParam().getName()));
        }

        if (simpleErrors.size() > 1) {
            errorStringBuilder = new StringBuilder("Missing parameters: ");
            for (SimpleError e : simpleErrors) {
                errorStringBuilder.append(e.getParamName()).append(", ");
            }
            errorStringBuilder.delete(errorStringBuilder.length() - 2, errorStringBuilder.length());
            errorStringBuilder.append(".");
        }
        else {
            errorStringBuilder.append(missingParamErrors.get(0).getMessage());
        }

        setMessage(errorStringBuilder.toString());
        JsonObject data = new JsonObject();
        data.add("errors", JsonUtil.listToJsonArray(simpleErrors));
        setData(data);
    }

}
