package Heap;

public class LinkedStack<T> implements UnboundedStackInterface<T>
{
	int length=7, topIndex=-1;
	//arrayList<String> g;//= new arrayList<>();

	/*public LinkedStack(int length)
	{
		System.out.println("this.length=="+this.length);
		this.length=length;
	}*/
	String[] stack= new String[length];

	@Override
	public boolean isEmpty()
	{
		// Returns true if this stack is empty, otherwise returns
		if (topIndex == -1)
		{ 
			System.out.println("linked stack empty");
			return true;
		}
		else 
			System.out.println("linked stack not empty");
		return false;

	}

	public boolean isFull()
	// Returns true if this stack is full, otherwise returns false.
	{
		if (topIndex == (stack.length - 1))
		{
			System.out.println("full stack");
			return true;
		}
		else System.out.println(" not full stack");
		return false;
	}
	@Override
	public String push(String element) throws StackOverflowException
	{
		if (!isFull())
		{
			topIndex++;
			stack[topIndex] = element;
			System.out.println("stack[topindex]="+stack[topIndex]);
		}
		else
			System.out.println("Push attempted on a full stack.");
		//throw new StackOverflowException("Push attempted on a full stack.");
		return element;
	}
	@Override
	public String top(String vertex) throws StackUnderflowException
	{
		T topOfStack = null;
		if (!isEmpty())
		{ 
			//g.arrayOfCities[0]=vertex;
			//System.out.println(vertex+" is now being added to the top"+ g.arrayOfCities[0]);
			topOfStack= (T) stack[topIndex];
		}
		else
			System.out.println("top attempted on a empty stack.");
		//throw new StackUnderflowException("Top attempted on an empty stack.");
		return (String) topOfStack;
	}

	@Override
	public void pop() throws StackUnderflowException
	{
		if (isEmpty()==false)
		{
			System.out.println(stack[topIndex]+" is now being removed");
			String temp= stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return;
		}
		else
			System.out.println("Pop attempted on an empty stack.");
		//throw new StackUnderflowException("Pop attempted on an empty stack.");
		return;
	}
}