public class ShotgunPickup extends Thing{

	public ShotgunPickup(double x, double y){
		super(x,y);
	}	

	public void thingEffect(Actor act){
		if(act instanceof Player){
			if(((Player)act).weapon instanceof Shotgun) 
				((Player)act).weapon.ammo += 81;
			else ((Player)act).weapon = new Shotgun();
			Main.screen.message = "Shotgun +81";
			Main.screen.lastMsgTick = Main.game.ticks;
			die();
		}
	}
}