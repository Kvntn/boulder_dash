package entity.motionless;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class BreakableWall extends MotionlessEntity {

	private static char charImage = 'W';
	private static Sprite sprite = new Sprite(charImage, Sprite.mapSheet, new Rectangle(16, 0, 16, 16));
	
	protected BreakableWall() {
		super(sprite, Permeability.MINEABLE);
	}

}
