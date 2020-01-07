package com.swapnil.callableFuture;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<Object> {

	

	@Override
	public Integer call() throws Exception {
		
		Thread.sleep(3000);
		return new Random().nextInt();
	}

}
