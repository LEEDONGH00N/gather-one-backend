package com.whale.gather_one.global.exception.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ErrorCodeDto {

    public String code;
    public String message;
    public ErrorDisplayType displayType;
}
