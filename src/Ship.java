
public class Ship implements Water{
	int minTemp;
	int maxTemp;
	String identifier;
	
	public Ship(String id, int min, int max)
	{
		identifier=id;
		minTemp=min;
		maxTemp=max;
	}
	
	public void initializeWaterVehicle(String input)
	{
		System.out.println("Made a SHIP");
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
