package com.vh.springquickstart.shared.adapters;

import com.vh.springquickstart.core.domain.User;
import com.vh.springquickstart.dataprovider.entities.UserEntity;

public interface UserEntityAdapter {
    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
}
