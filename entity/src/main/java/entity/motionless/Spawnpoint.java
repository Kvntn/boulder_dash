package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Spawnpoint extends MotionlessEntity {

	private static char charSprite = 'A';
	private static Sprite sprite = new Sprite(charSprite, null);
	
	protected Spawnpoint() {
		super(sprite, Permeability.PENETRABLE);	}

}
