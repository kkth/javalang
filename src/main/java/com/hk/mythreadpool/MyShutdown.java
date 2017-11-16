package com.hk.mythreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kunhe on 4/24/17.
 */
/*

 */

public class MyShutdown {

    ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main(String[] args)
    {
        MyShutdown shutd = new MyShutdown();
        shutd.exec();

    }

    public void exec()
    {
        for (int i =1;i<20;i++)
        {
           pool.submit(new Runnable() {
                           int index = -1;
                           public void run() {
                               try {
                                   System.out.println("Thread " + index + " begin.");
                                   Thread.sleep(3000);
                                   if(index%5==0)
                                   {
                                       throw new RuntimeException();
                                   }
                                   System.out.println("Thread " + index  + " end.");
                               } catch (InterruptedException e) {
                                   System.out.println("Thread " + index  + " interrupted.");
                               }
                           }
                           public Runnable init(int index){
                               this.index = index;
                               return  this;
                       }

            } .init(i) );
        }



        try {
            System.out.println("Call shutdown.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        pool.submit(new Runnable() {
            public void run() {

            }
        });
    }

}
