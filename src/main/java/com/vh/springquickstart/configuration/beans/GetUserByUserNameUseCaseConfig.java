package com.vh.springquickstart.configuration.beans;

import com.vh.springquickstart.core.providers.GetUserByUsernameDataProvider;
import com.vh.springquickstart.core.usecase.GetUserByUserNameUseCase;
import com.vh.springquickstart.core.usecase.impl.GetUserByUserNameUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetUserByUserNameUseCaseConfig {

    @Bean
    public GetUserByUserNameUseCase getUserByUserNameUseCase(GetUserByUsernameDataProvider getUserByUsernameProvider) {
        return new GetUserByUserNameUseCaseImpl(getUserByUsernameProvider);
    }

}
