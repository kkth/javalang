package com.hk.oddsort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kunhe on 7/31/17.
 */
public class SortBySleep {
    public static void main(String[] args)
    {
        int toSort[]= {10,3,9,2,5};

        SortBySleep sorter = new SortBySleep();
        sorter.sort(toSort);
    }

   private void sort(int[] ints)
   {
       ExecutorService ex = Executors.newFixedThreadPool(ints.length);

       for(int i=0;i<ints.length;i++)
       {
          ex.submit(new Runnable() {
              private int val=0;
              public void run() {

                  try {
                      Thread.sleep(val*1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  System.out.println(val);
              }
              public Runnable init(int val)
              {
                 this.val = val;
                 return this;
              }
          }.init(ints[i]));

       }
   }


}
