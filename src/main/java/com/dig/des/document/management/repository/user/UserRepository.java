package com.dig.des.document.management.repository.user;

import com.dig.des.document.management.entity.user.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface UserRepository extends RevisionRepository<UserEntity, Long, Long>,
    JpaRepository<UserEntity, Long> {

    /* TODO: 13.04.2021 Это будет фетчить роли всега.
        Но они мне нужны не всегда. Отдельный метод, которые не фетчит роли, я писать не хочу.
        Как быть? */
    @EntityGraph(attributePaths = {"roles"})
    UserEntity findOneByUsername(String username);

    UserEntity findOneByEmail(String username);

    UserEntity findOneByEmailOrUsername(String email, String username);

    void deleteByUsername(String username);
}
