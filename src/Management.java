
public class Management implements Observer{

	//ObserverRegister localRegister;
	/*
	public Management(ObserverRegister ob)
	{
		this.obr=ob;
		this.obr.attach(this);
	}
	*/
	
	public void notifyMe()
	{
		System.out.println("Management has been Notified - Thank You !!!");
	}
}
