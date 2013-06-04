import java.awt.MouseInfo;
import java.awt.Point;

public class Shotgun extends Weapon {

	static final double SPREAD_ANGLE = 0.3;

	boolean firedSinceClick;
	boolean firedPastTick;

	public Shotgun(){
		super();
		rof = 5; //dummy values here
		ammo = 81;
		cooldown = 0;

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
		if (firedPastTick)
			for (int i=-2; i<2; i++)
				Main.game.addActor(new Bullet(theta - SPREAD_ANGLE * (i + 0.5)));
		else
			for (int i=-2; i<3; i++)
				Main.game.addActor(new Bullet(theta - SPREAD_ANGLE * i));
		firedPastTick = true;
		if(ammo == 0) 
			Main.game.player.weapon = new Pistol();
		else ammo -= 9;
	}
}
