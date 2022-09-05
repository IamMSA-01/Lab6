import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIApp {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorJasin = (TemperatureSensor) rmiRegistry.lookup("SensorJasin");
			
			
			// Invoke method from the remote object
			int currentTemperatureJasin = remoteSensorJasin.getTemperature();
			
			System.out.println("Current temperature in Jasin is " + currentTemperatureJasin + " Celcius");
			
			//Monitoring temperature for a specific day in Jasin
			String day = "Friday";
			int temperatureJasin= remoteSensorJasin.getTemperature(day);
			System.out.println("Temperature in Jasin on "+ day +" is "+ temperatureJasin +" Celsius");
			
			//Monitoring average temperature Jasin
			
			int averageTemperatureJasin = remoteSensorJasin.getAverageTemperature();
			System.out.println("Average Temperature in Jasin on "+day+" is "+averageTemperatureJasin+" Celsius");
			
			System.out.println();
			
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAyerKeroh");
			int currentTemperatureAyerKeroh = remoteSensorAyerKeroh.getTemperature();
			System.out.println("Current temperature in Ayer Keroh is " + currentTemperatureAyerKeroh + " Celcius");
			
			//Monitoring temperature for a specific day in Ayer KEroh
			 day = "Sunday";
			int temperatureAyerKeroh= remoteSensorAyerKeroh.getTemperature(day);
			System.out.println("Temperature in Ayer Keroh on "+ day +" is "+ temperatureAyerKeroh +" Celsius");
			
			
			 //Monitoring average temperature Ayer Keroh
			  
			int averageTemperatureAyerKeroh = remoteSensorAyerKeroh.getAverageTemperature();
			System.out.println("Average Temperature in Ayer Keroh on "+day+" is "+averageTemperatureAyerKeroh+" Celsius");
		
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}