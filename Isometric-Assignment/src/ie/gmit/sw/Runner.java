package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.util.EnumSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ie.gmit.sw.GameWindow;
import ie.gmit.sw.ground.GroundType;

public class Runner {
	
	public static void main(String[] args) throws Exception {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
                try {
                	
                	//Loads the tile images so they only need to be buffered once when the game starts
                	loadResources();
                	//Using the Game window as a Singleton
                	GameWindow.getInstance();
					
				} catch (Exception e) {
					//If the GUI fails to load
					JOptionPane.showMessageDialog(null, null, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}
	
	public static void loadResources() {
		
    	ImageLoad g = new ImageImpl();
		Iterator<BufferedImage> itr = g.loadImages("./resources/images/ground");
		EnumSet.allOf(GroundType.class).forEach(type -> (type).setImg(itr.next()));
		//Iterator<BufferedImage> itr2 = g.loadImages("./resources/images/objects");
		//EnumSet.allOf(ItemType.class).forEach(type -> (type).setImg(itr2.next()));
		
	}
}