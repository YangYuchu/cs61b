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

	/** main: to draw the initial universe state
	*/
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = NBody.readRadius(filename);
		Planet[] plist = NBody.readPlanets(filename);
		/*draw the background*/
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg", 2*radius, 2*radius);
		/*draw the planets*/
		for (Planet p : plist){
			p.draw();
		}
		StdDraw.enableDoubleBuffering();
		for(int time = 0; time <= T; time+=dt) {
			double[] xForces = new double[plist.length];
			double[] yForces = new double[plist.length];
			for (int i = 0; i<plist.length; i++){
				xForces[i] = plist[i].calcNetForceExertedByX(plist);
				yForces[i] = plist[i].calcNetForceExertedByY(plist);
			}
			for (int i = 0; i<plist.length; i++){
				plist[i].update(dt, xForces[i], yForces[i]);
			}
		StdDraw.picture(0, 0, "images/starfield.jpg", 2*radius, 2*radius);
		for (Planet p : plist){
			p.draw();
		}
		StdDraw.show();
		StdDraw.pause(10);
		}

	}
}