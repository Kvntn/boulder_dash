package entity.mobile;

import java.awt.Point;

import entity.ControllerOrder;
import entity.Permeability;
import entity.Sprite;

public class TheCharacter extends MobileEntity {

	private Permeability permeability = Permeability.BLOCKING;
	private int ownedDiamond;	
	//il n'y a pas le SpriteStay
	private final static char charSprite = 'C';

	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite(charSprite, "charcterStandstill.png");	
	/** The Constant spriteTurnLeft. */
	private static final Sprite sprite2 = new Sprite(charSprite, "chracterRunningUp.png");	
	/** The Constant spriteTurnRight. */
	private static final Sprite sprite3 = new Sprite(charSprite, "characterRunningRight.png");	
	/** The Constant spriteTurnUp. */
	private static final Sprite sprite4 = new Sprite(charSprite, "characterRunningUp.png");		
	/** The Constant spriteTurnDown. */
	private static final Sprite sprite5 = new Sprite(charSprite, "characterRunningDown.png");	
	/** The Constant spriteExplode. */
	private static final Sprite sprite6 = new Sprite(charSprite, "characterDeath.png");
	public TheCharacter() {

	}
	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setHasMoved() {
		// TODO Auto-generated method stub

	}
	@Override
	protected boolean canMoveTo(ControllerOrder order) {
		// TODO Auto-generated method stub
		return false;
	}

}