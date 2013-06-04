import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;

public class Actor {

	//coordinates
	double x, y;
	double vx, vy; //vx and vy are about velocity in the obvious way
	double vt; //vt is a measure of how much of the player's t coordinate is observed to elapse per unit time in the actor's reference frame
	
	BufferedImage img;
	int radius, health;

	ArrayList<int[]> points;
	Color color;

	public Actor(double x, double y) {
		this.x = x;	
		this.y = y;
		radius = 10;
	}

	public void update() {
		Player p = Main.game.player;

		//update position
		x += vx;
		y += vy;

		//do collisions
		for (Actor a : Main.game.actors)
			collide(a);
		for (Thing t : Main.game.things)
			collide(t);

		//if the player has moved, warp this actor around it
		if (this != p && p.dVx != 0 && p.dVy != 0)
			updateVectors();
	}

	//warping function
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

	public void takeDamage(int damage) {
		health -= damage;
		if (health <= 0)
			die();
	}

	public void die() {
		for (int i=0; i<Main.game.actors.size(); i++)
			if (this == Main.game.actors.get(i)){
				Main.game.actorDeathFlags.set(i, true);
				int random = (int)(Math.random() * 20);
				if(random < 3){
					if(random == 0)
						Main.game.addThing(new HealthPickup(this.x, this.y));
					else if(random == 1)
						Main.game.addThing(new ShotgunPickup(this.x, this.y));
					else Main.game.addThing(new MachinegunPickup(this.x, this.y));
				}
			}
	}
}


