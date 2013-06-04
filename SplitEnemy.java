public class SplitEnemy extends BasicEnemy{

	static int splitCounter = 0;
	int cooldown; 

	public SplitEnemy(double x, double y){
		super(x,y);
		cooldown = 100;
		splitCounter++;
	}

	public void update(){
		super.update();
		if(cooldown <= 0 && splitCounter < 1500){
			double newX = (int)(Math.random() * 2.1 * this.radius);
			double newY = Math.sqrt(Math.pow(2.1 * this.radius, 2) - Math.pow(newX, 2));
			Main.game.actors.add(new SplitEnemy(this.x + newX, this.y + newY));
			cooldown = 100;
		}
		else cooldown--;
	}

	public void die(){
		super.die();
		splitCounter--;
	}

}