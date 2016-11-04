import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ExService {

	private static int CAPACITY = 100;

	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(50);
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(CAPACITY);
		
		NumberProvider numberProvider = new NumberProvider(queue);
		
		pool.execute(numberProvider);
		
		long startTime = System.currentTimeMillis();
		try{
			for(int i=0;i<50;i++){
				CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new NumberReader(queue), pool);
				future.thenAccept(in -> System.out.println(in));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
		try {
			if(!pool.awaitTermination(10, TimeUnit.SECONDS)){
				pool.shutdownNow();
			}
		} catch (InterruptedException e) {
			pool.shutdownNow();
		} 
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken:" + (endTime - startTime));
	}

}
