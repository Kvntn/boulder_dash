package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class UnbreakableWall extends MotionlessEntity {
	
	private static char charSprite = 'X';
	private static Sprite sprite = new Sprite(charSprite, null);
	
	protected UnbreakableWall() {
		super(sprite, Permeability.PENETRABLE);
	}

}
