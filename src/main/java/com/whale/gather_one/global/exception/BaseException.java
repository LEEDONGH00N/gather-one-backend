package com.whale.gather_one.global.exception;

import com.whale.gather_one.global.exception.error.ErrorCode;
import com.whale.gather_one.global.exception.response.ErrorResponse;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final ErrorCode code;
    private String customErrorMessage;

    private BaseException(ErrorCode code) {
        this.code = code;
    }

    private BaseException(ErrorCode code, final String message) {
        this.code = code;
        this.customErrorMessage = message;
    }

    public ErrorResponse generateErrorResponse(){
        if(customErrorMessage == null) {
            return ErrorResponse.fromDefault(code);
        }
        return ErrorResponse.fromCustom(code, customErrorMessage);
    }

    public static BaseException from(ErrorCode errorCode) {
        return new BaseException(errorCode);
    }

    public static BaseException from(ErrorCode errorCode, final String customErrorMessage){
        return new BaseException(errorCode, customErrorMessage);
    }
}
