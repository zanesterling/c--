public abstract class Thing {

	double x,y;
	double radius;

	public void collide(Actor act) {
    if(Math.sqrt(Math.pow(x - act.x, 2) + Math.pow(y - act.y, 2)) < radius ) //compares this thing's radius to distance between itself and act
		thingEffect(act);
	}
	
	abstract void thingEffect(Actor act);	//effect of Thing's subclasses 
}
