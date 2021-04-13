package com.dig.des.document.management.service.document.impl;

import com.dig.des.document.management.entity.document.DocumentEntity;
import com.dig.des.document.management.repository.document.DocumentRepository;
import com.dig.des.document.management.service.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public DocumentEntity findOneByTitle(String title) {
        return documentRepository.findOneByTitle(title);
    }
}
