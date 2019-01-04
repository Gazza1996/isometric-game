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
import ie.gmit.sw.ground.GroundBuilder;
import ie.gmit.sw.ground.GroundTile;
import ie.gmit.sw.ground.GroundType;
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

	public GameView() {

		setBackground(Color.WHITE);
		setDoubleBuffered(true); 

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

	private void offsetPositions(int i, int offset) {
		// TODO Auto-generated method stub
		pos.setX( ((DEFAULT_SIZE - TILE_WIDTH) / 2) - (TILE_WIDTH / 2) * i + offset);
		pos.setY((TILE_HEIGHT * i) / 2 - offset);
		
	}
	
	public void nextPosition() {
		// TODO Auto-generated method stub
		pos.setX(pos.getX() + TILE_WIDTH / 2);
		pos.setY(pos.getY() + TILE_HEIGHT / 2);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}