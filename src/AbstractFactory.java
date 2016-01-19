package ge.com;

public abstract class AbstractFactory {
	abstract Land getLandVehicle(String id, String VehId, int min, int max);
	abstract Air getAirVehicle(String id, String VehId, int min, int max);
}
