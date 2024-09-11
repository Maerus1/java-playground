package com.example.reflection.reflectionapi.Repositories;

import com.example.reflection.reflectionapi.Models.Country.Country;
import com.example.reflection.reflectionapi.Models.House.House;
import com.example.reflection.reflectionapi.Util.RedisClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseRepo {

    private final RedisClient redisClient;

    private final ObjectMapper objectMapper;

    public HouseRepo(RedisClient redisClient, ObjectMapper objectMapper) {
        this.redisClient = redisClient;
        this.objectMapper = objectMapper;
    }

    public List<House> getHouses() {

        Country canada = Country.CANADA;

        System.out.println("Your country: " + canada.getCountryName());

        // Store/retrieve redis entry here
        String houseKey = "houses";

        String housesJSON = null;

        housesJSON = this.redisClient.getValue(houseKey);

        List<House> houses = null;

        if (housesJSON == null) {

            System.out.println("Not cached");
            houses = List.of(
                    new House.Builder().address("123 Fake Street").build(),
                    new House.Builder().address("928 NotReal Ave").build()
            );

            try {
                housesJSON = objectMapper.writer().writeValueAsString(houses);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            this.redisClient.setValue(houseKey, housesJSON);
        }

        System.out.println(housesJSON);

        try {
            houses = objectMapper.readValue(housesJSON, new TypeReference<>() {});
            System.out.println(houses);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return houses;
    }
}
