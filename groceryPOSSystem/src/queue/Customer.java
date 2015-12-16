//package groceryPOSSystem;
package queue;

import java.util.Scanner;
public class Customer //extends SyncCount
{
	
	int customerNumber;
	double cash;
	public Customer(int customerNumber, double cash)
	{
		this.customerNumber=customerNumber;
		this.cash=cash;
		System.out.println("cash is "+cash);
		System.out.println("customerNumber is "+customerNumber);
		//StoppingTime();
	}
}