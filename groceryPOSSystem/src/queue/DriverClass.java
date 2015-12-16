//package groceryPOSSystem;
package queue;

import test.gui;
import Heap.heap;

public class DriverClass
{
	public static void main(String []args) throws Exception
	{
		
		SyncCount count= new SyncCount();
		SyncCount2 count2= new SyncCount2();
		System.out.println("original count="+count);
		System.out.println("original count2="+count2);
		Runnable r1= new Increase(count, 2);
		Runnable r2= new Increase2(count2, 3);
		Thread t1= new Thread(r1);
		Thread t2= new Thread(r2);
		t1.start();
		t2.start();
		t1.join(); 		
		t2.join();
		System.out.println("count= "+count);
		System.out.println("count2= "+count2);
	}
}
