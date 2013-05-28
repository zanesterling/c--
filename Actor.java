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
		for (Actor a : Main.game.actors)
			collide(a);
		for (Thing t : Main.game.things)
			collide(t);
		relativityUpdate();
	}

	public static double[] updateVectors(double dVx, double dVy) {
		v = Lorentz.transform(
	}

	public void collide(Actor actor) {}

	public void collide(Thing thing) {}

	

	
}
