package ie.gmit.sw;

import java.awt.image.BufferedImage;
import java.util.List;

public enum SpriteType {

	standard(false), 
	green(false), 
	knight(false), 
	person(false);

	private List<BufferedImage> img;
	private boolean isEngaged;

	SpriteType(Boolean e) {
		this.isEngaged = e;
	}

	private SpriteType(List<BufferedImage> img) {
		this.img = img;
	}

	public void setImg(List<BufferedImage> images) {
		this.img = images;
	}

	public List<BufferedImage> getImg() {
		return img;
	}

	public boolean isEngaged() {
		return isEngaged;
	}

	public void setEngaged(boolean isEngaged) {
		this.isEngaged = isEngaged;
	}

}