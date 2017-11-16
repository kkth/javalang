package com.talkingdata.utils.concurrent.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jianming.tang on 2017/7/19.
 */
public class TDThreadPool implements Runnable {

    private final LinkedBlockingQueue<Runnable> queue;
    private final List<Thread> threads;
    private boolean shutdown;

    public TDThreadPool(int countOfThreads) {
        queue = new LinkedBlockingQueue<>();
        threads = new ArrayList<>();
        for (int i = 0; i < countOfThreads; ++i) {
            Thread thread = new Thread(this);
            thread.start();
            threads.add(thread);
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        queue.put(task);
    }

    private Runnable consume() throws InterruptedException {
        return queue.take();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                Runnable task = this.consume();
                task.run();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " shutdown");
    }

    public void shutdown() {
        shutdown = true;
        threads.forEach((thread) -> thread.interrupt());
    }

    public static void main(String[] args) throws InterruptedException{
        TDThreadPool threadPool = new TDThreadPool(5);
        for (int i = 0; i < 10; ++i) {
            int taskNumber = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.printf(Thread.currentThread().getName() +":" +"task %d complete\n", taskNumber);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(3000);
        threadPool.shutdown();
    }
}
