package io.github.nazarovctrl;

import io.github.nazarovctrl.dto.Result;
import io.github.nazarovctrl.util.AuthUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${payme.merchant-api.path}")
public class MerchantController {

    private final MerchantService merchantService;
    private final AuthUtil authUtil;

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    public MerchantController(MerchantService merchantService, AuthUtil authUtil) {
        this.merchantService = merchantService;
        this.authUtil = authUtil;
    }

    @PostMapping
    public ResponseEntity<String> handle(HttpServletRequest request) {
        if (authUtil.isUnauthorized(request.getHeader("Authorization"))) {
            return ResponseEntity.ok(gson.toJson(Result.unauthorized()));
        }
        //handle method
        return null;
    }

}
