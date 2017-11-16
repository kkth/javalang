package com.hk;

/**
 * Created by kunhe on 9/30/17.
 */
public class MyResource {
    private static MyResource ourInstance = new MyResource();

    public static MyResource getInstance() {
        return ourInstance;
    }

    private MyResource() {
    }
}
