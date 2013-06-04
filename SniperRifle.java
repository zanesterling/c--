import java.awt.MouseInfo;
import java.awt.Point;

public class SniperRifle extends Weapon {


	public SniperRifle(){
		super();
		rof = 20; //dummy values here
		ammo = 100;
		cooldown = 0;
	}

	public void attack() {
		if (Main.game.mouseDown) {
			super.attack();
		}
	}

	public void recover() {
		super.recover();
	}

	public void doAttack(){
		Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
		Player p = Main.game.player;
		double theta = Math.atan2(mouseLoc.y - Main.screen.height/2, mouseLoc.x - Main.screen.width/2);
		Main.game.addActor(new SniperBullet(theta));
		if(ammo == 0) 
			Main.game.player.weapon = new Pistol();
		else ammo--;
	}
}
