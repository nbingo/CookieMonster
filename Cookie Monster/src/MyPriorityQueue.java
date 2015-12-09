
public interface MyPriorityQueue<E> {

	//Adds obj to the Priority Queue
	public void add(E obj);
	
	//Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin();
	
	//Returns the MINIMUM element from the Priority Queue without removing it
	public E peek();
	
	// Returns true if the priority queue is empty
	public boolean isEmpty();
	
	//Returns the number of elements in the priority queue
	public int size();

	
}
