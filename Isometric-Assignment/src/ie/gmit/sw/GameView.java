package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;
//import javax.swing.text.Position;
import javax.imageio.*;
import java.io.*;
import java.util.*;

import ie.gmit.sw.Model.*;
import ie.gmit.sw.Tile;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 777L;

	private static final int DEFAULT_IMAGE_INDEX = 0; // change

	// Encapsulate the things that vary...
	public static final int DEFAULT_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;
	
	private Position pos = new Position(DEFAULT_SIZE / 2, 0);
	
	private ArrayList<GroundTile> groundList = new ArrayList<>();

	//private Sprite player; // change

	// Do we really need two models like this?
	/*
	 * private int[][] matrix; private int[][] things;
	 * 
	 * private BufferedImage[] tiles; //Note that all images, including sprites,
	 * have dimensions of 128 x 64. This make painting much simpler. private
	 * BufferedImage[] objects; //Taller sprites can be created, by using two tiles
	 * (head torso, lower body and legs) and improve animations private Color[]
	 * cartesian = {Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE,
	 * Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK}; //This is a 2D
	 * representation
	 * 
	 * private Timer timer; //Controls the repaint interval. private boolean
	 * isIsometric = true; //Toggle between 2D and Isometric (Z key)
	 * 
	 * public GameView(int[][] matrix, int[][] things) throws Exception { init();
	 * this.matrix = matrix; this.things = things;
	 */ // change this

	public GameView() {

		setBackground(Color.WHITE);
		setDoubleBuffered(true); // Each image is buffered twice to avoid tearing / stutter

			for (int i = 0; i < 10; i++) {
				
				offsetPositions(i, 0);
				
				for (int j = 0; j < 10; j++) {
					
					GroundBuilder tBuilder = new GroundBuilder();
					tBuilder.setType(GroundType.grass);
					tBuilder.setPos(new Position(pos.getX(), pos.getY()));
					GroundTile tile = tBuilder.build();
					
					groundList.add(tile);

					nextPosition();
					
				}
				
			}
			
		Timer timer = new Timer(100, this); // calls the actionPerformed() method every 100ms
		timer.start(); // Start the timer
	}

	private void offsetPositions(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	public void nextPosition() {
		
	}



	// This method breaks the SRP
	private BufferedImage[] loadImages(String directory, BufferedImage[] img) throws Exception {
		File dir = new File(directory);
		File[] files = dir.listFiles();
		Arrays.sort(files, (s, t) -> s.getName().compareTo(t.getName()));

		img = new BufferedImage[files.length];
		for (int i = 0; i < files.length; i++) {
			img[i] = ImageIO.read(files[i]);
		}
		return img;
	}

	/*public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}*/

	public void actionPerformed(ActionEvent e) { // This is called each time the timer reaches zero
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		paint(g2, groundList);
		
	}

	public void paint(Graphics2D g2, ArrayList<? extends Tile> list) {
		for (Tile tile : list) {
			g2.drawImage(tile.getImage(), tile.getPos().getX(), tile.getPos().getY(), null);
		}
	}


	public void keyPressed(KeyEvent e) {
	
	}

	public void keyReleased(KeyEvent e) {
	} // Ignore

	public void keyTyped(KeyEvent e) {
	} // Ignore
}