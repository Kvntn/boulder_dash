package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;

public class Diamond extends MobileEntity{

	private Permeability permeability = Permeability.MINEABLE;
	private static final char charImage ='D';
	private boolean fallSpeed;
    
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, "diamond.png");	
	
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
		Diamond.strategy.followStrategy(this,this.getMap());
	}
}
