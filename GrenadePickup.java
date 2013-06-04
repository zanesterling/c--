public class GrenadePickup extends Thing{

	public GrenadePickup(double x, double y){
		super(x,y);
	}	

	public void thingEffect(Actor act){
		if(act instanceof Player){
				((Player)act).grenades.ammo += 3;
			Main.screen.message = "Grenades +3";
			Main.screen.lastMsgTick = Main.game.ticks;
			die();
		}
	}

}