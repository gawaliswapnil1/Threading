package com.swapnil.Deadlock;

public class ThreadA extends Thread
{
	ClassA a;
	ClassB b;
	ThreadA(ClassA a,ClassB b)
	{
		this.a=a;
		this.b=b;

	}
	@Override
	public void run() {

		synchronized(a)
		{
			System.out.println("In Class A got lock of A");
			try 
			{
				Thread.sleep(1000);
				synchronized(b)
				{
					System.out.println("In Class A got lock of B");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
