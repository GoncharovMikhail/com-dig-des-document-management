package com.dig.des.document.management.repository.document;

import com.dig.des.document.management.entity.document.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface FileRepository extends RevisionRepository<FileEntity, Long, Long>,
    JpaRepository<FileEntity, Long> {

}
