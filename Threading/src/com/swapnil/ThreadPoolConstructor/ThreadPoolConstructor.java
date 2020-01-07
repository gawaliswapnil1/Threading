package com.swapnil.ThreadPoolConstructor;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.swapnil.TypeofPool.Task;

public class ThreadPoolConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service=new ThreadPoolExecutor(10, 100, 120, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(300),new RejectedExecutionHandler() {

			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub

			}
		});
		
		//initiate ShutDown
		service.shutdown();
		
		//will return true since shutdown has begun
		service.isShutdown();
		
		//will return true if all task are completed including which are in blocking queue
		service.isTerminated();
		
		// Block until all task are completed or if timeout occures
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//will initiate shutdown and return all queued task
		List<Runnable> runnable=service.shutdownNow();

	}
}



/*
 * corePool size
maxPool size-Upper threadshold of pool
workQueue
keepAliveTime-Time to keep thread alive when its alive
threadFactory
rejectedExecutionHandler-
AbortPolict - Submitting new tasks throws RejectedExecutionException
DiscardPolicy Submitting new tasks silently discards it
DiscardOldestPolicy-Submittingnew Task drops existing oldest task and new task is added to queue
CallerRunsPolicy 
 * */


class RejectedTaskHandler implements RejectedExecutionHandler 
{ 
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) 
	{ 
		System.out.printf("RejectedTaskHandler: The task %s has been rejected", r.toString()); 
	}
}


