package com.swapnil.TypeofPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1.Fixed Thread pool
		 * 2. Cached Thread Pool
		 * 3. Scheduled Thread Pool
		 * 4. Single Threaded Pool 
		 * */

		//1. Fixed thread pool is earlier execute example
		// Queue:-LinkedBlockingQueue
		
		//2. Cached Thread Pool
		/*Here we are not giving any no of thread instead a new thread is created if existing thread is busy service request
		 * So suppose there are 100 threads busy serving request and you get new task to handle so it will create thread no 101
		 * As we don't have fixed thread size thread can grow exponentially if after completing task to it has time to live of 60 sec once thread is idle
		 * Queue:-SynchonousQueue ,as threads are unlimited so we are not storing task 
		 * */
		
		ExecutorService service=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++)
		{
			service.execute(new Task());
		}
		System.out.println("Thread Name:"+Thread.currentThread().getName());
		
		//3. Scheduler Thread Pool
		/* It is specific for scheduling task after some delay like logging and checks after some time
		 * It use delay queue and task is not FIFO bus based on time of execution will be priority first
		 * Que-Delayed Queue
		 * */
		
		ScheduledExecutorService service1=Executors.newScheduledThreadPool(10);
		// task run at 10 sec delay
		service1.schedule(new Task(), 10, TimeUnit.SECONDS);
		
		//Task run repeatedly after every 10 second
		service1.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);
		
		//Task run repeatedly after every 10 second after previous task completed
		service1.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);
		
		
		//4. Single Threaded Pool
		/*We have only one thread created it takes on task at a time and execute.If thread gets killed or completed and new Thread is created
		 * Used when task 1 task 2 and task 3 need to be sequentionlly 
		 * Queue:-LinkedBlockingQueue
		 * */
		 service=Executors.newFixedThreadPool(1);
		for(int i=0;i<10;i++)
		{
			service.execute(new Task());
		}
		System.out.println("Thread Name:"+Thread.currentThread().getName());
		
		
	}

}
