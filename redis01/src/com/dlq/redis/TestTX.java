package com.dlq.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 *@program: RedisDemo
 *@description:
 *@author: Hasee
 *@create: 2020-08-15 17:25
 */
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("49.232.17.3",6379);
        Transaction transaction = jedis.multi();
        transaction.set("k44","v44");
        transaction.set("k55","v55");

        transaction.exec();
//        transaction.discard();
    }
}
