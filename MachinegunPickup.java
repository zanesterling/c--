public class MachinegunPickup extends Thing{

	public MachinegunPickup(double x, double y){
		super(x,y);
	}	

	public void thingEffect(Actor act){
		if(act instanceof Player){
			((Player)act).weapon = new MachineGun();
			Main.screen.message = "+Machinegun";
			Main.screen.lastMsgTick = Main.game.ticks;
		}
	}
	
}