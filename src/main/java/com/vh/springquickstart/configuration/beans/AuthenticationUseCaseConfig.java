package com.vh.springquickstart.configuration.beans;

import com.vh.springquickstart.core.providers.infra.AuthManagerInfraProvider;
import com.vh.springquickstart.core.usecase.AuthenticateUseCase;
import com.vh.springquickstart.core.usecase.impl.AuthenticateUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationUseCaseConfig {
    @Bean
    public AuthenticateUseCase authenticateUseCase(AuthManagerInfraProvider authManagerInfraProvider){
        return new AuthenticateUseCaseImpl(authManagerInfraProvider);
    }

}