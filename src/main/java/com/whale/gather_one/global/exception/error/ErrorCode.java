package com.whale.gather_one.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    ;

    private final String code;
    private final String message;
    private final ErrorDisplayType displayType;

    public ErrorCodeDto convertToDto() {
        return ErrorCodeDto.builder()
                .message(message)
                .code(code)
                .displayType(displayType)
                .build();
    }

    public ErrorCodeDto convertToDtoWithCustomMessage(String customMessage){
        return ErrorCodeDto.builder()
                .message(customMessage)
                .code(code)
                .displayType(displayType)
                .build();
    }
}
