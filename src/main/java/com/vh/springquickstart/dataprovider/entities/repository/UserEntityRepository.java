package com.vh.springquickstart.dataprovider.entities.repository;

import com.vh.springquickstart.dataprovider.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

}
