public class SplitEnemy extends BasicEnemy{

	int cooldown; 

	public SplitEnemy(double x, double y){
		super(x,y);
		cooldown = 100;
	}

	public void update() {
		super.update();

		if(cooldown == 0){
			double newX = (int)(Math.random() * 2 * this.radius);
			double newY = Math.sqrt(Math.pow(2 * this.radius, 2) - Math.pow(newX, 2));
			Main.game.addActor(new SplitEnemy(this.x + newX, this.y + newY));
			cooldown = 100;
		} else
			cooldown--;
	}

}
