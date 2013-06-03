public class Bullet extends Actor{

	static final int DAMAGE = 5; //dummy value

	double theta;

	public Bullet(double theta){ 
		super(Main.game.player.x, Main.game.player.y); 
		this.theta = theta;
	}

	public void collide(Actor a) {
		a.takeDamage(DAMAGE);
		die();
	}
}
