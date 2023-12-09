package com.moittie.hamsterserver.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class ApiException extends RuntimeException {
    private HttpStatus status;
    private ApiErrorCode errorCode;
}
