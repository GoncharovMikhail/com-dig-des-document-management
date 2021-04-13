package com.dig.des.document.management.service.user;

import com.dig.des.document.management.entity.user.UserEntity;
import com.dig.des.document.management.exception.CantSaveUserException;
import com.dig.des.document.management.exception.NoSuchUsernameException;

public interface UserService {

    UserEntity findOneByUsername(String username);

    UserEntity findOneByEmail(String username);

    void deleteByUsername(String username) throws NoSuchUsernameException;

    /* throws CantSaveUserException для документации - как в UserDetailsService#loadUserByUsername(String) */
    void saveUser(UserEntity userEntity) throws CantSaveUserException;
}
