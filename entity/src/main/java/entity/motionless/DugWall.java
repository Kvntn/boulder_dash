package entity.motionless;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class DugWall extends MotionlessEntity {

	private static char charImage = 'O';
	private static final Sprite sprite =new Sprite(charImage, Sprite.mapSheet, new Rectangle(32, 0, 16, 16));
	
	protected DugWall() {
		super(sprite, Permeability.PENETRABLE);
	}

}
