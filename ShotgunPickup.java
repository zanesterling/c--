public class ShotgunPickup extends Thing{

	public ShotgunPickup(double x, double y){
		super(x,y);
	}	

	public void thingEffect(Actor act){
		if(act instanceof Player){
			((Player)act).weapon = new Shotgun();
			Main.screen.message = "+Shotgun";
			Main.screen.lastMsgTick = Main.game.ticks;
		}
	}
}