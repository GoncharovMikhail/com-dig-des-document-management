package com.dig.des.document.management.repository.security;

import com.dig.des.document.management.entity.security.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.List;

public interface RoleRepository extends RevisionRepository<RoleEntity, Long, Long>,
    JpaRepository<RoleEntity, Long> {

    List<RoleEntity> findAll();

    RoleEntity findOneByRole(String role);
}
