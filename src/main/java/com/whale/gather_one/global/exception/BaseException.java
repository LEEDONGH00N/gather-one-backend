package com.whale.gather_one.global.exception;

import com.whale.gather_one.global.exception.error.ErrorCode;
import com.whale.gather_one.global.exception.error.ErrorCodeDto;
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

    public ErrorCodeDto getErrorReason(){
        if(customErrorMessage == null) {
            return code.convertToDto();
        }
        return code.convertToDtoWithCustomMessage(customErrorMessage);
    }

    public static BaseException withDefaultMessage(ErrorCode errorCode) {
        return new BaseException(errorCode);
    }

    public static BaseException withCustomMessage(ErrorCode errorCode, final String customErrorMessage){
        return new BaseException(errorCode, customErrorMessage);
    }
}
