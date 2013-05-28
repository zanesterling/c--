import java.awt.image.BufferedImage;

public class Actor {

	//coordinates
	double x, y;
	double px, py;

	BufferedImage img;

	int width, height;

	public Actor(int x, int y, String imgpath) {
		this.x = x;
		this.y = y;

		img = Util.loadImg(imgpath);
	}

	public void update() {
		relativityUpdate();
	}

	public void relativityUpdate() {
		//Do the CBass things
	}

	
}
