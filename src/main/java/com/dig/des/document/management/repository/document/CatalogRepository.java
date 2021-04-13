package com.dig.des.document.management.repository.document;

import com.dig.des.document.management.entity.document.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface CatalogRepository extends RevisionRepository<CatalogEntity, Long, Long>,
    JpaRepository<CatalogEntity, Long> {

    CatalogEntity findOneByTitle(String title);
}
