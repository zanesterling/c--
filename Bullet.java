import java.awt.Color;

public class Bullet extends Actor{

	static final int MAXDIST = 800;
	static final int DAMAGE = 1;
	static final int SPEED = 15; //dummy value

	double theta;

	public Bullet(double theta){ 
		super(Main.game.player.x, Main.game.player.y); 

		this.theta = theta;

		color = Color.BLUE;
		radius = 5;

		vx = Main.game.player.vx + Math.cos(theta) * SPEED;
		vy = Main.game.player.vy + Math.sin(theta) * SPEED;
	}

	public void update() {
		super.update();

		Player p = Main.game.player;
		if (Math.pow(p.x-x,2) + Math.pow(p.y-y,2) > Math.pow(MAXDIST, 2))
			die();
	}

	public void collide(Actor a) {
		if (a != Main.game.player && !(a instanceof Bullet)) //make sure the bullet's not colliding with player or bullets
			if (Math.pow(x-a.x,2) + Math.pow(y-a.y,2) < Math.pow(radius + a.radius,2)) { //distance check
				a.takeDamage(DAMAGE);
				System.out.println("splat " + Main.game.actors.size());
				die();
			}
	}
}
