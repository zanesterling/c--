public class HealthPickup extends Thing{

	public static final int HEALTH = 1;
		
	public HealthPickup(double x, double y){
		super(x,y);
	}

	public void thingEffect(Actor act){ 
		if(act instanceof Player){
			if(Main.game.player.health < 5)
				((Player)act).health += HEALTH; 
			Main.screen.message = "Health +1";
			Main.screen.lastMsgTick = Main.game.ticks;
			die();
		}
	}
	
}
