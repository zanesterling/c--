import java.awt.Color;

public class Bullet extends Actor{

	static final int DAMAGE = 1; //dummy value

	double theta;

	public Bullet(double theta){ 
		super(Main.game.player.x, Main.game.player.y); 
		this.theta = theta;
		color = Color.BLUE;
		radius = 20;
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
