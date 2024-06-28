package com.library.management.external_catalog_integration_service.controller;

import com.library.management.external_catalog_integration_service.client.BookResponse;
import com.library.management.external_catalog_integration_service.service.ExternalCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/external-catalog")
public class ExternalCatalogController {

    @Autowired
    private ExternalCatalogService externalCatalogService;

    @GetMapping("/book")
    public BookResponse getBookByIsbn(@RequestParam String isbn) {
        return externalCatalogService.getBookByIsbn(isbn);
    }
}
