import java.util.ArrayList;

//Acts like BasicEnemy, but charges in close range
public class ChargeEnemy extends BasicEnemy {

	double accel;

	public ChargeEnemy(double x, double y) {
		super(x,y);
	}

	public void update() {
		Player p = Main.game.player;
		double theta = Math.atan2(p.y - y, p.x - x);

		vx += accel * Math.cos(theta);
		vy += accel * Math.sin(theta);

		super.update();
		if ((p.y-y)*(p.y-y) + (p.x-x)*(p.x-x) < 20){
			accel = 1.0;											//charges
		if ((p.y-y)*(p.y-y) + (p.x-x)*(p.x-x) < radius + p.radius)
			attack(p);
		}
		else accel = 0.1;
	}

}
