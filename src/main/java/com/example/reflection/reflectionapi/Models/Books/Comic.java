package com.example.reflection.reflectionapi.Models.Books;

public class Comic implements IBook {

    @Override
    public String getBookType() {
        return Comic.class.getSimpleName();
    }
}
