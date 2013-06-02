import java.awt.image.BufferedImage;

public abstract class Actor {

	//coordinates
	double x, y;
	double vx, vy; //vx and vy are about velocity in the obvious way
	double vt; //vt is a measure of how much of the player's t coordinate is observed to elapse per unit time in the actor's reference frame
	
	Weapon wep;
	BufferedImage img;
	int radius, health;

	public Actor(double x, double y) {
		this.x = x;	
		this.y = y;
		radius = 10;
	}

	public void update() {
		Player p = Main.game.player;
		x += vx;
		y += vy;
		for (Actor a : Main.game.actors)
			collide(a);
		for (Thing t : Main.game.things)
			collide(t);

		if (this != p && p.dVx != 0 && p.dVy != 0)
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
		x = v[1];
		y = v[2];
	}

	public void collide(Thing thing) {
		thing.collide(this);
	}

	public void collide(Actor actor) {}	

	
	public void die(){ /* Implement die: remove image from screen, etc. */	}
}


