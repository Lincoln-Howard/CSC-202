package structures.queue;
/**
 * Define a queue.
 * @author Lincoln Howard
 * @param <T> The type to queue.
 */
public interface Queue <T> {
	/**
	 * Check whether the queue is empty.
	 * @return True if empty, otherwise false.
	 */
	public boolean isEmpty ();
	/**
	 * Queue data.
	 * @param data The data to enqueue.
	 */
	public void enqueue (T data);
	/**
	 * Remove and return the first element in the queue.
	 * @return The next element.
	 */
	public T dequeue ();
}