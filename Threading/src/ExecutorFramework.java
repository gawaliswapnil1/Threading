import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//Here each thread takes one task at time from threadpool it use blocking queue internally
//Ideal threadpool size

public class ExecutorFramework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService service=Executors.newFixedThreadPool(10);
		for(int i=0;i<10;i++)
		{
			service.execute(new Task());
		}
		System.out.println("Thread Name:"+Thread.currentThread().getName());
		
		
		
		//If our operation is CPU intensive and then in that case we should create thread as per CPU lime
		
		int numberOfCore=Runtime.getRuntime().availableProcessors();
		service=Executors.newFixedThreadPool(numberOfCore);
		for(int i=0;i<10;i++)
		{
			service.execute(new Task());
		}
		System.out.println("Thread Name:"+Thread.currentThread().getName());
		
		//If your task is I/O based because its wait for response (HTTP,Database call)
		
		service=Executors.newFixedThreadPool(100);
		for(int i=0;i<10;i++)
		{
			service.execute(new Task());
		}
		System.out.println("Thread Name:"+Thread.currentThread().getName());
	}

}


