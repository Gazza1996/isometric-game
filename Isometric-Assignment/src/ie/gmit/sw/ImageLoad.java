package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.util.Iterator;

public interface ImageLoad {
	public Iterator<BufferedImage> loadImages(String directory);
}
