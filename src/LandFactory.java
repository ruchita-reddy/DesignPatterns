package ge.com;

public class LandFactory extends AbstractFactory {

	@Override
	public Land getLandVehicle(String id, String vehId, int min, int max)
	{
		switch(id)
		{
		case "TRUCK": return new Truck(vehId, min, max);
		case "CAR": return new Car(vehId, min, max);
		default: return null;
		}
	}
	
	@Override
	public Air getAirVehicle(String id, String vehId, int min, int max)
	{
		return null;
	}
}
