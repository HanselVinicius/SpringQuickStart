package com.vh.springquickstart.configuration.beans;

import com.vh.springquickstart.core.providers.infra.GetSubjectInfraProvider;
import com.vh.springquickstart.core.usecase.GetSubjectUseCase;
import com.vh.springquickstart.core.usecase.impl.GetSubjectUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetSubjectUseCaseConfig {

    @Bean
    public GetSubjectUseCase getSubjectUseCase(GetSubjectInfraProvider getSubjectInfraProvider) {
        return new GetSubjectUseCaseImpl(getSubjectInfraProvider);
    }


}
