public class UnsortedDLLPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {
	
	private ListNode2 queueHead;
	private int objectCount;
	
	public UnsortedDLLPQ()
	{
		queueHead = null;
		objectCount = 0;
	}
	
	public void add(E obj)
	{
		if (objectCount == 0)
		{
			queueHead = new ListNode2(obj);
			queueHead.setNext(queueHead);
			queueHead.setPrevious(queueHead);
		}
		else
			queueHead = new ListNode2(obj, queueHead.getPrevious(), queueHead);
		objectCount++;
	}
	
	@SuppressWarnings("unchecked")
	public E removeMin()
	{
		ListNode2 least = queueHead;
		for (ListNode2 node = queueHead.getNext(); node != queueHead; node = node.getNext())
			if (((E)least.getValue()).compareTo((E)node.getValue())>0)
				least = node;
		least.getPrevious().setNext(least.getNext());
		least.getNext().setPrevious(least.getPrevious());
		objectCount--;
		return (E)least.getValue();
	}
	
	@SuppressWarnings("unchecked")
	public E peek()
	{
		ListNode2 least = queueHead;
		for (ListNode2 node = queueHead.getNext(); node != queueHead; node = node.getNext())
			if (((E)least.getValue()).compareTo((E)node.getValue())>0)
				least = node;
		return (E)least.getValue();
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
		for (ListNode2 node = queueHead; node != null; node = node.getNext()) 
		{
			stringbuf.append(node.getValue()+" ");

		}
		stringbuf.append("]");
		return stringbuf.toString();
	}
}