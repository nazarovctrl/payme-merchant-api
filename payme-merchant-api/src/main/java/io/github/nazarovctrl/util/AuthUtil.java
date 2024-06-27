package io.github.nazarovctrl.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/***
 *  The class for to simplify work with authorization
 */
@Component
public class AuthUtil {
    /***
     * Basic Authorization username
     */
    @Value("${payme.user.name}")
    private String username;
    /***
     * Basic Authorization password
     */
    @Value("${payme.user.password}")
    private String password;

    /***
     * @param authHeader Base64 encoded basic authorization header
     * @return true if the authorization is valid otherwise false
     */
    public boolean isUnauthorized(String authHeader) {
        final String basic = "Basic ";
        if (authHeader == null || !authHeader.startsWith(basic)) {
            return true;
        }
        String tokenBase64 = authHeader.substring(basic.length());
        String token = new String(Base64.getDecoder().decode(tokenBase64), StandardCharsets.UTF_8);
        String[] auth = token.split(":");
        return !username.equals(auth[0]) || !password.equals(auth[1]);
    }
}