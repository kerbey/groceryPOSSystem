package linkedlist;

import queue.EmptyListException;

public class LinkedList <T>
{
	private T name, target;
	public int numElements;
	//String list, location;
	LinkedListNode<T> head, previous, tail, current, node, location, list;
	public LinkedList(T name)
	{
		this.name=name;
	}
	public LinkedList()
	{
		this.name= null;
		numElements=0;
	}
	public boolean find(T target)
	{
		System.out.println("looking for "+target);
		location =list;// toString();
		boolean found = false;
		while (location != null)
		{
			if (location.getData().equals(target))
			{
				found = true;
				//return found;
				System.out.println("found it");
			}
			else
			{
				previous = location;
				location = location.getLink();
				System.out.println("still looking");
			}
		}
		return found; 
	}

	public T isEmpty() throws EmptyListException
	{
		if (toString()=="")
		{
			//throw new EmptyListException ("(is empty method )the list is empty");
			System.out.println("(is empty method )the list is empty");
		}
		else
		{	
			System.out.println("the list from inside the isempty method is  = "+toString()+"\n");
		}
		return (T) toString();
	}

		public void add(T element)
		// Adds element to this list.
		{
			LinkedListNode<T> newNode = new LinkedListNode<T>(element);
			System.out.println("newNode="+newNode);
			newNode.setLink(list);
			list = newNode;
			System.out.println("list="+list);
			numElements++;
		}

	public T getString()
	{
		return (T) toString();
	}

	public boolean remove (T element)
	// Removes an element e from this list such that e.equals(element)
	// and returns true; if no such element exists returns false.
	{
		boolean found=false;
		find(element);
		if (found==true)
		{
			if (list == location)
			{ System.out.println(list+"list==location"+location);
			list=list.getLink();  // remove first node
			}
			else // remove node at location
				previous.setLink(location.getLink());  System.out.println("previous="+previous.getLink());

				numElements--;
		}
		return found;
	}

	public String toString()
	{
		String list ="";
		current = this.head;
		while(current!=null)
		{
			list+=current.getData()+"; ";
			current= (LinkedListNode) current.getLink();
		}
		//System.out.println("the list from inside the toString method is  = "+list+"\n");
		System.out.println("toString list ="+list);
		//System.out.println("current= "+current);
		return list;
	}
}