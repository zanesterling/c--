public class Bullet extends Actor{

	static final int DAMAGE = 5; //dummy value

	public Bullet(){ 
		super(Main.game.player.x, Main.game.player.y); 
	}

	public void thingEffect(Actor a){ 
		a.health -= DAMAGE; 
	}

}
