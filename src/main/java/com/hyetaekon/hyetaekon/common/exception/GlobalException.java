package com.hyetaekon.hyetaekon.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    ErrorCode errorCode;
}
