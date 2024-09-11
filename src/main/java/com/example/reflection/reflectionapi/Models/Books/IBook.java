package com.example.reflection.reflectionapi.Models.Books;

public interface IBook {

    // STATIC METHODS CANNOT BE OVERRIDDEN!!!
    static IBook newBook(String bookType) {
        return switch (bookType.toUpperCase()) {
            case "COMIC" -> new Comic();
            case "NOVEL" -> new Novel();
            case "TEXTBOOK" -> new Textbook();
            default -> null;
        };
    }

    String getBookType();
}
