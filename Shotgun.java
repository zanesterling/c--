import java.awt.MouseInfo;
import java.awt.Point;

public class Shotgun extends Weapon {

	boolean firedSinceClick;
	boolean firedPastTick;

	public Shotgun(){
		super();
		rof = 5; //dummy values here
		ammo = 1;
		cooldown = 10;

		firedSinceClick = false;
		firedPastTick = false;
	}

	public void attack() {
		if (!firedSinceClick) {
			super.attack();
			firedSinceClick = true;
		}
		else if(firedPastTick){
			doAttack();
			firedPastTick = false;
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
		Main.game.addActor(new Bullet(theta - 0.1));
		Main.game.addActor(new Bullet(theta - 0.05));
		Main.game.addActor(new Bullet(theta));
		Main.game.addActor(new Bullet(theta + 0.05));
		Main.game.addActor(new Bullet(theta + 0.1));
		firedPastTick = true;
	}
}
