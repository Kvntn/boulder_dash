package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class DugWall extends MotionlessEntity {

	private static char charSprite = 'O';
	private static final Sprite sprite = new Sprite(charSprite, "ground0.png");	
	
	protected DugWall() {
		super(sprite, Permeability.PENETRABLE);
	}

}
