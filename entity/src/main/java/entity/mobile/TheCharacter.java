package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;

public class TheCharacter extends MobileEntity {

	private static Permeability permeability = Permeability.BLOCKING;
	private int ownedDiamond;	
	//il n'y a pas le SpriteStay
	private final static char charImage = 'C';

	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite(charImage, "charcterStandstill.png");	
	/** The Constant spriteTurnLeft. */
	private static final Sprite sprite2 = new Sprite(charImage, "chracterRunningUp.png");	
	/** The Constant spriteTurnRight. */
	private static final Sprite sprite3 = new Sprite(charImage, "characterRunningRight.png");	
	/** The Constant spriteTurnUp. */
	private static final Sprite sprite4 = new Sprite(charImage, "characterRunningUp.png");		
	/** The Constant spriteTurnDown. */
	private static final Sprite sprite5 = new Sprite(charImage, "characterRunningDown.png");	
	/** The Constant spriteExplode. */
	private static final Sprite sprite6 = new Sprite(charImage, "characterDeath.png");
	
	
	public TheCharacter(int x, int y, Map map, Permeability perm) throws IOException {
		super(x, y,sprite, map, Permeability.BLOCKING);
		sprite.loadImage();
		sprite2.loadImage();
		sprite3.loadImage();
		sprite4.loadImage();
		sprite5.loadImage();
		sprite6.loadImage();
	}
	
	@Override
	public void moveUp() {
		this.setSprite(sprite2);
		super.moveUp();
		
	}
	@Override
	public void moveDown() {
		this.setSprite(sprite5);
		super.moveDown();
	}
	@Override
	public void moveLeft() {
		this.setSprite(sprite2);
		super.moveLeft();
	}
	@Override
	public void moveRight() {
		this.setSprite(sprite3);
		super.moveRight();
	}
	@Override
	public void stay() {
		this.setSprite(sprite);
		super.stay();
	}
	
	@Override
	public boolean isAlive() {
		return false;
	}
	@Override
	public void die() {
		this.setSprite(sprite6);
		super.die();
	}
	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean setHasMoved() {
		return false;
		// TODO Auto-generated method stub

	}
	@Override
	protected boolean canMoveTo(ControllerOrder order) {
		// TODO Auto-generated method stub
		return false;
	}

}