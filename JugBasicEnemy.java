import java.util.ArrayList;

//More powerful BasicEnemy
public class JugBasicEnemy extends BasicEnemy {

	double accel;

	public JugBasicEnemy(double x, double y) {
		super(x,y);
		accel = 0.4;
		radius = 10;
		damage = 2;
		health = 4;
	}

}
