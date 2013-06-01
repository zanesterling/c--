public class Bullet extends Thing{

	static final int DAMAGE = 5; //dummy value

	public Bullet(double x, double y){ super(x,y); }

	public void thingEffect(Actor a){ a.health -= DAMAGE; }
}
