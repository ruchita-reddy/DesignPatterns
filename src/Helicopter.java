package ge.com;

public class Helicopter implements Air{
	int minSpeed;
	int maxSpeed;
	String identifier;
	public Helicopter(String id, int min, int max)
	{
		identifier=id;
		minSpeed=min;
		maxSpeed=max;
	}
	
	public void initializeAirVehicle()
	{
		System.out.println("Made a HELICOPTER");
	}
	
	@Override
	public String toString() {
		return identifier+"-"+minSpeed+"-"+maxSpeed;
	}

}
