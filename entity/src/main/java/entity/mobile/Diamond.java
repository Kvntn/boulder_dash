package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;
import entity.strategy.BoulderStrategy;
import entity.strategy.DiamondStrategy;

public class Diamond extends MobileEntity{

	private Permeability permeability = Permeability.MINEABLE;
	private static final char charImage ='D';
	private boolean fallSpeed;
	private static DiamondStrategy dStrat;
	private static String imageName = "C:\\Users\\Kventin\\git\\boulder_dash\\entity\\Sprites\\world 1\\diamond.png";
    
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, imageName);	
	
	public Diamond(int x, int y, Map map, Permeability perm) throws IOException {
		super(x, y, sprite, map, perm);
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
	protected void die() {
		//can't die
	}
	@Override
	public void stay() {
		super.stay();
	}
	public void followMyStrategy() {
		Diamond.dStrat.followStrategy(this,this.getMap());
	}
}
