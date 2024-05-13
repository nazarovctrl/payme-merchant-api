package io.github.nazarovctrl.controller;

import io.github.nazarovctrl.dto.reqeust.RequestForm;
import io.github.nazarovctrl.dto.result.Result;
import io.github.nazarovctrl.exp.UnauthorizedRequest;
import io.github.nazarovctrl.service.MerchantService;

import io.github.nazarovctrl.util.AuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${payme.merchant-api.path}")
public class MerchantController {

    private final MerchantService merchantService;
    private final AuthUtil authUtil;

    public MerchantController(MerchantService merchantService, AuthUtil authUtil) {
        this.merchantService = merchantService;
        this.authUtil = authUtil;
    }

    @PostMapping
    public ResponseEntity<Result> handle(HttpServletRequest request, @RequestBody RequestForm requestForm) {
        if (authUtil.isUnauthorized(request.getHeader("Authorization"))) {
            throw new UnauthorizedRequest();
        }
        return ResponseEntity.ok(merchantService.handle(requestForm));
    }
}
