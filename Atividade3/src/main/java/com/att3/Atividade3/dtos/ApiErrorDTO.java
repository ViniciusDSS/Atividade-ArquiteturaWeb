package com.att3.Atividade3.dtos;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrorDTO {
    @Getter
    private List<String> errors;

    public ApiErrorDTO(String message) {
        errors = Arrays.asList(message);
    }
}
