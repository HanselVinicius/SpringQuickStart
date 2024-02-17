package com.vh.springquickstart.dataprovider.impl;

import com.vh.springquickstart.core.providers.RegisterUserDataProvider;
import com.vh.springquickstart.dataprovider.entities.UserEntity;
import com.vh.springquickstart.dataprovider.entities.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserDataProviderImpl implements RegisterUserDataProvider {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public void register(String username, String password) {
        String hashPassword = new BCryptPasswordEncoder().encode(password);
        UserEntity userEntity = new UserEntity(username, hashPassword);
        userEntityRepository.save(userEntity);
    }
}
