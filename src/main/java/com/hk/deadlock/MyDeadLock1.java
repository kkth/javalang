package com.hk.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kunhe on 4/25/17.
 */
public class MyDeadLock1 {
    int count = 0;
   private Object l1 = new Object();
   private Object l2 = new Object();
   private ExecutorService pool = Executors.newFixedThreadPool(2);

   public static void main(String[] args)
   {
      MyDeadLock1 lock = new MyDeadLock1();
      lock.exec();
   }

   private void exec()
   {
      for(int i =0;i<2;i++){
        pool.submit(new Runnable() {

           public void run() {
               while(true) {
                   synchronized (l1)
                   {
                       synchronized (l2) {
                           count++;
                       }
                   }
                   /*
                   synchronized (l2)
                   {
                         synchronized (l1)
                       {
                           count++;
                       }
                   }
                   */

                   //if(count%1000==0)
                   {
                       System.out.println(Thread.currentThread().getName() + count);
                   }
               }
           }
        });

      }


   }

}
