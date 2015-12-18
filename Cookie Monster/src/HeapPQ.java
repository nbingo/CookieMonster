/**
 * @author Nomi
 * @version 12.18.15
 * @since 12.18.15
 * @param <E>
 */
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;
	
	@SuppressWarnings("unchecked")
	public HeapPQ()
    {
        this.heap = (E[])new Comparable[3];
        this.objectCount = 0;
    }

	//Adds obj to the Priority Queue
	public void add(E obj)
	{
		
	}
	
	//Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin()
	{
		
	}
	
	//Returns the MINIMUM element from the Priority Queue without removing it
	public E peek()
	{
		
	}
	
	// Returns true if the priority queue is empty
	public boolean isEmpty()
	{
		return objectCount == 0;
	}
	
	//Returns the number of elements in the priority queue
	public int size()
	{
		return objectCount;
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++)
		{
			stringbuf.append(heap[i]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount)
			{
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++)
				{
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}
	
	//Doubles the size of the heap array
	@SuppressWarnings("unchecked")
	private void increaseCapacity()
	{
		E[] doubled = (E[])new Comparable[heap.length*2];
		for (int i = 0; i < heap.length; i++)
			doubled[i] = heap[i];
		heap = doubled;
	}

	//Returns the index of the "parent" of index i
	private int parent(int i)
	{
		if (i%2 == 0) //even
			return (i-1)/2;
		return i/2;
	}
	//Returns the *smaller child* of index i
	private int smallerChild(int i)
	{
		if (heap[i*2].compareTo(heap[i*2+1])<0)
			return i*2;
		return i*2+1;
	}
	//Swaps the contents of indices i and j
	private void swap(int i, int j)
	{
		E temp  = heap[j];
		heap[j] = heap[i];
		heap[i] = temp;
	}

	// Sifts the element at index i upwards until the heap properties hold again.
	private void siftUp(int i)
	{
		
	}
	
	// Sifts the element at index i downwards until the heap properties hold again.
	private void siftDown(int i)
	{
		
	}

}