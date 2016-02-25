import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FileParser{

	public static List<Land>landVehicleList=new ArrayList<Land>();
	public static List<Air>AirVehicleList=new ArrayList<Air>();
	public static List<Water>WaterVehicleList=new ArrayList<Water>();
	public static int counter=0;
    static ObserverRegister ob = new ObserverRegister();
    static Management mg = new Management();
	public static FMSPoint fmsObj = new FMSPoint();
	
	public static void main(String args[]) throws IOException {
    FileParser parser = new FileParser(args[0]);
		FileParser.ob.attach(mg);
    Logger.getInstance().log("Reading Vehicle Details from Asset Input File......................");
    parser.assetProcessor(args[0]);
    //Logger.getInstance().log("Reading Rule Book......................");
    //parser.ruleProcessor(args[1]);
    Logger.getInstance().log("Reading DRS data from testfile2.txt.............................");
	fmsObj.processParam(args[1]);
    Logger.getInstance().log("Parsing Done.");
  
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
	
  }
  
  /**
   Constructor.
   @param aFileName full name of an existing, readable file.
  */
  public FileParser(String aFileName){
    fFilePath = Paths.get(aFileName);
  }
  
  public void ruleProcessor(String input) throws FileNotFoundException, IOException
  {
	  
  }
  
  public void assetProcessor(String input) throws FileNotFoundException, IOException
  {
	  AssetProperties assetObj = new AssetProperties();
	  FileInputStream inputStream = new FileInputStream(input);
	  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	  String strLine;
	  AbstractFactory abs ;
		List<String> vehicleFamilyList = new ArrayList<>();
		List<String> vehicleTypeList = new ArrayList<>();
		List<String> parameterList = new ArrayList<>();
		List<String> instanceList = new ArrayList<>();

	  while((strLine = reader.readLine()) != null)
	  {
			if (strLine.startsWith("[VEHICLE_FAMILY]")) {
				String[] vehicleFamilyType = strLine.split("=");
				vehicleFamilyList.add(vehicleFamilyType[1]);
			} else if (strLine.startsWith("[VEHICLE_TYPE]")) {
				String[] vehicleType = strLine.split("=");
				vehicleTypeList.add(vehicleType[1]);
			}

			else if (strLine.startsWith("[PARAMETER]")) {
				String[] parameter = strLine.split("=");
				parameterList.add(parameter[1]);
			} else if (strLine.startsWith("[DEFINE_VEHICLE]")) {
				String[] instance = strLine.split("=");
				instanceList.add(instance[1]);
			}
	  }

	  for(int i=0; i<parameterList.size(); i++)
	  {
		  processWord(instanceList.get(i),assetObj);
		  processField(parameterList.get(i),assetObj);

		  switch(assetObj.type)
		  {
		  case "TRUCK":
			    abs = FactoryProducer.getFactory("LAND");
				landVehicleList.add(abs.getLandVehicle(assetObj.type,assetObj.id, assetObj.min,assetObj.max));
			  break;
		  case "CAR":
			  abs = FactoryProducer.getFactory("LAND");
			  landVehicleList.add(abs.getLandVehicle(assetObj.type,assetObj.id, assetObj.min,assetObj.max));
			  break;
		  case "PLANE":
			  abs = FactoryProducer.getFactory("AIR");
				AirVehicleList.add(abs.getAirVehicle(assetObj.type,assetObj.id, assetObj.min,assetObj.max));
			  break;
		  case "HELICOPTER":
			  abs = FactoryProducer.getFactory("AIR");
				AirVehicleList.add(abs.getAirVehicle(assetObj.type,assetObj.id, assetObj.min,assetObj.max));
			  break;
		  case "SHIP":
			  abs = FactoryProducer.getFactory("WATER");
				WaterVehicleList.add(abs.getWaterVehicle(assetObj.type,assetObj.id, assetObj.min,assetObj.max));
			  break;
		  case "YACHET":
			  abs = FactoryProducer.getFactory("WATER");
			  WaterVehicleList.add(abs.getWaterVehicle(assetObj.type,assetObj.id, assetObj.min,assetObj.max));
			  break;
		  }
		  
	  }
	  reader.close();
  }
  
  protected void processField(String aField, AssetProperties assetObj){
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
		  
		  assetObj.min=Integer.parseInt(field31.trim());
		  assetObj.max=Integer.parseInt(field4.trim());
		  assetObj.type=field2.trim();
	  }
	  else 
	      Logger.getInstance().log("Empty or invalid field. Unable to process.");
  }
  
  protected void processWord(String aWord, AssetProperties assetObj){
	  Scanner scanner2 = new Scanner(aWord);
	  scanner2.useDelimiter(":");
	  if (scanner2.hasNext()){
		  String family = scanner2.next();
		  String type = scanner2.next();
		  String id = scanner2.next();
		  assetObj.id=id.trim();
	  }
	  else {
	      Logger.getInstance().log("Empty or invalid field. Unable to process.");
	    }
	  
  }
  // PRIVATE 
  private final Path fFilePath;
  private final static Charset ENCODING = StandardCharsets.UTF_8;  
  
  
} 
