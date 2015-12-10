import java.util.ArrayList;

public class ArrayListPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private ArrayList<E> queue;
	
	public ArrayListPQ()
	{
		queue = new ArrayList<E>();
	}
	
	public void add(E obj)
	{
		queue.add(obj);
	}
	
	public E removeMin()
	{
		E least = queue.get(0);
		int i;
		for (i = 0; i < queue.size()-1; i++)
			if (least.compareTo(queue.get(i))<0)
				least = queue.get(i);
		return queue.remove(i);
	}
	
	public E peek()
	{
		return queue.get(0);
	}
	
	public boolean isEmpty()
	{
		return queue.size() == 0;
	}
	
	public int size()
	{
		return queue.size();
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");	
		for (int i = 0; i < queue.size(); i++)
		{
			stringbuf.append(queue.get(i)+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}

}
