package com.example.reflection.reflectionapi.Models.Books;

public class Textbook implements IBook {

    @Override
    public String getBookType() {
        return Textbook.class.getSimpleName();
    }
}
