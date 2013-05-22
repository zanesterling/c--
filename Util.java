import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Util {

	public static BufferedImage loadImg(String imgPath) {
		try {
			return ImageIO.read(new File(imgPath));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
}
