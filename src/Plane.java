package ge.com;

public class Plane implements Air {
	int minSpeed;
	int maxSpeed;
	String identifier;
	
	public Plane(String id, int min, int max)
	{
		identifier=id;
		minSpeed=min;
		maxSpeed=max;
	}
	
	public void initializeAirVehicle()
	{
		System.out.println("Made a "+ this.identifier);
	}
	
	@Override
	public String toString() {
		return identifier+"-"+minSpeed+"-"+maxSpeed;
	}
}
