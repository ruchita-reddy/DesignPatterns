
public class Yachet implements Water {
	int minTemp;
	int maxTemp;
	String identifier;
	
	public Yachet(String id, int min, int max)
	{
		identifier=id;
		minTemp=min;
		maxTemp=max;
	}
	
	public void initializeWaterVehicle(String input)
	{
		System.out.println("Made a YACHET");
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
