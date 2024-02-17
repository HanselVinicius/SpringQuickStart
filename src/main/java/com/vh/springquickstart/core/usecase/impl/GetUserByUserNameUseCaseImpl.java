package com.vh.springquickstart.core.usecase.impl;

import com.vh.springquickstart.core.domain.User;
import com.vh.springquickstart.core.providers.GetUserByUsernameDataProvider;
import com.vh.springquickstart.core.usecase.GetUserByUserNameUseCase;

public class GetUserByUserNameUseCaseImpl implements GetUserByUserNameUseCase {

    private final GetUserByUsernameDataProvider getUserByUsernameProvider;

    public GetUserByUserNameUseCaseImpl(GetUserByUsernameDataProvider getUserByUsernameProvider) {
        this.getUserByUsernameProvider = getUserByUsernameProvider;
    }

    @Override
    public User getUserByUserName(String username) {
        return this.getUserByUsernameProvider.getUserByUsername(username);
    }
}
