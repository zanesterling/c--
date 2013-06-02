public class Player extends Actor{	

	double dVx, dVy;

	public Player(double x, double y){
		super(x, y);
    	health = 100; //dummy val
		dVx = dVy = 5;
		//set weapon
	}

	//performs player motion update given set of pressed keys
	public void keyMove(boolean[] keys) {
		x = 20;
		if (keys[0] && !keys[2])
			vy += 1;
		else if (keys[2] && !keys[1])
			vy -= 1;

		if (keys[1] && !keys[3])
			vx -= 1;
		else if (keys[3] && !keys[1])
			vx += 1;
	}

	//overrides Actor.update()
	public void update() {
		keyMove(Main.game.keysPressed);
		super.update();
	}
}
