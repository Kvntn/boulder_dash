package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class BreakableWall extends MotionlessEntity {

	private static char charImage = 'W';
	private static Sprite sprite = new Sprite(charImage, null);	
	
	protected BreakableWall() {
		super(sprite, Permeability.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
