public class Pistol extends Weapon{

	public Pistol(double x, double y){
		super(x, y);
		_RoF = 1; //dummy values here
		_ammo = 1;
		_cooldown = 1;
	}

	public void doAttack(){
		Main.game.actors.add(new Bullet
	}
}