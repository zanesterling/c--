public class Grenade extends Bullet{
	
	public Grenade(double theta){
		super(theta);
	}

	public void update() {
		super.update();

		Player p = Main.game.player;
		if (Math.pow(p.x-x,2) + Math.pow(p.y-y,2) >= Math.pow(MAXDIST, 2))
			explode();
	}

	public void explode() {
		for(Actor a: Main.game.actors){
			if (Math.pow(x-a.x,2) + Math.pow(y-a.y,2) < Math.pow(3 * radius + 3 * a.radius,2))
				a.takeDamage(DAMAGE);
				System.out.println("splat " + Main.game.actors.size());
		}
		die();
	}

}