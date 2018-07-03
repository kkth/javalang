package com.hk.tl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

	public static void main(String[] args)
	{
		System.out.println("ok");
		
		ExecutorService exe = Executors.newFixedThreadPool(9);
		Runnable task = new Runnable(){
			public long val = 0L;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (val <1000000000L)
				{
					val++;
				}
				
				System.out.println(val);
			}
			
		};
		
		exe.execute(task);

		exe.shutdown();
		
	}
}
