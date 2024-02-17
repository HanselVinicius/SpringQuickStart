package com.vh.springquickstart.core.usecase;

import com.vh.springquickstart.core.domain.User;

public interface GetUserByUserNameUseCase {

    User getUserByUserName(String username);

}

