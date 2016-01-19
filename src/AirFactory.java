//package ge.com;

public class AirFactory extends AbstractFactory{
	
	@Override
	public Air getAirVehicle(String id, String vehId, int min, int max)
	{
		switch(id)
		{
		case "HELICOPTER": return new Helicopter(vehId, min, max);
		case "PLANE": return new Plane(vehId, min, max);
		default: return null;
		}
	}
	
	@Override
	public Land getLandVehicle(String id, String vehId, int min, int max)
	{
		return null;
	}
}
