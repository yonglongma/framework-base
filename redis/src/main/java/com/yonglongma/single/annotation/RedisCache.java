package com.yonglongma.single.annotation;

import org.springframework.cache.Cache;
import redis.clients.jedis.Jedis;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import redis.clients.jedis.JedisPool;


/**
 * Author MaYongLong
 * Create in 19:33 2017/9/11
 * Description
 */
public class RedisCache implements Cache {

    private static Logger logger = LogManager.getLogger(RedisCache.class);
    private String id;
    private Jedis redisClient = createRedis();//创建一个jedis连接
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();//读写锁

    public void setReadWriteLock(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instance requires an ID");
        }
        logger.debug("create an cache instance with id");
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    //从连接池中获取redis连接
    private static Jedis createRedis() {
        Jedis jedis = RedisPool.getPool().getResource();
        return jedis;
    }

    private static JedisPool pool;

    public void putObject(Object key, Object value) {
        byte[] keybyte = SerializableUtil.serialize(key);
        byte[] valuebyte = SerializableUtil.serialize(value);
        this.redisClient.set(keybyte, valuebyte);
    }

    public Object getObject(Object key) {
        //缓存穿透
        byte[] values = this.redisClient.get(SerializableUtil.serialize(key));
        //算法：计算一定时间内没有命中的键，存起来 key->value
        if (values == null) {
            return null;
        }
        Object obj = SerializableUtil.unserizlize(values);
        return obj;
    }

    public Object removeObject(Object key) {
        byte[] keybyte = SerializableUtil.serialize(key);
        return this.redisClient.expire(keybyte, 0);
    }

    public void clear() {
        this.redisClient.flushDB();
    }

    public int getSize() {
        Long size = this.redisClient.dbSize();
        int s = Integer.valueOf(size + "");
        return s;
    }

    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    public String getName() {
        return null;
    }

    public Object getNativeCache() {
        return null;
    }

    public ValueWrapper get(Object o) {
        return null;
    }

    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    public void put(Object o, Object o1) {

    }

    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    public void evict(Object o) {

    }
}
