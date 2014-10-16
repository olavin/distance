package distance;

public class PointsGenerator {
	// limit random area to Ivano-Framkivsk city
	// from Lysets: 48.8689923,24.6090263
	static final double minLongitude = 48.8689923;
    static final double minLatitude = 24.6090263;
	// to Kolodiyvka: 48.9788,24.767165
    static final double maxLongitude = 48.9788;
    static final double maxLatitude = 24.767165;
	
	public static Point randomPoint(){
		double longitude = minLongitude + Math.random() * (maxLongitude - minLongitude);  
		double latitude = minLatitude + Math.random() * (maxLatitude - minLatitude);
		return new Point(longitude, latitude);
	}

}
