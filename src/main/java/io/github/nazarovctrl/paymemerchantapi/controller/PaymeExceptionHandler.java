package io.github.nazarovctrl.paymemerchantapi.controller;

import io.github.nazarovctrl.paymemerchantapi.dto.result.Error;
import io.github.nazarovctrl.paymemerchantapi.dto.result.Result;
import io.github.nazarovctrl.exp.*;

import io.github.nazarovctrl.paymemerchantapi.exp.PaymeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/***
 * Class to handle Payme exceptions and return valid responses to Payme.
 */
@ControllerAdvice
public class PaymeExceptionHandler {
    @ExceptionHandler({PaymeException.class})
    private ResponseEntity<Result> handler(PaymeException e) {
        return ResponseEntity.ok(new Result(new Error(e.getCode(), e.getMessage(), e.getData())));
    }
}
