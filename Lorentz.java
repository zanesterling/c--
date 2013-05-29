public class Lorentz {

	public static double[] transform(double t, double vx, double vy, double dVx, double dVy) {
	    double[] v = new double[3]; 
		double Bx = dVx / c;
		double By = dVy / c;
		double gamma = 1 / Math.sqrt(1 - (Bx ^ 2) - (By ^ 2));
		v[0] = (gamma / c) * (c * t - vx * Bx - y * By);
		v[1] = - gamma * Bx * c * t + (1 + (gamma - 1) * ((Bx ^ 2) / (Bx ^ 2 + By ^ 2))) * vx + (gamma - 1) ((Bx * By) / (Bx ^ 2 + By ^ 2));
		v[2] = - gamma * By * c * t + (1 + (gamma - 1) * ((By ^ 2) / (By ^ 2 + Bx ^ 2))) * vy + (gamma - 1) ((Bx * By) / (Bx ^ 2 + By ^ 2));
		return v;
	}

	

	
}
