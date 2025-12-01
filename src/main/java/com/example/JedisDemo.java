package com.example;

import redis.clients.jedis.Jedis;

public class JedisDemo {
    public static void main(String[] args) {
        try (Jedis jedis = new Jedis("localhost", 6379)) {
            jedis.set("key", "aaaaa111");
            String value = jedis.get("key");
            System.out.println(value);
        }
    }

}
