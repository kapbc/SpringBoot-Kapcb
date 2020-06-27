package com.kapcb.ccc.configure;

import com.kapcb.ccc.domain.Dept;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.time.Duration;

/**
 * <a>Title:RedisConfigure</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/26 10:48
 */
@Configuration
public class RedisConfigure {

    /**
     * 自定义序列化规则
     *
     * @param redisConnectionFactory RedisConnectionFactory
     * @return RedisTemplate<Object, Dept>
     * @throws UnknownHostException Exception
     */
    @Bean
    public RedisTemplate<Object, Dept> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Dept> template = new RedisTemplate<Object, Dept>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Dept> redisSerializer = new Jackson2JsonRedisSerializer<>(Dept.class);
        template.setDefaultSerializer(redisSerializer);
        return template;
    }

    /**
     * CacheManagerCustomizers 可以定制缓存的一些规则
     *
     * @param redisConnectionFactory RedisConnectionFactory
     * @return CacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofDays(1))
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration).build();
    }
}
