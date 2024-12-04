package com.whale.gather_one.global.exception.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.whale.gather_one.global.exception.error.ErrorCodeDto;
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

    public static ErrorResponse onFailure(ErrorCodeDto errorCodeDto){
        return new ErrorResponse(errorCodeDto.code, errorCodeDto.message, errorCodeDto.displayType);
    }
}
