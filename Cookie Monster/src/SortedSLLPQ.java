
public class SortedSLLPQ<E extends Comparable<E>> implements MyPriorityQueue<E>
{

	private ListNode queueHead;
	private int objectCount;

	public SortedSLLPQ()
	{
		queueHead = null;
		objectCount = 0;
	}

	@SuppressWarnings("unchecked")
	public void add(E obj)
	{
		boolean added = false;
		if (isEmpty())
			queueHead = new ListNode(obj, null);
		else if (objectCount == 1 || obj.compareTo((E)queueHead.getValue())<0)
			if (obj.compareTo((E)queueHead.getValue())<0)
				queueHead = new ListNode(obj, queueHead);
			else
				queueHead.setNext(new ListNode(obj, null));
		else
			for (ListNode node = queueHead; node != null && !added; node = node.getNext())
				if (node.getNext() == null)
				{
					node.setNext(new ListNode(obj, null));
					added = true;
				}
				else if (obj.compareTo((E)node.getNext().getValue())<0)
				{
					node.setNext(new ListNode(obj, node.getNext()));
					added = true;
				}
				
		objectCount++;
	}

	@SuppressWarnings("unchecked")
	public E removeMin() throws IllegalStateException
	{
		if (isEmpty())
			throw new IllegalStateException();
		E obj = (E)queueHead.getValue();
		queueHead = queueHead.getNext();
		objectCount--;
		return obj;
	}

	@SuppressWarnings("unchecked") 
	public E peek() throws IllegalStateException
	{
		if (isEmpty())
			throw new IllegalStateException();
		return (E)queueHead.getValue();
	}

	public boolean isEmpty()
	{
		return objectCount == 0;
	}

	public int size()
	{
		return objectCount;
	}

	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");
		for (ListNode node = queueHead; node != null; node = node.getNext()) 
		{
			stringbuf.append(node.getValue()+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}
}