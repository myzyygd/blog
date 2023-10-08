package com.islide.blog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean("redisConfig1")
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisStandaloneConfiguration redisConfig1() {
        return new RedisStandaloneConfiguration();
    }

    @Bean("redisFactory1")
    @Primary
    public LettuceConnectionFactory redisFactory1(@Qualifier("redisConfig1") RedisStandaloneConfiguration redisConfig1) {
        return new LettuceConnectionFactory(redisConfig1);
    }

    @Bean("redisTemplate1")
    public RedisTemplate<String, String> redisTemplate1(@Qualifier("redisFactory1") LettuceConnectionFactory factory) {
        return getStringStringRedisTemplate(factory);
    }


    @Bean("redisConfig4")
    @ConfigurationProperties(prefix = "spring.redis4")
    public RedisStandaloneConfiguration redisConfig4() {
        return new RedisStandaloneConfiguration();
    }

    @Bean("redisFactory4")
    public LettuceConnectionFactory redisFactory4(@Qualifier("redisConfig4") RedisStandaloneConfiguration redisConfig4) {
        return new LettuceConnectionFactory(redisConfig4);
    }

    @Bean("redisTemplate4")
    public RedisTemplate<String, String> redisTemplate4(@Qualifier("redisFactory4") LettuceConnectionFactory factory) {
        return getStringStringRedisTemplate(factory);
    }


    private RedisTemplate<String, String> getStringStringRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> template = new RedisTemplate<String, String>();
        template.setConnectionFactory(factory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        // value序列化方式采用jackson
        template.setValueSerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(stringRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}