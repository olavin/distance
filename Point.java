package distance;

public class Point {
    protected double longitude = 0;
    protected double latitude = 0;
        
    public Point(double longitude, double latitude){
    	if(longitude > 180 || longitude < -180)
    		throw new IllegalArgumentException("longitude must be +/- 180 degree");
    	if(latitude > 90 || latitude < -90)
    		throw new IllegalArgumentException("latitude must be +/- 90 degree");
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void print(){
    	System.out.printf("%f, %f\n", longitude, latitude);
    }

    @Override
    public String toString(){
    	return String.format("%f, %f", longitude, latitude);
    }

    // distance in kilometers
    public double distanceTo(Point p){
        final double R = 6371.0; // radius of the earth in kilometers

    	// using "the haversine formula" to calculate distance in kilometers
        double latDistance = toRad(p.latitude-this.latitude);
        double lonDistance = toRad(p.longitude-this.longitude);
      	
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
                Math.cos(toRad(this.latitude)) * Math.cos(toRad(p.latitude)) * 
                Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
     
    }
    
    // convert degrees to radians
    private static double toRad(double degree) {
        return degree * Math.PI / 180;
    }
    
}
