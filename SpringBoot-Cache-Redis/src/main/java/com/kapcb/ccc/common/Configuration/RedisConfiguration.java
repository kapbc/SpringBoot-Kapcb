package com.kapcb.ccc.common.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <a>Title: SpringBoot-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Redis Configuration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/9 18:28
 */
@Slf4j
@Configuration
public class RedisConfiguration {

    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        ObjectMapper objectMapper = new ObjectMapper();



        return redisTemplate;
    }
}
