import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class NumberReader implements Supplier<Integer> {

	private BlockingQueue<Integer> queue;

	
	public NumberReader(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public Integer get() {
		try {
			Thread.sleep(200);
			return queue.poll(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
