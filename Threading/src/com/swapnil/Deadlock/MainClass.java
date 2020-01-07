package com.swapnil.Deadlock;

public class MainClass {

	public static void main(String[] args) 
	{
		ClassA a=new ClassA();
		ClassB b=new ClassB();

		ThreadA t1=new ThreadA(a, b);
		ThreadB t2=new ThreadB(a, b);
		
		t1.start();
		t2.start();

	}
}
