package com.whale.gather_one.global.exception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.whale.gather_one.global.exception.error.ErrorCode;
import com.whale.gather_one.global.exception.error.ErrorDisplayType;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
@JsonPropertyOrder({"code", "message", "displayType"})
public class ErrorResponse {

    @JsonProperty("code")
    private final String code;
    private final String message;
    private final ErrorDisplayType displayType;

    public static ErrorResponse fromDefault(ErrorCode errorCode){
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage(), errorCode.getDisplayType());
    }

    public static ErrorResponse fromCustom(ErrorCode errorCode, String customMessage){
        return new ErrorResponse(errorCode.getCode(), customMessage, errorCode.getDisplayType());
    }
}
