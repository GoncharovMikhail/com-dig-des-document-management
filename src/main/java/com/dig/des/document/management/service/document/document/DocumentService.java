package com.dig.des.document.management.service.document.document;

import com.dig.des.document.management.entity.document.DocumentEntity;

public interface DocumentService {

    // TODO: 14.04.2021 (мне) написать потом дто.
    void saveDocument(DocumentEntity documentEntity);

    DocumentEntity findOneByTitle(String title);

    void deleteById(Long id);

    DocumentEntity findOneById(Long id);
}
