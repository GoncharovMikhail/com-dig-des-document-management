package com.dig.des.document.management.repository.document;

import com.dig.des.document.management.entity.document.DocumentEntity;
import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.security.access.annotation.Secured;

public interface DocumentRepository extends RevisionRepository<DocumentEntity, Long, Long>,
    JpaRepository<DocumentEntity, Long> {

    @Secured("hasAnyRole()")
    DocumentEntity findOneByTitle(String title);
}
