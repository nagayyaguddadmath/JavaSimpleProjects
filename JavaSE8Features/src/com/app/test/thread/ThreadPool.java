package com.app.test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		for (int i = 0 ; i<5; i++) {
			MyThread t1 = new MyThread();
			executor.execute(t1);
		}
		System.out.println("Pool size:" + executor.getMaximumPoolSize());
	}

}
