import java.awt.image.BufferedImage;

public class Actor {

	//coordinates
	double x, y;
	double vx, vy, vt;

	BufferedImage img;

	int width, height;

	public Actor(int x, int y, String imgpath) {
		this.x = x;
		this.y = y;

		img = Util.loadImg(imgpath);
	}

	public void update() {
		relativityUpdate();
	}

	public static double[] updateVectors(double dVx, double dVy) {
		v = Lorentz.transform(
	}

	

	
}
