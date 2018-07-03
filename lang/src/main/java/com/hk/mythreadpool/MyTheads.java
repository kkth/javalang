package com.hk.mythreadpool;

import java.util.concurrent.*;

/**
 * Created by kunhe on 4/24/17.
 */
public class MyTheads {
    BlockingQueue<String> inQ = new ArrayBlockingQueue<String>(10);
    ExecutorService pool = Executors.newFixedThreadPool(10);
    //ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    public static void main(String[] args) {
        MyTheads threads = new MyTheads();
        threads.exec();
    }

    private void exec()
    {
   //     pool.prestartCoreThread();
        /*
        for(int i = 0;i<5;i++) {
            System.out.println("Start " + i + " thread.");
            pool.execute(new Runnable() {
                //pool.submit(new Runnable() {
                private BlockingQueue<String> theQ = null;

                public void run() {
                    while(true)
                    {
                        try {
                            String inParam = theQ.take();
                            System.out.println(inParam);

                        } catch (InterruptedException e) {
                        }
                    }
                }
                public Runnable init(BlockingQueue<String> theQ)
                {
                   this.theQ = theQ;
                    return this;
                }
            }.init(inQ));
        }
        */


        ExecutorService producer = Executors.newSingleThreadExecutor();
        producer.submit(new Runnable() {

            public void run() {
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(1000);
                        int count = 0;
                        while ((count++) < 10) {
                            String curTime = String.valueOf(System.currentTimeMillis());
                            inQ.add(curTime);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("Main thread shut down");
                        pool.shutdown();
                    }

                }
            }
        });


        System.out.println("Hello");
    }
}
