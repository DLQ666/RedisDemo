package com.dlq.redis;

import redis.clients.jedis.Jedis;

/**
 *@program: RedisDemo
 *@description:
 *@author: Hasee
 *@create: 2020-08-15 17:07
 */
public class TestPing {

    public static void main(String[] args) {
        //连接远程Redis服务
        Jedis jedis = new Jedis("49.232.17.3",6379);
        //查看服务是否运行，打出pong表示OK
        System.out.println(jedis.ping());
    }

}
