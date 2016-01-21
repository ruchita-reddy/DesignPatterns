//package ge.com;

public class FactoryProducer {
	
	public static AbstractFactory getFactory(String choice)
	{
		switch(choice)
		{
		case "LAND": return new LandFactory();
		case "AIR": return new AirFactory();
		case "WATER": return new WaterFactory();
		}
		
		return null;
	}

}
