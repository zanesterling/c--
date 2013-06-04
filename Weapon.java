public abstract class Weapon{

	 int cooldown, // is decremented per tick; if = 0, player can attack. 
		rof,      // the integer val cooldown is set to once a player attacks
		ammo;     // amount of remaining ammunition
		
	public void attack(){	// attack fxn, to be called by player
		if(cooldown == 0) {
			cooldown = rof; 
			doAttack();
		}   	
	}

	public void recover() { //to be called when mouse not down
		if (cooldown > 0)
			cooldown--;
	}

	abstract void doAttack(); //specific to actual weapon (e.g. handgun, axe)- defines attack mechanic

}
