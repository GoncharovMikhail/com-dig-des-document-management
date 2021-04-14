package com.dig.des.document.management.service.document.document.impl;

import com.dig.des.document.management.entity.document.DocumentEntity;
import com.dig.des.document.management.repository.document.DocumentRepository;
import com.dig.des.document.management.service.document.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public void saveDocument(DocumentEntity documentEntity) {
        documentRepository.save(documentEntity);
    }

    @Override
    public DocumentEntity findOneByTitle(String title) {
        return documentRepository.findOneByTitle(title);
    }

    @Override
    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public DocumentEntity findOneById(Long id) {
        return documentRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }
}
