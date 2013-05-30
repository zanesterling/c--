public abstract class Weapon extends Thing{

	private int _cooldown, // is decremented per tick; if = 0, player can attack. 
				_RoF,      // the integer val cooldown is set to once a player attacks
				_ammo;     // amount of remaining ammunition

	public void attack(){	// attack fxn, to be called by player
		if(_cooldown > 0)
			_cooldown--; 
		else { 
			_cooldown = _RoF; 
			attackType();
		}   	
	}

	abstract void attackType(); //specific to actual weapon (e.g. handgun, axe)- defines attack mechanic

}
