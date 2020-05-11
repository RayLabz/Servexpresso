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
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<SimpleError> simpleErrors = new ArrayList<>();
        for (MissingParamError error : missingParamErrors) {
            stringBuilder.append(error.getMessage()).append(System.lineSeparator());
            simpleErrors.add(new SimpleError(ServiceParamErrorType.MISSING_PARAM, error.getServiceParam().getName()));
        }
        if (missingParamErrors.size() < 2) {
            stringBuilder.delete(stringBuilder.length() - System.lineSeparator().length(), stringBuilder.length());
        }
        setMessage(stringBuilder.toString());
        JsonObject data = new JsonObject();
        data.add("errors", JsonUtil.listToJsonArray(simpleErrors));
        setData(data);
    }

}
