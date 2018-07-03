package com.hk;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kunhe on 6/27/18.
 */
public class MyRedisClt {
    public static void main(String[] args) {
        System.out.println("go");
        //
        Set<String> hosts = new HashSet<String>();
        hosts.add("172.20.33.8:26379");
        hosts.add("172.20.33.8:26380");
        hosts.add("172.20.33.8:26381");

        JedisSentinelPool pool = new JedisSentinelPool("dataset_test", hosts);
        Jedis jedis = pool.getResource();
        String key = "Kun_"+ System.currentTimeMillis();
        System.out.println(key);

        long flag = jedis.setnx(key, "ture");
        if(flag==1)
        {
            jedis.expire(key,60);
        }

        System.out.println("done");

    }

}
