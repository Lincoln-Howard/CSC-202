package structures.queue;

import structures.list.LinkedList;
import structures.list.List;

public class LinkedQueue <T> implements Queue <T> {
	
	private List <T> queue;
	
	public LinkedQueue () {
		queue = new LinkedList <T> ();
	}
	@Override
	public boolean isEmpty() {
		return false;
	}
	@Override
	public void enqueue(T data) {
		
	}
	@Override
	public T dequeue() {
		return null;
	}
}