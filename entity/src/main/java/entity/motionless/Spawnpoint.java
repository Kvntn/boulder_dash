package entity.motionless;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class Spawnpoint extends MotionlessEntity {

	private static char charImage = 'A';
	private static Sprite sprite = new Sprite(charImage, Sprite.mapSheet, new Rectangle(32, 0, 16 ,16));
	
	protected Spawnpoint() {
		super(sprite, Permeability.PENETRABLE);	}

}
