/**Class that 
* @author Yang Yuchu
*/
public class Planet{
    
	/** instance variables initialization
	*/
	public static double gravity = 6.67e-11 ;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
    
    /** Planet constructor 1
    */
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** Planet constructor 2
    */
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;      
    }

    /** Calculate the distance
    */
    public double calcDistance(Planet p){
    	double x_distance = xxPos - p.xxPos;
    	double y_distance = yyPos - p.yyPos;
    	double distance = Math.sqrt(x_distance*x_distance+y_distance*y_distance);
        return distance;
    }

    /** Calculate the force
    */
    public double calcForceExertedBy(Planet p){
    	double force = (gravity * mass * p.mass) / (this.calcDistance(p) * this.calcDistance(p));
        return force;
    }


}