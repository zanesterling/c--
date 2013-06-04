public class GrenadeAmmo extends Weapon{

	public GrenadeAmmo(){
		super();
		rof = 0; //dummy values here
		ammo = 5;
		cooldown = 0;
	}

	public void attack() {
		if (!firedSinceClick) {
			super.attack();
		}
	}

	public void doAttack(){
		Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
		Player p = Main.game.player;
		double theta = Math.atan2(mouseLoc.y - Main.screen.height/2, mouseLoc.x - Main.screen.width/2);
		Main.game.addActor(new Grenade(theta));
	}
}