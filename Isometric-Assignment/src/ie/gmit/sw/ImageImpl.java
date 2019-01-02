package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageImpl implements ImageLoad {

	
	public Iterator<BufferedImage> loadImages(String directory) {

		File dir = new File(directory);
		File[] files = dir.listFiles();

		List<BufferedImage> images = new ArrayList<>();

		for (File f : files) {

			try {

				BufferedImage img = ImageIO.read(f);
				images.add(img);
				
			} catch (IOException e) {
				
				JOptionPane.showMessageDialog(null,"Error", null, JOptionPane.ERROR_MESSAGE);
				
			}

		}

		return images.iterator();

	}
	
}
