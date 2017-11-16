package com.hk.racecondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kunhe on 4/25/17.
 */
public class MyRace {

    volatile int count = 0;
    List<Integer> countList = new ArrayList<Integer>();

    public static void main(String[] args)
    {
        MyRace race = new MyRace();
        race.exec();
    }

    private void exec()
    {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        CountDownLatch countDown1 = new CountDownLatch(100);
        CountDownLatch countDown2 = new CountDownLatch(1);
        for(int i =0;i<100;i++)
        {
            pool.submit(new Runnable() {

                CountDownLatch c1 = null;
                CountDownLatch c2 = null;
                public void run() {
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "start.");
                    for(int i=0;i<1000;i++)
                    {
                            countList.add(1);
                            count++;
                    }

                    c1.countDown();
                    System.out.println(Thread.currentThread().getName() + "end.");

                }
                public Runnable init(CountDownLatch c1,CountDownLatch c2)
                {
                    this.c1 = c1;
                    this.c2 = c2;
                    return this;
                }
            }.init(countDown1,countDown2));
        }
        System.out.println("All threads created");


        countDown2.countDown();

        try {
            countDown1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
        System.out.println(countList.size());


    }
}
