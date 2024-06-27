package com.library.management.external_catalog_integration_service.service;

import com.library.management.external_catalog_integration_service.client.BookResponse;
import com.library.management.external_catalog_integration_service.client.ExternalCatalogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalCatalogService {

    @Autowired
    private ExternalCatalogClient externalCatalogClient;

    public BookResponse getBookByIsbn(String isbn) {
        return externalCatalogClient.getBookByIsbn(isbn);
    }
}
