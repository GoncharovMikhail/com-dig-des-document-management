package com.dig.des.document.management.repository.support;

import com.dig.des.document.management.entity.support.ResetPasswordTokenEntity;
import com.dig.des.document.management.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordTokenEntity, Long> {

    ResetPasswordTokenEntity findOneByToken(String token);

    ResetPasswordTokenEntity findOneByUserId(UserEntity usersId);
}
