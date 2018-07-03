package com.hk.mythreadpool;

/**
 * Created by kunhe on 6/27/17.
 */
public class RestartThread {
    public static void main(String[] args)
    {

        Thread mythread = new Thread(){
           public void run()
           {
              System.out.println("start..");
           }
        };

        mythread.start();
      //mythread.start();

    }


}
