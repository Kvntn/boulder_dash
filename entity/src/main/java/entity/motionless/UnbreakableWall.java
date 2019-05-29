package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class UnbreakableWall extends MotionlessEntity {
	
	private static char charImage = 'X';
	private static Sprite sprite = new Sprite(charImage, null);
	
	protected UnbreakableWall() {
		super(sprite, Permeability.PENETRABLE);
	}

}
