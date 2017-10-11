package com.app.test.thread;

public class MyThread implements Runnable {

	public MyThread() {
		System.out.println("constructor MyThread");
			
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println("From Run methopd");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}
