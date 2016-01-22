import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FMSPoint {
	
	  public void processParam(String inputFile) throws IOException {
		  //System.out.println("Input in FMS = "+inputFile);
		    Path pth = Paths.get(inputFile);
		    try (Scanner scannerP =  new Scanner(pth)){
		      while (scannerP.hasNextLine()){
		        processMultiple(scannerP.nextLine());
		      }      
		    }
		  }
	  
	  protected void processMultiple(String aLine){
		  Scanner scanner4 = new Scanner(aLine);
		  boolean result;
		  scanner4.useDelimiter(",");
		  if (scanner4.hasNext()){
			  String one =scanner4.next();
			  String two =scanner4.next();
			  String data1[] = one.split(":");
			  String data3[] = data1[1].split("=");
			  
			  String data2[] = two.split(":");
			  String data4[] = data2[1].split("=");
			  
			  data2[0]=data2[0].substring(1);
			  //System.out.println("data1[0]="+data1[0]+" data3[1]="+data3[1]);
			  //System.out.println("data2[0]="+data2[0]+" data4[1]="+data4[1]);
			  if(data1[0].startsWith("L"))
			  {
				    String data5[];
					String[] array = new String[FileParser.landVehicleList.size()];
					int index = 0;
					for (Land value : FileParser.landVehicleList) {
					  array[index] = String.valueOf( value );
					  
					  data5=array[index].split("-");

					  result = findAnomaly(data5[0], data1[0],Integer.parseInt(data5[1]),Integer.parseInt(data5[2]),
							  Integer.parseInt(data3[1]));

					  if(result)
					  {
						  System.out.println("Anomaly Found!!!");
						  break;
					  }
					  index++;
					}
			  }
			  else if(data1[0].startsWith("A"))
			  {
				    String data5[];
					String[] array = new String[FileParser.AirVehicleList.size()];
					int index = 0;
					for (Air value : FileParser.AirVehicleList) {
					  array[index] = String.valueOf( value );
					  
					  data5=array[index].split("-");

					  result = findAnomaly(data5[0], data1[0],Integer.parseInt(data5[1]),Integer.parseInt(data5[2]),
							  Integer.parseInt(data3[1]));

					  if(result)
					  {
						  System.out.println("Anomaly Found!!!");
						  break;
					  }
					  index++;
					}
			  }
			  else if(data1[0].startsWith("S"))
			  {
				    String data5[];
					String[] array = new String[FileParser.WaterVehicleList.size()];
					int index = 0;
					for (Water value : FileParser.WaterVehicleList) {
					  array[index] = String.valueOf( value );
					  
					  data5=array[index].split("-");

					  result = findAnomaly(data5[0], data1[0],Integer.parseInt(data5[1]),Integer.parseInt(data5[2]),
							  Integer.parseInt(data3[1]));

					  if(result)
					  {
						  System.out.println("Anomaly Found!!!");
						  break;
					  }
					  index++;
					}
					
			  }
			  
			  if(data2[0].startsWith("L"))
			  {
				    String data5[];
					String[] array = new String[FileParser.landVehicleList.size()];
					int index = 0;
					for (Land value : FileParser.landVehicleList) {
					  array[index] = String.valueOf( value );
					  
					  data5=array[index].split("-");

					  result = findAnomaly(data5[0], data2[0],Integer.parseInt(data5[1]),Integer.parseInt(data5[2]),
							  Integer.parseInt(data4[1]));

					  if(result)
					  {
						  System.out.println("Anomaly Found!!!");
						  break;
					  }
					  index++;
					}
			  }
			  else if(data2[0].startsWith("A"))
			  {
				    String data5[];
					String[] array = new String[FileParser.AirVehicleList.size()];
					int index = 0;
					for (Air value : FileParser.AirVehicleList) {
					  array[index] = String.valueOf( value );
					  
					  data5=array[index].split("-");

					  result = findAnomaly(data5[0], data2[0],Integer.parseInt(data5[1]),Integer.parseInt(data5[2]),
							  Integer.parseInt(data4[1]));

					  if(result)
					  {
						  System.out.println("Anomaly Found!!!");
						  break;
					  }
					  index++;
					}
			  }
			  else if(data2[0].startsWith("S"))
			  {
				    String data5[];
					String[] array = new String[FileParser.WaterVehicleList.size()];
					int index = 0;
					for (Water value : FileParser.WaterVehicleList) {
					  array[index] = String.valueOf( value );
					  
					  data5=array[index].split("-");

					  result = findAnomaly(data5[0], data2[0],Integer.parseInt(data5[1]),Integer.parseInt(data5[2]),
							  Integer.parseInt(data4[1]));

					  if(result)
					  {
						  System.out.println("Anomaly Found!!!");
						  break;
					  }
					  index++;
					}
					
			  }  
		  }  
	  }
	  
	  protected boolean findAnomaly(String idInList, String idFromFile, int rangeMin, int rangeMax, int rcvVal)
	  {
		  if(idInList.equals(idFromFile))
		  {
			  if(rangeMin < rcvVal
					  && rcvVal < rangeMax)
			  {
				  /*Nothing comes here*/
			  }
			  else
			  {
				  FileParser.ob.setAnomaly(true);
				  return true;
			  } 
		  }
		  return false;
	  }
	  
}
