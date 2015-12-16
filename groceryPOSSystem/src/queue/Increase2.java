//package groceryPOSSystem;
package queue;

public class Increase2 implements Runnable
{
	private SyncCount2 carnum;
	private int number;
	public Increase2(SyncCount2 carnum, int number)
	{
		this.carnum=carnum;
		this.number=number;
		//run();
	}
	public String toString()
	{
		return "(increase2)Count is:\t" + carnum;
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