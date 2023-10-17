package com.att3.Atividade3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.att3.Atividade3.dtos.ApiErrorDTO;
import com.att3.Atividade3.exceptions.RegraNegociosExceptions;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {

        @ExceptionHandler(RegraNegociosExceptions.class)
        public ApiErrorDTO handleRegraNegocioExceptions(
            RegraNegociosExceptions ex) {
                String message = ex.getMessage();
                return new ApiErrorDTO(message);
            }
}
