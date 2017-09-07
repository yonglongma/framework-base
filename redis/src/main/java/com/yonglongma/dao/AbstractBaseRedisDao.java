package com.yonglongma.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Author MaYongLong
 * Create in 20:04 2017/9/7
 * Description
 */
public abstract class AbstractBaseRedisDao<K,V> {

    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
