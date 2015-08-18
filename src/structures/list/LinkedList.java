package structures.list;
/**
 * A LinkedList implementation.
 * @author Lincoln Howard
 * @param <T> The data to list.
 */
public class LinkedList <T> implements List <T> {
	// private linked node class
	private class LinkedNode <T> {
		// the data
		public T data;
		// the link
		public LinkedNode <T> next;
		// Constructor
		public LinkedNode () {
			data = null;
			
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int prepend(T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int append(T data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(T data, int location) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T get(int location) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subset(int start) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subset(int start, int end) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> concat(List<T> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> reverse() {
		// TODO Auto-generated method stub
		return null;
	}
}