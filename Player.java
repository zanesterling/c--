public class Player extends Actor{	

	double dVx, dVy;
	double accelSpeed;

	public Player(double x, double y){
		super(x, y);
    	health = 100; //dummy val
		accelSpeed = 0.125;
		//set weapon
	}

	//performs player motion update given set of pressed keys
	public void keyMove(boolean[] keys) {
		dVx = dVy = 0;

		if (keys[0])
			dVy -= accelSpeed;
		if (keys[2])
			dVy += accelSpeed;

		if (keys[1])
			dVx -= accelSpeed;
		if (keys[3])
			dVx += accelSpeed;

		vx += dVx;
		vy += dVy;
	}

	//overrides Actor.update()
	public void update() {
		keyMove(Main.game.keysPressed);
		super.update();
	}
}
