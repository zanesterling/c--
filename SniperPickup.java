public class SniperPickup extends Thing{

	public SniperPickup(double x, double y){
		super(x,y);
	}	

	public void thingEffect(Actor act){
		if(act instanceof Player){
			if(((Player)act).weapon instanceof SniperRifle) 
				((Player)act).weapon.ammo += 15;
			else ((Player)act).weapon = new SniperRifle();
			Main.screen.message = "Sniper +15";
			Main.screen.lastMsgTick = Main.game.ticks;
			die();
		}
	}
}