package com.stockcar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroResponse {

    private int status;
    private String message;
}
