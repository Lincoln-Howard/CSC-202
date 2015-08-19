package stack;
import structures.list.LinkedList;
import structures.list.List;

/**
 * Use a linked list to implement a stack.
 * @author Lincoln Howard
 * @param <T> The type of data to stack.
 */
public class LinkedListStack <T> implements Stack <T> {
	/**
	 * The list for the stack.
	 */
	private List <T> stack;
	/**
	 * Default constructor.
	 */
	public LinkedListStack () {
		stack = new LinkedList <T> ();
	}
	@Override
	public boolean isEmpty () {
		return stack.isEmpty ();
	}
	@Override
	public void push (T data) {
		stack.prepend (data);
	}
	@Override
	public T pop () throws StackUnderflowException {
		if (isEmpty ()) throw new StackUnderflowException ();
		T ret = stack.get (0);
		stack.remove (0);
		return ret;
	}
	@Override
	public T peek() throws StackUnderflowException {
		if (isEmpty ()) throw new StackUnderflowException ();
		T ret = stack.get (0);
		return ret;
	}
}