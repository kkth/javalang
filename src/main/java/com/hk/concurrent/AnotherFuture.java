package com.hk.concurrent;

import java.util.concurrent.*;

/**
 * Created by kunhe on 9/12/17.
 */
public class AnotherFuture {
    private ThreadPoolExecutor tpe = (ThreadPoolExecutor)Executors.newCachedThreadPool();

    private void cal()
    {
        String finalVal = "";
        Future<Object> fInt = tpe.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return new Integer(100);
            }
        });
        Future<Object> fStr = tpe.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return new String(" years old.");
            }
        });

        try {
            Integer intVal = (Integer)fInt.get();
            String strVal = (String)fStr.get();

            finalVal = intVal + strVal;

            System.out.println(finalVal);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        tpe.shutdown();

    }
    public static void main(String[] args)
    {
        AnotherFuture af = new AnotherFuture();
        af.cal();
    }
}
