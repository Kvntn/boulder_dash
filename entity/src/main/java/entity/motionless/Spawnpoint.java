package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Spawnpoint extends MotionlessEntity {

	private static char charImage = 'A';
	private static Sprite sprite = new Sprite(charImage, null, null);
	
	protected Spawnpoint() {
		super(sprite, Permeability.PENETRABLE);	}

}
