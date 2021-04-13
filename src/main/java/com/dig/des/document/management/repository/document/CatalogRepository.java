package com.dig.des.document.management.repository.document;

import com.dig.des.document.management.entity.document.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.security.access.annotation.Secured;

public interface CatalogRepository extends RevisionRepository<CatalogEntity, Long, Long>,
    JpaRepository<CatalogEntity, Long> {

    // TODO: 13.04.2021 это здесь нужно?
    @Secured("hasAnyRole()")
    CatalogEntity findOneByTitle(String title);
}
