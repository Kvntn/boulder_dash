package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class BreakableWall extends MotionlessEntity {

	private static char charSprite = 'W';
	private static Sprite sprite = new Sprite(charSprite, null);	
	
	protected BreakableWall() {
		super(sprite, Permeability.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
