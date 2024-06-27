package com.library.management.external_catalog_integration_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "isbnDbClient", url = "https://api2.isbndb.com")
public interface ExternalCatalogClient {

    @GetMapping("/book/{isbn}")
    BookResponse getBookByIsbn(@RequestParam("isbn") String isbn);
}
