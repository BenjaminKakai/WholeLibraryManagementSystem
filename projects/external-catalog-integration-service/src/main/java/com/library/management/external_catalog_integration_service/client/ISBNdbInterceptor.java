package com.library.management.external_catalog_integration_service.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ISBNdbInterceptor implements RequestInterceptor {

    @Value("${isbnDb.apiKey}")
    private String apiKey;

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", apiKey);
    }
}
