package com.vh.springquickstart.configuration.beans;

import com.vh.springquickstart.core.providers.RegisterUserDataProvider;
import com.vh.springquickstart.core.usecase.GetUserByUserNameUseCase;
import com.vh.springquickstart.core.usecase.RegisterUserUseCase;
import com.vh.springquickstart.core.usecase.impl.RegisterUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterUserUseCaseConfig {

    @Bean
    public RegisterUserUseCase registerUserUseCase(GetUserByUserNameUseCase getUserByUserNameUseCase, RegisterUserDataProvider registerDataProvider){
        return new RegisterUserUseCaseImpl(getUserByUserNameUseCase,registerDataProvider);
    }

}
