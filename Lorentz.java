public class Lorentz {

	public static double[] transform(double t, double vx, double vy, double dVx, double dVy) {
	    double[] v = new double[3]; 
		double c = Main.game.c;
		double Bx = dVx / c;
		double By = dVy / c;
		double gamma = 1 / Math.sqrt(1 - (Bx * Bx) - (By * By));
		v[0] = (gamma / c) * (c * t - vx * Bx - vy * By);
		v[1] = - gamma * Bx * c * t + (1 + (gamma - 1) * ((Bx * Bx) / (Bx * Bx + By * By))) * vx + (gamma - 1) * ((Bx * By) / (Bx * Bx + By * By));
		v[2] = - gamma * By * c * t + (1 + (gamma - 1) * ((By * By) / (By * By + Bx * Bx))) * vy + (gamma - 1) * ((Bx * By) / (Bx * Bx + By * By));
		return v;
	}

	public static double[] contract(double xcor, double ycor, double vx, double vy) {
		double[] u = new double[2];
		double inverseGamma = Math.sqrt(1 - vx * vx + vy * vy / (Game.c * Game.c));
		double vFactor = (inverseGamma - 1) * (xcor * vx + ycor * vy) / (vx * vx + vy * vy);
		u[0] = xcor + vFactor * vx;
		u[1] = ycor + vFactor * vy;
		return u;
	}
	
}
