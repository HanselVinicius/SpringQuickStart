package com.vh.springquickstart.core.usecase.impl;

import com.vh.springquickstart.core.domain.ApiSecurityException;
import com.vh.springquickstart.core.providers.infra.GetSubjectInfraProvider;
import com.vh.springquickstart.core.usecase.GetSubjectUseCase;

public class GetSubjectUseCaseImpl implements GetSubjectUseCase {


    private final GetSubjectInfraProvider getSubjectProvider;

    public GetSubjectUseCaseImpl(GetSubjectInfraProvider getSubjectProvider) {
        this.getSubjectProvider = getSubjectProvider;
    }

    @Override
    public String getSubject(String token) {
        try {
            return this.getSubjectProvider.getSubject(token);
        } catch (Exception e) {
            throw new ApiSecurityException("Invalid token.");
        }
    }
}
