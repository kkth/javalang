package com.hk.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kunhe on 11/16/17.
 */
public class PreCreatedPool {

    public static void main(String[] args)
    {
        ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        exec.prestartAllCoreThreads();

        System.out.println("finished!");
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
