package Heap;

import java.util.Scanner;
public class arrayList<T> implements Comparable<Object>
{

	private T element, delete, temp;
	Scanner input= new Scanner(System.in);
	private int maxSize;
	public int place;
	weightedGraph<String> weight = new weightedGraph<>();
	public String []arrayOfCities= new String [7];

	public arrayList(int maxSize)
	{
		weight= new weightedGraph<>(maxSize);
		System.out.println("arraylist constructor");
		this.maxSize=maxSize;
	}

	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public void setMaxSize(int maxSize)
	{
		System.out.println("arraylist setMaxsize");
		this.maxSize = maxSize;
	}
	public int getMaxSize()
	{
		System.out.println("arraylist getmaxsize");
		return maxSize;
	}

	public T remove(int lastIndex)
	{
		arrayOfCities[lastIndex]=null;
		return null;
	}
	@SuppressWarnings("unchecked")
	public T get(int hole)
	{// get is made to retrieve child of the passed in position from the array and delete it from the linked list
		System.out.println("arraylist get 2nd");
		System.out.println("searching for position number "+hole);
		for(place=0;place<=hole;place++)
		{
			if((hole)==place)
			{
				setElement((T) arrayOfCities[place]);
				System.out.println("now getting "+getElement()+" from arrayofcities");
				System.out.println("from place number "+place);
			}
		}
		System.out.println("now leaving get method");
		return getElement();
	}
	public T set(int hole, T newElement)
	{// place the element from get method into a new place in the array and place it back in the linkedlist
		// in their correct positions (switch)

		System.out.println("arraylist set");
		System.out.println("this element needs a new position-->"+getElement()+" in position "+place);
		System.out.println("it will switch with "+newElement+" in position "+hole);
		if(place!=hole)
		{
			for(int newPlace=0;newPlace<=hole;newPlace++)//atlanta loop
			{
				if(newPlace==hole)
				{
					System.out.println("place # "+hole+" "+arrayOfCities[hole]);
					temp=(T) arrayOfCities[hole];
				}
			}
			for(int oldPlace=0;oldPlace<=place;oldPlace++)//atlanta loop
			{
				if(oldPlace==place)
				{
					arrayOfCities[hole]=arrayOfCities[place];
					arrayOfCities[place]=(String) temp;
					//System.out.println("oldplace # "+place+" "+arrayOfCities[place]);
				}
			}
			
		}
		for(int place=0;place<arrayOfCities.length;place++)
		{
			System.out.println("place "+place+" "+arrayOfCities[place]);
		}

		return getElement();
	}
	public T add (int lastIndex, T element)
	{// Adds element to tree; tree retains its BST property.
		//adds it to an array and then returns that specific city
		setElement(element);
		System.out.println("now in arrayList add");
		System.out.println("passed in element="+getElement());
		System.out.println("lastIndex=="+lastIndex);
		arrayOfCities[lastIndex]=(String) getElement();
		return getElement();
	}
	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
	
	public void getToGraph() throws StackOverflowException, StackUnderflowException, QueueUnderflowException
	{
		weight.addVertex(arrayOfCities[0]);
		weight.addVertex( arrayOfCities[1]);
		weight.addVertex(arrayOfCities[2]);
		weight.addVertex(arrayOfCities[3]);
		weight.addVertex(arrayOfCities[4]);

		weight.addEdge(arrayOfCities[0], arrayOfCities[0], 0);
		weight.addEdge(arrayOfCities[0],arrayOfCities[1], 600);
		weight.addEdge(arrayOfCities[0], arrayOfCities[2],1300 );
		weight.addEdge(arrayOfCities[1], arrayOfCities[3], 1400);
		weight.addEdge(arrayOfCities[2], arrayOfCities[4], 1500);

		setElement((T) arrayOfCities[0]);
		String endElement= arrayOfCities[arrayOfCities.length-1];

		System.out.println();
		weight.isPath(weight, arrayOfCities[0], arrayOfCities[0]);
		System.out.println();
		weight.isPath(weight, arrayOfCities[0], arrayOfCities[1]);
		System.out.println();
		weight.isPath(weight, arrayOfCities[0], arrayOfCities[2]);
		System.out.println();
		weight.isPath(weight, arrayOfCities[1], arrayOfCities[3]);
		System.out.println();
		weight.isPath(weight, arrayOfCities[2], arrayOfCities[4]);
		System.out.println();
	}
}
