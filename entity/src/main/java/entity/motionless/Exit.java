package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Exit extends MotionlessEntity {

	private static char charSprite = 'S';
	private static Sprite sprite = new Sprite(charSprite, "endPortal.png");
	
	Exit() {
		super(sprite, Permeability.PENETRABLE);
	}

}
