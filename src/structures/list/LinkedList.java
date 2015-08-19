package structures.list;
import java.io.Serializable;
/**
 * A linked list implementation.
 * @author Lincoln Howard
 * @param <T> The data to list.
 */
@SuppressWarnings("serial")
public class LinkedList <T> implements List <T>, Serializable {
	/**
	 * The head elements of the linked list.
	 */
	private LinkedNode <T> head;
	/**
	 * Default constructor makes the head an null linked node.
	 */
	public LinkedList () {
		head = null;
	}
	@Override
	public boolean isEmpty() {
		// it is empty if the first node is null
		return head == null;
	}
	@Override
	public int size() {
		if (isEmpty ())
			return 0;
		// clone the head node
		LinkedNode <T> node = head;
		// create a temporary count integer
		int count = 0;
		// loop until we find the end
		while (node.next != null) {
			// increment count
			count++;
			// set the current node to its next node
			node = node.next;
		}
		// return the count integer
		return count;
	}
	@Override
	public int indexOf (T data) {
		// declare count and clone node variables
		int i = 0;
		LinkedNode <T> node = head;
		// loop until we find it
		while (node.next != null) {
			if (node.data.equals (data))
				// found, so return the count
				return i;
			i++;
			node = node.next;
		}
		// not found, -1
		return -1;
	}
	@Override
	public void prepend(T data) {
		// create a new node at the beginning
		head = new LinkedNode <T> (data, head);
	}
	@Override
	public void append(T data) {
		// if the list is empty, prepend, otherwise append
		if (isEmpty ()) {
			prepend (data);
		} else {
			// copy the head node
			LinkedNode <T> end = head;
			// loop to the end
			while (end.next != null) {
				end = end.next;
			}
			// append a new node
			end.next = new LinkedNode <T> (data);
		}
	}
	@Override
	public void insert(T data, int location) throws IndexOutOfBoundsException {
		// throw an error if necessary
		if (location < 0 || location > size ())
			throw new IndexOutOfBoundsException ();
		// if location is 0 prepend call prepend
		if (location == 0)
			prepend (data);
		// copy the head
		LinkedNode <T> end = head;
		// get to the proper location
		for (int i = 0; i < location - 1; i++) {
			end = end.next;
		}
		// insert the node
		end.next = new LinkedNode <T> (data, end.next);
	}
	@Override
	public void remove (int location) throws IndexOutOfBoundsException {
		if (location < 0 || location >= size ()) 
			throw new IndexOutOfBoundsException ();
		if (location == 0)
			head = head.next;
		LinkedNode <T> node = head;
		for (int i = 0; i < location - 1; i++)
			node = node.next;
		node.next = node.next.next;
	}
	@Override
	public void remove (T data) {
		int location = indexOf (data);
		while (location != -1) {
			remove (location);
			location = indexOf (data);
		}
	}
	@Override
	public T get(int location) throws IndexOutOfBoundsException {
		// throw an error if necessary
		if (location < 0 || location > size ())
			throw new IndexOutOfBoundsException ();
		// copy head node
		LinkedNode <T> end = head;
		// loop until we get the correct node
		for (int i = 0; i < location; i++) {
			end = end.next;
		}
		// return the node
		return end.data;
	}
	@Override
	public List<T> subset(int start) throws IndexOutOfBoundsException {
		// throw an error if necessary, 0 also throws an error
		if (start <= 0 || start > size ())
			throw new IndexOutOfBoundsException ();
		// copy the head node
		LinkedNode <T> node = head;
		// loop until we get to the proper start node
		for (int i = 0; i < start; )
			node = node.next;
		// create the list to return
		List <T> ret = new LinkedList <T> ();
		// copy data from current node to the end over to the return list
		while (node.next != null) {
			ret.append (node.data);
			node = node.next;
		}
		// return it
		return ret;
	}
	@Override
	public List<T> subset(int start, int end) throws IndexOutOfBoundsException {
		// get the size, make 1 call to this method instead of 2
		int size = size ();
		if (start < 0 || start > size || end <= start || end > size)
			throw new IndexOutOfBoundsException ();
		LinkedNode <T> node = head;
		for (int i = 0; i < end; i++)
			node = node.next;
		List <T> ret = new LinkedList <T> ();
		for (int i = start; i < end; i++) {
			ret.append (node.data);
			node = node.next;
		}
		return ret;
	}
	@Override
	public List<T> concat(List<T> list) {
		List <T> ret = new LinkedList <T> ();
		LinkedNode <T> node = head;
		while (node.next != null) {
			ret.append (node.data);
			node = node.next;
		}
		for (int i = 0; i < list.size (); i++) {
			ret.append(list.get (i));
		}
		return ret;
	}

	@Override
	public List<T> reverse() {
		List <T> ret = new LinkedList <T> ();
		LinkedNode <T> node = head;
		while (node.next != null) {
			ret.prepend (node.data);
			node = node.next;
		}
		return ret;
	}
	/**
	 * A linked node implementation for the linked list implementation.
	 * Hidden within the linked list.
	 * @author Lincoln Howard
	 * @param <T> The type of linked node.
	 */
	@SuppressWarnings("hiding")
	private class LinkedNode <T> implements Serializable {
		/**
		 * The data contained by this linked node.
		 */
		public T data;
		/**
		 * The link part of the linked node.
		 */
		public LinkedNode <T> next;
		/**
		 * Default (null) constructor.
		 */
		@SuppressWarnings("unused")
		public LinkedNode () {
			data = null;
			next = null;
		}
		/**
		 * Data constructor creates a linked node with data, but no link.
		 * @param data The data to construct this node with.
		 */
		public LinkedNode (T data) {
			this.data= data;
			next = null;
		}
		/**
		 * Full constructor initializes everything.
		 * @param data The starting data.
		 * @param next The starting link.
		 */
		public LinkedNode (T data, LinkedNode <T> next) {
			this.data = data;
			this.next = next;
		}
	}
}