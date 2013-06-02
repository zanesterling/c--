import java.util.ArrayList;
import java.awt.Color;

public class SpaceDebris extends Enemy {

	double accel;

	public SpaceDebris(double x, double y) {
		super(x,y);
		accel = 5000;
		vx = 3;
		damage = 1;
		
		color = Color.WHITE;

		points = new ArrayList<int[]>();
		points.add(new int[]{radius,0});
		points.add(new int[]{0,radius});
		points.add(new int[]{-radius,0});
		points.add(new int[]{0,-radius});
	}

	public void update() {
		Player p = Main.game.player;
		double theta = Math.atan2(p.y - y, p.x - x);
		double distanceSquared = (p.y - y) * (p.y - y) + (p.x - x) * (p.x - x);

		vx += accel * Math.cos(theta) / distanceSquared;
		vy += accel * Math.sin(theta) / distanceSquared;

		super.update();

		if (distanceSquared < (radius+p.radius)*(radius+p.radius))
			attack(p);
	}

	public void attack(Player p) {
		p.health -= damage;
		die();
	}
}
