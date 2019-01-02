package ie.gmit.sw;

import java.awt.image.BufferedImage;

public enum SpriteType {
	
	standard(null), 
	green(null), 
	knight(null), 
	person(null);
	
	private BufferedImage img;
	
    private SpriteType(BufferedImage img) {
    	this.img = img;
    }
    
    public void setImg(BufferedImage img) {
    	this.img = img;
    }

    public BufferedImage getImg() {
    	return img;
    }

}
