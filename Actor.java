import java.awt.image.BufferedImage;

public abstract class Actor {

    static final int HEALTH;
	static final Weapon WEAPON;
	
	//coordinates
	double x, y;
	double vx, vy, vt;
	double dt;
	
	Weapon wep;

	BufferedImage img;

	int radius, health;

	public Actor(double x, double y) {
	    health = HEALTH;
		wep = WEAPON;
		this.x = x;	
		this.y = y;
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

	
	public void die(){
	
	}
	
	abstract void move();
}
