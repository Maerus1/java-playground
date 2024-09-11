package com.example.reflection.reflectionapi.Models.Country;

public enum Country {
    CANADA;

    public String getCountryName() {
        return CANADA.name();
    }
}
