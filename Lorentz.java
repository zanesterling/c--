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

	

	
}
