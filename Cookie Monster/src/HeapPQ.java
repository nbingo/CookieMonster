
public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;
	
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
		
	}
	
	//Returns the number of elements in the priority queue
	public int size()
	{
		
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
	private void increaseCapacity()
	{
		
	}

	//Returns the index of the "parent" of index i
	private int parent(int i)
	{
		
	}
	//Returns the *smaller child* of index i
	private int smallerChild(int i)
	{
		
	}
	//Swaps the contents of indices i and j
	private void swap(int i, int j)
	{
		
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i)
	{
		
	}
	
	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i)
	{
		
	}

}