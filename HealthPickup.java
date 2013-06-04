public class HealthPickup extends Thing{

	public static final int HEALTH = 20;
		
	public HealthPickup(double x, double y) {
		super(x,y);
	}

	public void thingEffect(Actor a){ a.health += HEALTH; }
}
