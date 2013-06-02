public class BasicEnemy extends Enemy {

	double accel;

	public BasicEnemy(double x, double y) {
		super(x,y);
		accel = 1;
	}

	public void update() {
		Player p = Main.game.player;
		double theta = Math.atan2(p.y - y, p.x - x);

		vx += accel * Math.cos(theta);
		vy += accel * Math.sin(theta);

		super.update();
	}

}
