package com.dig.des.document.management.service.document;

import com.dig.des.document.management.entity.document.DocumentEntity;

public interface DocumentService {

    DocumentEntity findOneByTitle(String title);
}
