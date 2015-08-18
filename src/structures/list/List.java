package structures.list;
/**
 * An interface for list data types. Project for my CSC 202 class at NVCC fall
 * 2015.
 * @author Lincoln Howard
 * @param <T> The type of data to list.
 */
public interface List <T> {
	/**
	 * Checks whether the list is empty.
	 * @return True if empty. Otherwise false.
	 */
	public boolean isEmpty ();
	/**
	 * Gets the number of elements in the list.
	 * @return The number of elements in the list.
	 */
	public int size ();
	/**
	 * Insert data at position 0 in the list.
	 * @param data The data to prepend to the list.
	 * @return The new size.
	 */
	public int prepend (T data);
	/**
	 * Insert data at the end of the list.
	 * @param data The data to append to the list.
	 * @return The new size.
	 */
	public int append (T data);
	/**
	 * Insert data at a given location in the list.
	 * @param data The data to insert.
	 * @param location The index to insert the data at.
	 * @return The new size.
	 * @throws IndexOutOfBoundsException If the location is not in the list.
	 */
	public int insert (T data, int location) throws IndexOutOfBoundsException;
	/**
	 * Get data from a specific location in the list.
	 * @param location The location to get data from.
	 * @return The data at the location in the list.
	 * @throws IndexOutOfBoundsException If the location is not in the list.
	 */
	public T get (int location) throws IndexOutOfBoundsException;
	/**
	 * Get a subset of the list going from the start index to the end.
	 * @param start The start of the subset.
	 * @return The resulting subset.
	 * @throws IndexOutOfBoundsException If the location is not in the list.
	 */
	public List <T> subset (int start) throws IndexOutOfBoundsException;
	/**
	 * Get a subset of the list going from start to the provided end.
	 * @param start The start of the subset.
	 * @param end The end of the subset.
	 * @return The resulting subset.
	 * @throws IndexOutOfBoundsException If the location is not in the list.
	 */
	public List <T> subset (int start, int end) throws IndexOutOfBoundsException;
	/**
	 * Concatenates another list to this list.
	 * @param list The other list.
	 * @return The resulting concatenated list.
	 */
	public List <T> concat (List <T> list);
	/**
	 * Get a list in reverse order of this list.
	 * @return The result of reversing this list.
	 */
	public List <T> reverse ();
}