package com.dlq.redis;

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 *@program: RedisDemo
 *@description:
 *@author: Hasee
 *@create: 2020-08-15 17:16
 */
public class TestAPI {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("49.232.17.3",6379);

        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");

        System.out.println(jedis.get("k1"));

        System.out.println("--------------key---------------");
        //key
        Set<String> sets = jedis.keys("*");
        System.out.println(sets);
        for (Iterator iterator= sets.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            System.out.println(key);
        }
        System.out.println();
        /*Iterator it = sets.iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            System.out.println(key);
        }*/
        System.out.println("jedis.exists======>"+jedis.exists("k2"));
        System.out.println(jedis.ttl("k1"));

        System.out.println("---------------String----------------");
        //String
//        jedis.append("k1","myredis");
        System.out.println(jedis.get("k1"));//v1myredis
        jedis.set("k4","v4_redis");
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1", "str2", "str3"));

        System.out.println("---------------list-----------------");
        //list
        jedis.lpush("mylist","v1","v2","v3","v4","v5");
        List<String> list = jedis.lrange("mylist", 0, -1);
        for (String element : list) {
            System.out.println(element);
        }

        System.out.println("---------------set---------------");
        //set
        jedis.sadd("orders","jd001");
        jedis.sadd("orders","jd002");
        jedis.sadd("orders","jd003");
        Set<String> set = jedis.smembers("orders");
        for (Iterator iterator=set.iterator();iterator.hasNext();){
            String setElement = (String) iterator.next();
            System.out.println(setElement);
        }
        /*Iterator it = set.iterator();
        while (it.hasNext()){
            String keySet = (String) it.next();
            System.out.println(keySet);
        }*/
        jedis.srem("orders","jd002");
        System.out.println(jedis.smembers("orders").size());

        System.out.println("---------------hash---------------");
        //hash
        jedis.hset("hash1","userName","zhangsan");
        System.out.println(jedis.hget("hash1", "userName"));
        Map<String,String> map =new HashMap<>();
        map.put("telphone","123123123");
        map.put("address","beijing");
        map.put("email","zhangsan@qq.com");
        jedis.hmset("hash2",map);
        List<String> list1 = jedis.hmget("hash2", "telphone", "email");
        for (String hashElement : list1) {
            System.out.println(hashElement);
        }

        System.out.println("---------------zset---------------");
        //zset
        jedis.zadd("zset01",40d,"v1");
        jedis.zadd("zset01",30d,"v2");
        jedis.zadd("zset01",20d,"v3");
        jedis.zadd("zset01",10d,"v4");
        Set<String> zset01 = jedis.zrange("zset01", 0, -1);
        for (Iterator it = zset01.iterator();it.hasNext();){
            String zsetElement = (String) it.next();
            System.out.println(zsetElement);
        }
    }
}
