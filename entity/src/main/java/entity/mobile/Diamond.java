package entity.mobile;

import java.awt.Rectangle;
import java.io.IOException;


import entity.Map;
import entity.Permeability;
import entity.Sprite;
import entity.strategy.DiamondStrategy;
import entity.strategy.FallingObjectStrategy;

public class Diamond extends MobileEntity{

	private static FallingObjectStrategy strategy=new DiamondStrategy(); 
	private static final char charImage ='D';
	@SuppressWarnings("unused")
	private static DiamondStrategy dStrat;
    
    /** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite(charImage, Sprite.mapSheet, new Rectangle(64, 16, 16, 16));
	
	public Diamond(int x, int y, Map map ) throws IOException {
		super(x, y, sprite, map, Permeability.MINEABLE);
		sprite.loadImage();
	}
	@Override
	public void moveLeft() {
		super.moveLeft();
	}
	@Override
	public void moveRight() {
		super.moveRight();
	}
	@Override
	public void moveUp() {
	//can't move UP
	}
	@Override
	public void moveDown() {
		super.moveDown();
	}
	@Override
	public void stay() {
		super.stay();
	}
	
	
	public void strat(int x, int y) {
		Diamond.strategy.followStrategy(this, this.getMap(), x, y);
	}
}
