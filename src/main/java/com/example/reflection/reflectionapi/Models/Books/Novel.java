package com.example.reflection.reflectionapi.Models.Books;

public class Novel implements IBook {
    @Override
    public String getBookType() {
        return Novel.class.getSimpleName();
    }
}
