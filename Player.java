public class Player extends Actor{	

	double dVx, dVy;

	public Player(double x, double y){
		super(x, y);
    	health = 100; //dummy val
		//set weapon
	}

	//performs player motion update given set of pressed keys
	public void keyMove(boolean[] keys) {
		dVx = dVy = 0;

		if (keys[0])
			dVy -= 1;
		if (keys[2])
			dVy += 1;

		if (keys[1])
			dVx -= 1;
		if (keys[3])
			dVx += 1;
	}

	//overrides Actor.update()
	public void update() {
		keyMove(Main.game.keysPressed);
		super.update();
		System.out.println(vx + " " + vy);
	}
}
