public class Bitmap {

	int width;
	int height;
	int[] pixels;

	public Bitmap(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
	}

	public void draw(Bitmap bitmap, int xmod, int ymod) {
		for (int i=0; i<bitmap.height; i++) {
			for (int j=0; j<bitmap.width; j++) {
				pixels[(i+ymod)*width + (j+xmod)] = bitmap.pixels[i*bitmap.width + j];
			}
		}
	}
}
