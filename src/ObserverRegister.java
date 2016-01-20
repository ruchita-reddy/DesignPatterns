import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class ObserverRegister extends Observable  {
	private List<Observer> observers = new ArrayList<Observer>();
	private boolean anomaly;
	
   public void attach(Observer observer){
	      observers.add(observer);		
	   }

   public void notifyAllObservers()
   {
	      for (Observer observer : observers) 
	      {
	         observer.notifyMe();
	      }
   }

	public boolean getAnomaly() {
		return anomaly;
	}
	
	public void setAnomaly(boolean anomaly) {
		this.anomaly = anomaly;
		if(this.anomaly==true)
		notifyAllObservers();
	} 
}
