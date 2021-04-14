package com.dig.des.document.management.service.user;

import com.dig.des.document.management.entity.user.UserEntity;

public interface UserService {

    UserEntity findOneByUsername(String username);

    UserEntity findOneByEmail(String username);

    void deleteByUsername(String username);

    void saveUser(UserEntity userEntity);
}
