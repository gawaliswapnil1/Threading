package com.swapnil.callableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.swapnil.TypeofPool.Task;

/*Callable<I> :which return value from thread
 * 
 * 
 * 
 * 
 * 
 * */
public class CallableFuture {

	public static void main(String[] args) throws Exception{
		
		ExecutorService service=Executors.newCachedThreadPool();
		//you have to submit task instead of callable
		
		Future future= service.submit(new Task());
		
		//perform some operation
		Integer intget=(Integer) future.get();//blocking till our future variable value is ready from thread
		
		System.out.println("Thread Name:"+Thread.currentThread().getName()+intget);
	}

}
