//package ge.com;

public class Car implements Land {
	int minTemp;
	int maxTemp;
	String identifier;
	
	public Car(String id, int min, int max)
	{
		identifier=id;
		minTemp=min;
		maxTemp=max;
	}
	
	public void initializeLandVehicle(String input)
	{
		System.out.println("Made a CAR");
	}
	
	@Override
	public String toString() {
		return identifier+"-"+minTemp+"-"+maxTemp;
	}

	@Override
	public void getVal(String id) {
		// TODO Auto-generated method stub
		
	}
}
