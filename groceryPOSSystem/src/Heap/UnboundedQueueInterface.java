package Heap;

public interface UnboundedQueueInterface<T>
{

	boolean isEmpty();

	String dequeue() throws QueueUnderflowException;


	void enqueue(T vertex);

}