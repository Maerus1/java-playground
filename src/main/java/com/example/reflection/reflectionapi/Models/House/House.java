package com.example.reflection.reflectionapi.Models.House;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;

// Jackson requires a couple annotations to be able to deserialize JSON strings into a class leveraging the builder pattern
@JsonDeserialize(builder = House.Builder.class)
@Getter
public class House {

    private final String address;

    House(Builder builder) {
        this.address = builder.address;
    }

    public static class Builder {
        public String address;

        @JsonProperty
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
