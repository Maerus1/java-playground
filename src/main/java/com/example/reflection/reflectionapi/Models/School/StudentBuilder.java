package com.example.reflection.reflectionapi.Models.School;

import lombok.Getter;

@Getter
public class StudentBuilder {

    private final String firstName;
    private final String lastName;

    StudentBuilder(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder build() {
            return new StudentBuilder(this);
        }
    }
}
