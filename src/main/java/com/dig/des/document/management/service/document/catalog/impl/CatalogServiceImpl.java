package com.dig.des.document.management.service.document.catalog.impl;

import com.dig.des.document.management.entity.document.CatalogEntity;
import com.dig.des.document.management.repository.document.CatalogRepository;
import com.dig.des.document.management.service.document.catalog.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public CatalogEntity findOneByTitle(String title) {
        return catalogRepository.findOneByTitle(title);
    }
}
