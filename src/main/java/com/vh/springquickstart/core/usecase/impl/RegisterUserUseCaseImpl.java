package com.vh.springquickstart.core.usecase.impl;

import com.vh.springquickstart.core.providers.RegisterUserDataProvider;
import com.vh.springquickstart.core.usecase.GetUserByUserNameUseCase;
import com.vh.springquickstart.core.usecase.RegisterUserUseCase;

public class RegisterUserUseCaseImpl implements RegisterUserUseCase {


    private final GetUserByUserNameUseCase getUserByUserNameUseCase;

    private final RegisterUserDataProvider registerDataProvider;

    public RegisterUserUseCaseImpl(GetUserByUserNameUseCase getUserByUserNameUseCase, RegisterUserDataProvider registerDataProvider) {
        this.getUserByUserNameUseCase = getUserByUserNameUseCase;
        this.registerDataProvider = registerDataProvider;
    }

    @Override
    public void register(String username, String password) {
        if(getUserByUserNameUseCase.getUserByUserName(username) != null)
            return;
        registerDataProvider.register(username, password);
    }
}
