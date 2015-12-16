//package groceryPOSSystem;
package queue;
//package Heap;

//import heap;

import java.util.LinkedList;
import java.util.Scanner;

import Heap.heap;
public class traffic<T> extends List
{
	static heap<String> heap= new heap<>(5);

	static Scanner input= new Scanner(System.in);
	static int josh=0;
	static int newA = 0;
	static int  assign, jakeSteps, otherSteps, thirdSteps, fourthSteps, fifthSteps;
	static int distance=0, temp=1;
	static int i = 0,z=0;
	static int Carl=0, vplace, horizontalSteps, a2,jinplace, Jake1;
	static String s;
	static int theStoppingNumber = 0;
	static int carNumber = 1, counter=0, counterJohn = 6;
	static String name = "Car", userResponse; 
	public static Customer customer, customer2, customer3, customer4, customer5, customer6,
	customer7,customer8,customer9,customer10, defaultCar;
	 static LinkedList <String> List= new LinkedList <>();

	public static void horizontalLane(Customer carr, int SyncCount) throws Exception
	{//dequeue after car is done being used

		if(carr.customerNumber==1)
		{
			customer=carr;
			System.out.println("car "+customer.customerNumber);
			return;
		}
		if (carr.customerNumber==2)
		{
			customer2=carr;
			System.out.println("car "+customer2.customerNumber);
			return;
		}
		if (carr.customerNumber==3)
		{
			customer3=carr;
			System.out.println("car "+customer3.customerNumber);
			return;
		}
		if (carr.customerNumber==4)
		{
			customer4=carr;
			System.out.println("car "+customer4.customerNumber);
			return;
		}
		if (carr.customerNumber==5)
		{
			customer5=carr;
			System.out.println("car "+customer5.customerNumber);
			//return;
		}
		
		System.out.println();
		do 
		{   	
			Jake1 = 1;
			distance = distance + Jake1;
			System.out.println("distance="+distance);
			space();
			jake();
		}
		while ( distance<26);

	}

	public static void space() throws InterruptedException
	{
		//this makes the racers look like they are moving. z=0 z<distance-name z++ and if name<50 space else print|
		Thread.sleep(1000);
		for (int d = 0; d < 30; d++) //this loop prevents names from printing in the wrong places
			//by printing out 30 spaces in between each printed image
		{
			System.out.println();
		};
	}

	public static void jake() throws Exception
	{
		System.out.println("\n-------------------------------------------------------------------------------------------");
		for (fifthSteps = 0; fifthSteps < distance; fifthSteps++)
		{
			//---------------------------car5
			if(fifthSteps>4)
			{
				System.out.print("    ");
			}
		}
		if (fifthSteps<5)
		{
			System.out.print("");
		}

		else if (fifthSteps>=5 && fifthSteps<26 && fifthSteps!=10)
		{
			System.out.print("#"+customer.customerNumber+"  ");
		}
		else if(fifthSteps==26)
		{
			System.out.print("");
			GUI1 gui = new GUI1();
			gui.GUI(customer, heap);
		}
		else if (fifthSteps>26)
		{
			System.out.print("");
			
		}
		for ( fourthSteps = 0; fourthSteps < distance; fourthSteps++)
		{
			//---------------------------car4
		}
		if (fourthSteps<4)
		{
			System.out.print("");
		}
		else if (fourthSteps>=4 && fourthSteps<25)
		{
			System.out.print("#"+customer2.customerNumber+"  ");
		}
		else if (fourthSteps>25)
		{
			System.out.print("");
			
		}
		else if(fourthSteps==25)
		{
			System.out.print("");
			GUI2 gui2 = new GUI2();
			gui2.GUI(customer2, heap);
		}
		for ( thirdSteps = 0; thirdSteps < distance; thirdSteps++)
		{
			//---------------------------car3
		}
		if(thirdSteps>24)
		{
			System.out.print("");
		}
		else if(thirdSteps==24)
		{
			System.out.print("");
			GUI3 gui = new GUI3();
			gui.GUI(customer3, heap);
		}
		else if (thirdSteps>=3)
		{
			System.out.print("#"+customer3.customerNumber+"  ");
		}
		for ( otherSteps = 0; otherSteps < distance; otherSteps++)
		{

		}
		if (otherSteps<2)
		{
			System.out.print("");
		}
		else if (otherSteps>=2 && otherSteps<23)
		{
			System.out.print("#"+customer4.customerNumber+"  ");
		}
		else if (otherSteps==23)
		{
			System.out.print("");
			GUI4 gui = new GUI4();
			gui.GUI(customer4, heap);
		}
		else if (otherSteps>23)
		{
			System.out.print("");
		}
		//----------------------------------------------------------------------car5	
		for (horizontalSteps= 0; horizontalSteps < distance; horizontalSteps++)
		{
		};
		if(distance<22)
		{

			System.out.print("#"+customer5.customerNumber+"  ");
		}
		else if (distance==22)
		{
			System.out.print("");
			GUI5 gui = new GUI5();
			gui.GUI(customer5, heap);
			//GUI gui = new GUI(car, car2,car3,car4,car5);
		}
		else if(distance>22)
		{
			System.out.print("");
						
		}
		System.out.println("\n-------------------------------------------------------------------------------------------");
	}
}