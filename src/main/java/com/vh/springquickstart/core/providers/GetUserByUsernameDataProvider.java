package com.vh.springquickstart.core.providers;

import com.vh.springquickstart.core.domain.User;

public interface GetUserByUsernameDataProvider {

    User getUserByUsername(String username);

}
