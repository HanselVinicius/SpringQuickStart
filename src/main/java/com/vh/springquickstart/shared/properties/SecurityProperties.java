package com.vh.springquickstart.shared.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SecurityProperties {

    @Value("${api.security.token.secret}")
    private String secret;

    @Value("api.security.token.issuer")
    private String issuer;

    @Bean
    public String getSecret() {
        return secret;
    }

    @Bean
    public String getIssuer() {
        return issuer;
    }


}
