package com.hk.future;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by kunhe on 11/15/17.
 */
public class ScheduleTasksWithFuture {

    static ScheduledFuture future =null;
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args)
    {
       ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("my-sad-thread-%d").build();
       ScheduledExecutorService schedulePool  = Executors.newScheduledThreadPool(10, namedThreadFactory);

       future = schedulePool.scheduleAtFixedRate(new Runnable() {
           private long count = 0L;
           @Override
           public void run() {
               try {
                   Thread.sleep(2000);
                   count++;
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("Schedule Task!");
               if(count == 5)
               {
                   future.cancel(true);
                   System.out.println("Cancel myself!");
                   countDownLatch.countDown();
               }
           }
        },1000,2000, TimeUnit.MILLISECONDS);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Canceled!");
        schedulePool.shutdown();

        return ;
    }
}
