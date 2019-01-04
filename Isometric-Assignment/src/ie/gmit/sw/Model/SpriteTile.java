package ie.gmit.sw.Model;

import java.awt.image.BufferedImage;

import ie.gmit.sw.SpriteType;
import ie.gmit.sw.Tile;

public class SpriteTile extends Tile{
	
	private boolean engaged;
	private SpriteType type;
	
	public SpriteTile() {
		super();
	}
	
	public SpriteTile(Position p, BufferedImage i, boolean e, int x, int y) {
		super(p, i, x, y);
		this.engaged = e;
	}
	
	public boolean isEngaged() {
		return engaged;
	}

	public void setEngaged(boolean engaged) {
		this.engaged = engaged;
	}

	public SpriteType getType() {
		return type;
	}

	public void setType(SpriteType type) {
		this.type = type;
	}

	
}