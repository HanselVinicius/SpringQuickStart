package com.vh.springquickstart.core.usecase.impl;

import com.vh.springquickstart.core.domain.ApiSecurityException;
import com.vh.springquickstart.core.providers.infra.AuthManagerInfraProvider;
import com.vh.springquickstart.core.usecase.AuthenticateUseCase;

public class AuthenticateUseCaseImpl implements AuthenticateUseCase {

    private final AuthManagerInfraProvider authManager;


    public AuthenticateUseCaseImpl(AuthManagerInfraProvider authManager) {
        this.authManager = authManager;
    }

    @Override
    public String authenticate(String username,String password) {
        try {
            return this.authManager.authenticate(username,password);
        } catch (Exception e) {
            throw new ApiSecurityException("Invalid username or password.");
        }
    }
}
