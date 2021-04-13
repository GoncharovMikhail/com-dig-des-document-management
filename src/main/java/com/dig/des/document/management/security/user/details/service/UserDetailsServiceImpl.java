package com.dig.des.document.management.security.user.details.service;

import com.dig.des.document.management.entity.user.UserEntity;
import com.dig.des.document.management.repository.user.UserRepository;
import com.dig.des.document.management.security.user.details.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("No user with username: " + username + " was found.");
        }

        return new ApplicationUserDetails(userEntity);
    }
}
