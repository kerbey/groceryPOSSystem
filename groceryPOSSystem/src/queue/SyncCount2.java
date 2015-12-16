//package groceryPOSSystem;
package queue;
public class SyncCount2
{
	//groceryPOSSystem.List<Customer> list= new groceryPOSSystem.List<Customer>();
	//Car car= new Car();//
	traffic t= new traffic();
	private int carnum, cash= (int)(Math.random() * ((100.00) + 1.00));
	public SyncCount2()
	{
		carnum=2;
	}
	@SuppressWarnings("static-access")
	public synchronized void increment() throws Exception
	{//enqueue car object with waiting time, car name involved
		// and after that move it to traffic class to print out
		System.out.println("increment");
		carnum++;
		Customer car= new Customer(carnum, cash);//not needed
		//list.enqeue(car);
		t.horizontalLane(car, carnum);
	}
	public String toString()
	{
		//System.out.println(list.getString());
		return "(synccount2)Count is:\t" + carnum;
	}
}