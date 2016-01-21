package FleetMonitoringSystem;


public class Logger {
	private static Logger instance;
	private Logger(){};
	public static Logger getInstance(){
		if(instance==null)
		{
			instance=new Logger();
			
		}
		return instance;
	}
	  public static void log(Object aObject){
	    System.out.println(String.valueOf(aObject));
	  }
	

}
