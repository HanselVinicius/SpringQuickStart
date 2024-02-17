package com.vh.springquickstart.dataprovider.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.vh.springquickstart.core.providers.infra.GetSubjectInfraProvider;
import com.vh.springquickstart.shared.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetSubjectInfraProviderImpl implements GetSubjectInfraProvider {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public String getSubject(String token) {
        var algorithm = Algorithm.HMAC256(securityProperties.getSecret());
        return JWT.require(algorithm)
                .withIssuer(securityProperties.getIssuer())
                .build()
                .verify(token.trim())
                .getSubject();
    }
}
