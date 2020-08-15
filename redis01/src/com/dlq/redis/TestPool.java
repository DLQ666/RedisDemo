package com.dlq.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *@program: RedisDemo
 *@description:
 *@author: Hasee
 *@create: 2020-08-15 22:13
 */
public class TestPool {
    public static void main(String[] args) {

        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();

        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set("aa","bb");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtil.release(jedisPool,jedis);
        }
    }
}
