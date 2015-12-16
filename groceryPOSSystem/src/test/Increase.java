package test;

import queue.EmptyListException;

//package groceryPOSSystem;

public class Increase implements Runnable
{
	private SyncCount carnum;
	private int number;
	public Increase(SyncCount carnum, int number)
	{
		this.carnum=carnum;
		this.number=number;
		//run();
	}
	public String toString()
	{
		return "(increase)Count is:\t" + carnum;
	}
	@Override
	public void run()
	{
		for (int i = 1; i <= number; i++)
			try {
				this.carnum.increment();
				System.out.println("carnum=="+this.carnum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmptyListException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}