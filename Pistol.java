import java.awt.MouseInfo;
import java.awt.Point;

public class Pistol extends Weapon {

	boolean firedSinceClick;

	public Pistol(){
		super();
		rof = 1; //dummy values here
		ammo = 1;
		cooldown = 10;

		firedSinceClick = false;
	}

	public void attack() {
		if (!firedSinceClick) {
			super.attack();
			firedSinceClick = true;
		}
	}

	public void recover() {
		firedSinceClick = false;
		super.recover();
	}

	public void doAttack(){
		Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
		Player p = Main.game.player;
		double theta = Math.atan2(mouseLoc.y - Main.screen.height/2, mouseLoc.x - Main.screen.width/2);

		Main.game.addActor(new Bullet(theta));
	}
}
