package ie.gmit.sw.ground;

import java.awt.image.BufferedImage;

public enum GroundType{
	
	grass (null, true),
	rocks (null, true), 
	weeds (null, true), 
	sand  (null, true), 
	water (null, false), 
	beach (null, false), 
	mud (null, true),
	gravel (null, true);
	
	private BufferedImage img;
	private final boolean isWalkable;
	
    private GroundType(BufferedImage img, boolean isWalkable) {
    	this.isWalkable = isWalkable;
    	this.img = img;
    }
    
    public void setImg(BufferedImage img) {
    	this.img = img;
    }

    public BufferedImage getImg() {
    	return img;
    }

	public boolean isWalkable() {
		return isWalkable;
	}
    
}