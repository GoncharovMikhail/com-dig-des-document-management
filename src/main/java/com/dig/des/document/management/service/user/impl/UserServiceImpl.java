package com.dig.des.document.management.service.user.impl;

import com.dig.des.document.management.entity.user.UserEntity;
import com.dig.des.document.management.exception.CantSaveUserException;
import com.dig.des.document.management.repository.user.UserRepository;
import com.dig.des.document.management.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findOneByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public UserEntity findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public void saveUser(UserEntity userEntity) throws CantSaveUserException {
        if (!isUserValidForSaving(userEntity)) {
            throw new CantSaveUserException();
        }
        userRepository.save(userEntity);
    }

    private boolean isUserValidForSaving(UserEntity userEntity) {
        return userRepository.findOneByEmailOrUsername(userEntity.getEmail(), userEntity.getUsername()) == null;
    }
}
