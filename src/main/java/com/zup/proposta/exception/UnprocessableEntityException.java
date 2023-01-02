package com.zup.proposta.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

public class UnprocessableEntityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnprocessableEntityException(String msg) {
        super(msg);
    }


}