package com.vh.springquickstart.dataprovider.impl;

import com.vh.springquickstart.core.domain.User;
import com.vh.springquickstart.core.providers.GetUserByUsernameDataProvider;
import com.vh.springquickstart.dataprovider.entities.UserEntity;
import com.vh.springquickstart.dataprovider.entities.repository.UserEntityRepository;
import com.vh.springquickstart.shared.mappers.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class GetUserByUsernameDataProviderImpl implements GetUserByUsernameDataProvider, UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public User getUserByUsername(String username) {
        var userEntity = (UserEntity) loadUserByUsername(username);
        if (userEntity == null) return null;
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userEntityRepository.findByUsername(username);
    }
}
