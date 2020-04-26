/** Simulate a universe specified in one of the data files
* @author Yang Yuchu
*/

public class NBody{

	public static double readRadius(String file){
        In in = new In(file);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;
	}

	public static Planet[] readPlanets(String file){
        In in = new In(file);
        int n = in.readInt();
        double radius = in.readDouble();
		Planet[] p = new Planet[n];
        for (int i = 0; i<n; i++){
        	double xP = in.readDouble();
        	double yP = in.readDouble();
        	double xV = in.readDouble();
        	double yV = in.readDouble();
        	double m = in.readDouble();
        	String img = in.readString();
        	p[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return p;
	}
}