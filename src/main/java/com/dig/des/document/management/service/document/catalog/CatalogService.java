package com.dig.des.document.management.service.document.catalog;

import com.dig.des.document.management.entity.document.CatalogEntity;

public interface CatalogService {

    CatalogEntity findOneByTitle(String title);
}
