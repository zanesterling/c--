public class MachinegunPickup extends Thing{

	public MachinegunPickup(double x, double y){
		super(x,y);
	}	

	public void thingEffect(Actor act){
		if(act instanceof Player){
			if(((Player)act).weapon instanceof MachineGun) 
				((Player)act).weapon.ammo += 100;
			else ((Player)act).weapon = new MachineGun();
			Main.screen.message = "Machinegun +100";
			Main.screen.lastMsgTick = Main.game.ticks;
			die();
		}
	}

}