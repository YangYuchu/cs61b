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
}