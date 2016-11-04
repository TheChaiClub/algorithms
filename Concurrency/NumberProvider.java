import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class NumberProvider implements Runnable {
	Random random = new Random(1000);	
	BlockingQueue<Integer> queue;
	
	public NumberProvider(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Stream.iterate(1000, (i) -> i + random.nextInt())
			  .filter((i) -> i> 0)
			  .filter((i) -> i%2 == 0)
			  .limit(50)
			  .forEach((i) -> {
				  try {
					  queue.put(i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			  });
	}
}
