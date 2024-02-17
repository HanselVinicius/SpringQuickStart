package com.vh.springquickstart.dataprovider.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vh.springquickstart.core.providers.infra.AuthManagerInfraProvider;
import com.vh.springquickstart.dataprovider.entities.UserEntity;
import com.vh.springquickstart.shared.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class AuthManagerInfraProviderImpl implements AuthManagerInfraProvider {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private SecurityProperties securityProperties;


    @Override
    public String authenticate(String username, String password) {
        var token = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return generateToken((UserEntity) token.getPrincipal());
    }

    private String generateToken(UserEntity user) {
        var algorithm = Algorithm.HMAC256(securityProperties.getSecret());
        return JWT.create()
                .withIssuer(securityProperties.getIssuer())
                .withSubject(user.getUsername())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


}