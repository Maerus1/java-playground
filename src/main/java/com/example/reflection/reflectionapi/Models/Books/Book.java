package com.example.reflection.reflectionapi.Models.Books;

public interface Book {
    static Book newBook(String bookType) {
        return switch (bookType.toUpperCase()) {
            case "COMIC" -> new Comic();
            case "NOVEL" -> new Novel();
            case "TEXTBOOK" -> new Textbook();
            default -> null;
        };
    }
}
