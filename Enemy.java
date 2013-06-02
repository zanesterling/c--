public abstract class Enemy extends Actor{

	double accel = 0.125;
	double damage; //lol that's funny

	public Enemy(double x, double y){
		super(x,y);
	}

	public void attackPlayer() {}
}
