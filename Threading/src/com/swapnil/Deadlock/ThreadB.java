package com.swapnil.Deadlock;

public class ThreadB extends Thread
{

	ClassA a;
	ClassB b;
	ThreadB(ClassA a,ClassB b)
	{
		this.a=a;
		this.b=b;
		
	}
	@Override
	public void run() {
		
		synchronized(b)
		{
			System.out.println("In Class B got lock of b");
			try 
			{
				Thread.sleep(1000);
				synchronized(a)
				{
					System.out.println("In Class B got lock of a");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
