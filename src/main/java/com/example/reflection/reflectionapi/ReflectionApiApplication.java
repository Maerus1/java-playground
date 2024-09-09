package com.example.reflection.reflectionapi;

import com.example.reflection.reflectionapi.Util.RedisClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ReflectionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReflectionApiApplication.class, args);
    }

}
