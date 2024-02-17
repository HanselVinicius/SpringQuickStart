package com.vh.springquickstart.shared.adapters.impl;

import com.vh.springquickstart.core.domain.User;
import com.vh.springquickstart.dataprovider.entities.UserEntity;
import com.vh.springquickstart.shared.adapters.UserEntityAdapter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityAdapterImpl implements UserEntityAdapter {
    @Override
    public UserEntity toUserEntity(User user) {
        return null;
    }

    @Override
    public User toUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRole()
        );
    }
}
