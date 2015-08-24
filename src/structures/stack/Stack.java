package structures.stack;
/**
 * Define a stack data structure.
 * @author Lincoln Howard
 * @param <T> The type of data in the stack.
 */
public interface Stack <T> {
	/**
	 * Tests whether the stack is empty.
	 * @return True if empty, otherwise false.
	 */
	public boolean isEmpty ();
	/**
	 * Push data to the top of the stack.
	 * @param data The data to push.
	 */
	public void push (T data);
	/**
	 * Pop data from the top of the stack.
	 * @return Data on the top of the stack.
	 * @throws StackUnderflowException If the stack was empty.
	 */
	public T pop () throws StackUnderflowException;
	/**
	 * Return data from the top of the stack without popping it.
	 * @return The data on top of the stack.
	 */
	public T peek () throws StackUnderflowException;
}