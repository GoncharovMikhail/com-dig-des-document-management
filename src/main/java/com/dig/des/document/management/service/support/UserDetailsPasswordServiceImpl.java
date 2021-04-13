package com.dig.des.document.management.service.support;

import com.dig.des.document.management.entity.user.UserEntity;
import com.dig.des.document.management.repository.user.UserRepository;
import com.dig.des.document.management.security.user.details.ApplicationUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// TODO: 13.04.2021 а как им пользоваться? Я думаю, что на вход надо принимать айдишник юзера и новый пароль, а тут юзердетейлс =(
@Service
public class UserDetailsPasswordServiceImpl implements UserDetailsPasswordService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserDetailsPasswordServiceImpl(UserRepository userRepository,
        AuthenticationManager authenticationManager) {

        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @Override
    @Transactional
    public UserDetails updatePassword(UserDetails user, String newPassword) throws AuthenticationException {
        String username = user.getUsername();

        /* Update {@link UserEntity} in the database */
        UserEntity userEntity = userRepository.findOneByUsername(username);
        userEntity.setPassword(newPassword);
        UserEntity userEntityAfterUpdatingPassword = userRepository.save(userEntity);

        /* Get {@link UserDetails} after updating password */
        UserDetails userDetailsAfterUpdatingPassword = new ApplicationUserDetails(userEntityAfterUpdatingPassword);
        // TODO: 13.04.2021 как тут быть?
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(
            userDetailsAfterUpdatingPassword,
            null,
            userDetailsAfterUpdatingPassword.getAuthorities()
        );

        /* Update {@link Authentication} */
        Authentication fullyAuthenticatedNewAuthentication = authenticationManager.authenticate(newAuthentication);
        /* TODO: 13.04.2021 Вообще по контракту, fullyAuthenticatedNewAuthentication может быть и null -
            это когда authenticationManager не может опредиться, суппортит ли он данный вид автонтикации или нет. Что тогда делать? */
        if (fullyAuthenticatedNewAuthentication == null) {

        }
        SecurityContextHolder.getContext().setAuthentication(fullyAuthenticatedNewAuthentication);

        return userDetailsAfterUpdatingPassword;
    }
}
