import java.util.LinkedList;
import java.util.List;

public class BlockingQueueImpl<T> {

	private int limit;
	private List<T> queue = new LinkedList<>();

	public BlockingQueueImpl(int limit){
		this.limit = limit;
	}

	public synchronized void enqueue(T value) throws InterruptedException{
		while(queue.size() == limit){
			wait();
		}
		
		//some thread might be waiting as queue is empty, notify them as you are adding a entry to queue
		if(queue.size() == 0){
			notifyAll();
		}
		queue.add(value);
	}
	
	public synchronized T dequeue() throws InterruptedException{
		while(queue.size() == 0){
			System.out.println("Waiting");
			wait();
		}
		
		if(queue.size() == limit){
			notifyAll();
		}
		
		return queue.remove(0);
	}

}
