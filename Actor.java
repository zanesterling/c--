import java.awt.image.BufferedImage;

public class Actor {

	//coordinates
	double x, y;
	double vx, vy, vt;
	double dt;

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
		updateVectors();
	}

	public void updateVectors() {
		double dVx = Main.game.player.dVx;
		double dVy = Main.game.player.dVy;
		double[] v = Lorentz.transform(vt, vx, vy, dVx, dVy);
		vt = v[0];
		vx = v[1];
		vy = v[2];
		v = Lorentz.transform(0, x, y, dVx, dVy);
		dt = v[0];
		x = v[1];
		y = v[2];
	}

	public void collide(Thing thing) {}

	public void collide(Actor actor) {}	

	
}
