import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Thing {

	double x,y;
	double radius;

	BufferedImage img;
	ArrayList<int[]> points;

	public Thing(double x, double y) {
		this.x = x;
		this.y = y;

		radius = 10;
	}     
	
	public void collide(Actor act) { 
		if(Math.pow(x - act.x, 2) + Math.pow(y - act.y, 2) < Math.pow(radius + act.radius,2)) //compares this thing's radius to distance between itself and act
			thingEffect(act);
	}
	
	abstract void thingEffect(Actor act);	//effect of Thing's subclasses 

	public void die() {
		for (int i=0; i<Main.game.things.size(); i++)
			if (this == Main.game.things.get(i))
				Main.game.thingDeathFlags.set(i,Boolean.TRUE);
	}
}



















