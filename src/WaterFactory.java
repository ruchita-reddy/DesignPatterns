
public class WaterFactory extends AbstractFactory{
	@Override
	public Water getWaterVehicle(String id, String vehId, int min, int max)
	{
		switch(id)
		{
		case "SHIP": return new Ship(vehId, min, max);
		case "YACHET": return new Yachet(vehId, min, max);
		default: return null;
		}
	}
	
	@Override
	public Land getLandVehicle(String id, String vehId, int min, int max)
	{
		return null;
	}
	
	@Override
	public Air getAirVehicle(String id, String vehId, int min, int max)
	{
		return null;
	}
}
