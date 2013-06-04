import java.util.ArrayList;
import java.awt.Color;

public class BasicEnemy extends Enemy {

	double accel;

	public BasicEnemy(double x, double y) {
		super(x,y);
		accel = 0.1;

		radius = 8;
		damage = 1;
		health = 1;
		
		points = new ArrayList<int[]>();
		
		points.add(new int[]{0,-7});
		points.add(new int[]{-7, 7});
		points.add(new int[]{7, 7});

		color = Color.RED;
	}

	public void update() {
		Player p = Main.game.player;
		double theta = Math.atan2(p.y - y, p.x - x);

		vx += accel * Math.cos(theta);
		vy += accel * Math.sin(theta);

		super.update();

		if ((p.y-y)*(p.y-y) + (p.x-x)*(p.x-x) < Math.pow(radius + p.radius, 2))
			attack(p);
	}

	public void attack(Player p) {
		p.health -= damage;
		die();
	}
}
