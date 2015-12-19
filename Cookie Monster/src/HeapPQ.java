import java.util.Arrays;

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
		if (objectCount == 0)
		{
			objectCount++;
			heap[1] = obj;
		}
		else
		{
			if (heap.length - 2< objectCount)
				increaseCapacity();
			heap[objectCount+1] = obj;
			siftUp(objectCount+1);
			objectCount++;
		}
	}
	
	//Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin()
	{
		swap(1, objectCount);
		E min = heap[objectCount];
		heap[objectCount] = null;
		objectCount--;
		siftDown(1);
		return min;
	}
	
	//Returns the MINIMUM element from the Priority Queue without removing it
	public E peek()
	{
		return heap[1];
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
			stringbuf.append(heap[i+1]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j+1] + " ");
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
		return i/2;	
	}
	//Returns the *smaller child* of index i
	private int smallerChild(int i)
	{
		if (i*2 > objectCount) // zero children
			return 0;
		else if (i*2+1 > objectCount) // one child
			return i*2;
		else if (heap[i*2].compareTo(heap[i*2+1]) > 0)// gets smaller of children
			return i*2+1;
		return i*2;
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
		if (parent(i) != 0 && heap[i].compareTo(heap[parent(i)]) < 0) // has a parent and is smaller
		{
			swap(i, parent(i));
			siftUp(parent(i));
		}
	}
	
	// Sifts the element at index i downwards until the heap properties hold again.
	private void siftDown(int i)
	{
		int siftedTo = 0;
		if (i*2 > objectCount ^ i*2+1 > objectCount) //only one child, which is i*2
		{
			if (heap[i].compareTo(heap[i*2])>0)
			{
				siftedTo = i*2;
				swap(i,i*2);
			}
		}
		else if (i*2 < objectCount)					// has two children
		{
			int smallerChild = smallerChild(i);
			if (smallerChild != 0 && heap[i].compareTo(heap[smallerChild]) > 0)
			{
				siftedTo = smallerChild;
				swap(i, smallerChild);
			}
		}
		if (siftedTo != 0)
			siftDown(siftedTo);
	}

}