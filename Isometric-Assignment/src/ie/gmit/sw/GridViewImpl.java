package ie.gmit.sw;

import java.util.ArrayList;

import ie.gmit.sw.GridView;

public class GridViewImpl implements GridView {
	
	private int height;
	private int width;
	private ArrayList<Tile>[][] gridTiles;
	
	
	@Override
	public void setGrid(ArrayList<Tile>[][] gridTiles) {
		this.gridTiles = gridTiles;
	}

	@Override
	public ArrayList<Tile>[][] getGrid() {
		return gridTiles;	
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;		
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void moveTileLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveTileRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveTileUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveTileDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emptyTile() {
		
	}

}
