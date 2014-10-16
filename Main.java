package distance;

import java.util.Scanner;
import java.util.Locale;

public class Main {
	
	public static void main(String args[]){
		test();
		distance();
	}

	public static void distance(){
		
		final int count = 20;
		Point[] pointsList = new Point[count];
		
		System.out.println("random points in area of Ivano-Frankivsk:");
		for(int i=0; i<count; i++){
			pointsList[i] = PointsGenerator.randomPoint();
			System.out.printf("%d : %s\n", i, pointsList[i].toString());
		}

		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.ENGLISH);
		System.out.println("Please enter you location:");
		System.out.print("longitude: ");
		double longitude = in.nextDouble(); 
		System.out.print("latitude: ");
		double latitude = in.nextDouble();
		Point position = new Point(longitude,latitude);
		
		System.out.print("Enter maximum distance in kilometers:");
		double maxdistance = in.nextDouble();  
		in.close();
		
		for(int i=0; i<count; i++){
			double distance = position.distanceTo(pointsList[i]); 
			if(distance <= maxdistance){
				System.out.printf("point %d : %s at distance %f km\n", i, pointsList[i].toString(), distance);
			}
		}
		
	}

	public static void test(){
		Point pIF = new Point(48.9117731,24.717129); // Ivano-Frankivsk
		Point pTysmenytsia = new Point(48.902202,24.847877); // Tysmenytsia
		Point pKalush = new Point(49.0444845,24.362008); // Kalush
		Point pKolomyja = new Point(48.5405875,25.0339445); // Kolomyja
		Point pLviv = new Point(49.8326891,24.0122356); // Lviv
		Point pKyiv = new Point(50.4020355,30.5326905); // Kyiv
		Point pLondon = new Point(51.5286416,-0.1015987); // London
		Point pNewYork = new Point(40.7056308,-73.9780035); // New York
		
		System.out.println("Distance in kilometers from Ivano-Frankivsk to:");
		System.out.printf("Tysmenytsia: %f\n", pIF.distanceTo(pTysmenytsia));
        System.out.printf("Kalush: %f\n", pIF.distanceTo(pKalush));
        System.out.printf("Kolomyja: %f\n", pIF.distanceTo(pKolomyja));
        System.out.printf("Lviv: %f\n", pIF.distanceTo(pLviv));
        System.out.printf("Kyiv: %f\n", pIF.distanceTo(pKyiv));
        System.out.printf("London: %f\n", pIF.distanceTo(pLondon));
        System.out.printf("New York: %f\n", pIF.distanceTo(pNewYork));
	}
	
}
