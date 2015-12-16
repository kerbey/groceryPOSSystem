//package groceryPOSSystem;
package queue;

public class List <T>
{
	private T name, element;
	Node<T>  node, front, rear,newNode, current;
	public List(T name)
	{
		this.name=name;
	}
	public List()
	{
		this.name= null;
	}

	public Boolean isEmpty()// throws EmptyListException
	{
		if (toString()==null||toString()=="")
			System.out.println("(is empty method )the list is empty");
		return element==null;		
	}
	public T deqeue() throws EmptyListException//(T data)//delete
	{
		if(toString().isEmpty())
		{
			//throw new EmptyListException ("(is empty method )the list is empty");
			System.out.println("(is empty method )the list is empty");
		}
		else
		//if front has something then move that to element. Now and the front will be assinged a null value 
		// so that first element added is the first to leave
			element= front.getElement();//getInfo();
			front=front.getLink();//.getLink();
			//front has nothing
			if(front==null)
				rear=null;
			return element;
	}
	public void enqeue(T element)//first in first out
	{//assign front to the new node that gets added
		Node<T> newNode= new Node<T>(element);
		if(rear== null)
			front =newNode;
		else 
			rear.setLink(newNode);
		rear= newNode;
		//System.out.println("front="+front.getElement());
		//=System.out.println("rear="+rear.getElement());
	///	System.out.println("element= "+element);
	}
	@SuppressWarnings("unchecked")
	public T getString()
	{
		return (T) toString();
	}	
	public String toString()
	{
		String list ="";
		current = this.front;//tell current to get what's in front
		//System.out.println("first current="+current);
		while(current!=null)
		{
			list+=current.getElement()+",";// it now adds that to the list
			current= current.getLink();//and replaces that with whatever comes next
		}
		//System.out.println("the list from inside the toString method is  = "+list+"\n");
		//System.out.println("toString list ="+list);
		//System.out.println("current= "+current);
		return list;
	}
}