package test;

import static org.junit.Assert.*;

import org.junit.Test;

import queue.Increase;
import queue.SyncCount;

public class systemTest {

	@Test
	public void test() throws InterruptedException
	{
		//customers c= new customers();
		SyncCount count= new SyncCount();
		Runnable r1= new Increase(count, 5);
		Thread t1= new Thread(r1);
		t1.start();
		t1.join(); 		
	}

}
