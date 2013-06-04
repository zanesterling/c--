import java.awt.Color;

public class SniperBullet extends Bullet{

	public SniperBullet(double theta){ 
		super(theta);
		vx = Main.game.player.vx + Math.cos(theta) * 30;
		vy = Main.game.player.vy + Math.sin(theta) * 30;
	}

	
	public void collide(Actor a) {
		if (a != Main.game.player && !(a instanceof Bullet)) //make sure the bullet's not colliding with player or bullets
			if (Math.pow(x-a.x,2) + Math.pow(y-a.y,2) < Math.pow(2 * radius + 2 * a.radius,2)) { //distance check
				a.takeDamage(DAMAGE);
				System.out.println("splat " + Main.game.actors.size());
			}
	}

}
