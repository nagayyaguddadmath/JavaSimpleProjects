package com.app.test.interfacetest;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ListTest {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread();
		t1.setName("test t1");
		System.out.println("before start");
		t1.start();
//		t1.wait(2000);
		System.out.println("after wait" + t1.getState());
//		Thread.sleep(1);
		System.out.println("after wait" + t1.getState());
	}





}