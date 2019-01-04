package ie.gmit.sw.ground;

import java.awt.image.BufferedImage;

import ie.gmit.sw.Tile;
import ie.gmit.sw.Model.Position;

public class GroundTile extends Tile{
	
	private boolean isWalkable;
	private GroundType type;
	
	public GroundTile() {
		super();
	}
	
	public GroundTile(Position p, BufferedImage i, boolean w, GroundType type, int x, int y) {
		super(p, i, x, y);
		this.isWalkable = w;
		this.type = type;
	}

	public boolean isWalkable() {
		return isWalkable;
	}

	public void setWalkable(boolean isWalkable) {
		this.isWalkable = isWalkable;
	}

	public GroundType getType() {
		return type;
	}

	public void setType(GroundType type) {
		this.type = type;
	}
	
}
