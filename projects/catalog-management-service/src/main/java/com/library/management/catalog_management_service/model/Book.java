package com.library.management.catalog_management_service.model;



@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private Double price;

    // Getters and Setters
}
