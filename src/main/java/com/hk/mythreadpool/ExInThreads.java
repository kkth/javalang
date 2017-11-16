package com.hk.mythreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kunhe on 6/26/17.
 */
public class ExInThreads {

    public static void main(String[] args)
    {
        System.out.println("Hello");

        ExecutorService exec = Executors.newFixedThreadPool(10);

        for(int i = 0;i<1000;i++) {
            exec.execute(new Runnable() {
                public void run() {
                    int j = 100;
                    for (int k =0;k<j;k++) {
                        if(k!=99) {
                            System.out.println(k);
                        }
                        else
                        {
                            //throw new MyException();
                        }

                    }
                }
            });
        }
       return;
    }
}
