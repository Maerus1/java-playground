package com.example.reflection.reflectionapi.Models.Books;

public class EBook {

    public static EBook newBook(String bookType) {
        return switch (bookType.toUpperCase()) {
//            case "COMIC" -> new Comic();
//            case "NOVEL" -> new Novel();
//            case "TEXTBOOK" -> new Textbook();
            default -> null;
        };
    }
}
