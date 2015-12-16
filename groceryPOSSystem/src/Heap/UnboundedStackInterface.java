package Heap;

public interface UnboundedStackInterface<T> {

	String push(String startVertex) throws StackOverflowException;

	String top(String vertex) throws StackUnderflowException;

	void pop() throws StackUnderflowException;

	boolean isEmpty();

}
