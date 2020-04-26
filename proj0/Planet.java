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

    /** Calculate the force on x-axis and y-axis
    */
    public double calcForceExertedByX(Planet p){
    	double x_force = this.calcForceExertedBy(p) * (p.xxPos-xxPos)/this.calcDistance(p);
        return x_force;
    }

    public double calcForceExertedByY(Planet p){
    	double y_force = this.calcForceExertedBy(p) * (p.yyPos-yyPos)/this.calcDistance(p);
        return y_force;
    }

    public double calcNetForceExertedByX(Planet[] p_list){
    	double x_net_force = 0;    	
    	for (Planet p : p_list) {
    		if (! this.equals(p)){
    			x_net_force += this.calcForceExertedByX(p);
    		}
    	}
        return x_net_force;
    }

    public double calcNetForceExertedByY(Planet[] p_list){
    	double y_net_force = 0;    	
    	for (Planet p : p_list) {
    		if (! this.equals(p)){
    			y_net_force += this.calcForceExertedByY(p);
    		}
    	}
        return y_net_force;
    }
}