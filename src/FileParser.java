import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/** Assumes UTF-8 encoding. JDK 7+. */
public class FileParser{

	public static List<Land>landVehicleList=new ArrayList<Land>();
	public static List<Air>AirVehicleList=new ArrayList<Air>();
    static ObserverRegister ob = new ObserverRegister();
    static Management mg = new Management();
	
	public static void main(String args[]) throws IOException {
    //FileParser parser = new FileParser(args[0]);
		
    log("Reading Vehicle Details from testfile1.txt......................");
    //parser.processInput();
    FileParser parser1=new FileParser(args[1]);
    FileParser.ob.attach(mg);
    log("Reading DRS data from testfile2.txt.............................");
	AbstractFactory abs = FactoryProducer.getFactory("LAND");
	landVehicleList.add(abs.getLandVehicle("TRUCK","L0001", 0, 100));
	landVehicleList.add(abs.getLandVehicle("CAR","L0002", 0, 80));
	abs = FactoryProducer.getFactory("AIR");
	AirVehicleList.add(abs.getAirVehicle("PLANE","A0001", 0, 300));
	AirVehicleList.add(abs.getAirVehicle("HELICOPTER","A0002", 0, 500));
    parser1.processParam();
    log("Parsing Done.");
  
	/*
	for (int i=0;i<landVehicleList.size();i++)
	{
		System.out.println(landVehicleList.get(i));
	}
	*/

	/*
	for (int i=0;i<airVehicleList.size();i++)
	{
		System.out.println(airVehicleList.get(i));
	}
	*/
	
	/* ******************SANDESH CHANGES WILL COME HERE****************************
	 * for(int i=0;i<twoDimensionalArray.NoOfRows,i++)
	 * {
	 * 		if(str1 == "LAND")
	 *      {
	 *          abs = FactoryProducer.getFactory("LAND");
	 *          landVehicleList.add(abs.getLandVehicle(str2,str3, min, max));
	 *      }
	 *      else if(str1 == "AIR")
	 *      {
	 *         abs = FactoryProducer.getFactory("AIR");
	 *         airVehicleList.add(abs.getAirVehicle(str2,str3, min, max));
	 *      }    
	 * }
	 * */
  }
  
  /**
   Constructor.
   @param aFileName full name of an existing, readable file.
  */
  public FileParser(String aFileName){
    fFilePath = Paths.get(aFileName);
  }
  
  
  /** Template method that calls {@link #processLine(String)}.  */
  public final void processInput() throws IOException {
    try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
      while (scanner.hasNextLine()){
        processLine(scanner.nextLine());
      }      
    }
  }
  
  public final void processParam() throws IOException {
	    
	    try (Scanner scannerP =  new Scanner(fFilePath, ENCODING.name())){
	      while (scannerP.hasNextLine()){
	        processMultiple(scannerP.nextLine());
	      }      
	    }
	  }
  /** 
   Overridable method for processing lines in different ways.
    
   
  */
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
				String[] array = new String[landVehicleList.size()];
				int index = 0;
				for (Land value : landVehicleList) {
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
				String[] array = new String[AirVehicleList.size()];
				int index = 0;
				for (Air value : AirVehicleList) {
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
		  else if(data1[0].startsWith("W"))
		  {
			  /*
			    String data5[];
				String[] array = new String[WaterVehicleList.size()];
				int index = 0;
				for (Water value : WaterVehicleList) {
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
				*/
		  }
		  
		  if(data2[0].startsWith("L"))
		  {
			    String data5[];
				String[] array = new String[landVehicleList.size()];
				int index = 0;
				for (Land value : landVehicleList) {
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
				String[] array = new String[AirVehicleList.size()];
				int index = 0;
				for (Air value : AirVehicleList) {
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
		  else if(data2[0].startsWith("W"))
		  {
			  /*
			    String data5[];
				String[] array = new String[WaterVehicleList.size()];
				int index = 0;
				for (Water value : WaterVehicleList) {
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
				*/
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
  
  protected void processLine(String aLine){
    //use a second Scanner to parse the content of each line 
    Scanner scanner1 = new Scanner(aLine);
    scanner1.useDelimiter("=");
    if (scanner1.hasNext()){
      //assumes the line has a certain structure
      String name = scanner1.next();
      String value = scanner1.next();
      if(name.equals("[DEFINE_VEHICLE]"))
    	  processWord(value);
      if(name.equals("[PARAMETER]"))
    	  processField(value);
     // log("Parameter is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
    }
    else {
      log("Empty or invalid line. Unable to process.");
    }
  }
  protected void processField(String aField){
	  Scanner scanner3 = new Scanner(aField);
	  scanner3.useDelimiter(":");
	  if (scanner3.hasNext()){
		  String field1=scanner3.next();
		  String field2=scanner3.next();
		  String field3=scanner3.next();
		  field3=field3.replaceAll("\\(","");
		 
		  String field31=field3.replaceAll("[^0-9]", "");
		  field3=field3.replaceAll("\\d", "");
		  String field4=scanner3.next();
		  field4=field4.replaceAll("\\)","");
		  log(quote(field1.trim()) +quote(field2.trim())+quote(field3.trim())+quote(field31.trim())+ quote(field4.trim()));  
	  }
	  else 
	      log("Empty or invalid field. Unable to process.");
  }
  
  protected void processWord(String aWord){
	  Scanner scanner2 = new Scanner(aWord);
	  scanner2.useDelimiter(":");
	  if (scanner2.hasNext()){
		  String family = scanner2.next();
		  String type = scanner2.next();
		  String id = scanner2.next();
		  log(quote(family.trim()) + quote(type.trim())+ quote(id.trim()));
	  }
	  else {
	      log("Empty or invalid field. Unable to process.");
	    }
	  
  }
  // PRIVATE 
  private final Path fFilePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }
  
  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
} 
