package Heap;

public class LinkedUnbndQueue<T> implements UnboundedQueueInterface<T>
{
	int numElements;
	LLNode<T> front, rear;
	T element;

	@Override
	public boolean isEmpty()
	{
		return (numElements == 0);
	}
	public boolean isFull()
	// Returns true if this queue is full, otherwise returns
	{
		System.out.println("numElements ==7");
		return (numElements == 7);
	}
	@Override
	public String dequeue() throws QueueUnderflowException
	{
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on empty queue.");
		else
		{
			element = front.getInfo();
			front = front.getLink();
			if (front == null)
				rear = null;
		}
		return (String) element;
	}

	@Override
	public void enqueue(T element)
	{
		System.out.println("vertex in LinkedunbndQeue");
		LLNode<T> newNode = new LLNode<T>(element);
		if (rear == null)
			front = newNode;
		else
			rear.setLink(newNode);
		rear = newNode;
	}
}