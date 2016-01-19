package ge.com;

public class Truck implements Land{
	int minTemp;
	int maxTemp;
	String identifier;
	
	public Truck(String id, int min, int max)
	{
		identifier=id;
		minTemp=min;
		maxTemp=max;
	}
	
	public void initializeLandVehicle(String input)
	{
		System.out.println("Made a TRUCK");
	}
	
	public void getVal(String id)
	{
		//
	}
	
	@Override
	public String toString() {
		return identifier+"-"+minTemp+"-"+maxTemp;
	}
}
