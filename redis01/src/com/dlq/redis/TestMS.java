package com.dlq.redis;

import redis.clients.jedis.Jedis;

/**
 *@program: RedisDemo
 *@description:
 *@author: Hasee
 *@create: 2020-08-15 21:02
 */
public class TestMS {

    public static void main(String[] args) {
        Jedis jedis_M = new Jedis("49.232.17.3",6379);
        Jedis jedis_S = new Jedis("49.232.17.3", 6380);

        jedis_S.slaveof("49.232.17.3", 6379);

        jedis_M.set("class","1122");

        String result = jedis_S.get("class");
        System.out.println(result);
    }
}
