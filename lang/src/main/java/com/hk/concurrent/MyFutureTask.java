package com.hk.concurrent;

import java.util.concurrent.*;

/**
 * Created by kunhe on 9/12/17.
 */
public class MyFutureTask {
    private final ConcurrentHashMap<Object,Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();
    private String executionTask(final String taskName)
    {
       while(true)
       {
          Future<String> future = taskCache.get(taskName);
          if(future == null)
          {
              final Callable<String>  task = new Callable<String>() {
                  public String call() throws Exception {
                      return taskName+ " take it easy.";
                  }
              };

              FutureTask<String> futureTask = new FutureTask<String>(task);
              future = taskCache.putIfAbsent(taskName,futureTask);
              if(future == null)
              {
                 future = futureTask;
                 futureTask.run();
              }
          }

           try {
               return future.get();
           } catch (InterruptedException e) {
               e.printStackTrace();
               taskCache.remove(taskName,future);
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       }

    }

    public static void main(String[] args)
    {
        MyFutureTask theTask = new MyFutureTask();
        String ret = theTask.executionTask("MyHello");
        System.out.println(ret);
    }
}
