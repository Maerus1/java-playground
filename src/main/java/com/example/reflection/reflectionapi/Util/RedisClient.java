package com.example.reflection.reflectionapi.Util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisClient implements InitializingBean{

    private Jedis jedis;

    @Value("${spring.data.redis.port}")
    private Integer redisPort;

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${redis.enabled}")
    private Boolean redisEnabled;

    public void setValue(String key, String value) {
        if(redisEnabled) {
            jedis.set(key, value);
        }
    }

    public String getValue(String key) {
        String redisValue = "";
        if(redisEnabled) {
            redisValue = jedis.get(key);
        }
        return redisValue;
    }

    // You *can* do this, and it will work, but this isn't a @Bean's purpose. @Bean is meant to return an instance of a class that can
    // be managed by the Spring IoC Container. It's most commonly used with @Configuration classes as a way to instantiate objects that need those configs
//    @Bean
//    public void connectRedis() {
//        if(redisEnabled) {
//            // TODO: Look into error handling this properly!
//            JedisPool pool = new JedisPool(redisHost, redisPort);
//            this.jedis = pool.getResource();
//            System.out.println("Redis is connected!!!");
//        } else {
//            System.out.println("Redis is NOT connected!!");
//        }
//    }

    // This is the right tool for the job to do our logic for a @Component, where we initialize the bean first, and then after it's initialized we do ANY kind of logic
    // The nice thing about this approach is that this is the intended use, and it allows us to leverage the field-level prop anywhere in our class.
    @Override
    public void afterPropertiesSet() throws Exception {
        // Connect to redis here!!! This lets me perform custom logic on startup, like connecting to redis!
        // Otherwise I'd need to connect to redis in the Controller or elsewhere

        if(redisEnabled) {
            // TODO: Look into error handling this properly!
            JedisPool pool = new JedisPool(redisHost, redisPort);
            this.jedis = pool.getResource();
            System.out.println("Redis is connected!!!");
        } else {
            System.out.println("Redis is NOT connected!!");
        }
    }
}
