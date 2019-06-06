package entity.motionless;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

public class Exit extends MotionlessEntity {

	private static char charImage = 'S';
	private static Sprite sprite = new Sprite(charImage, Sprite.mapSheet, new Rectangle(128, 0, 16 ,16));
	private boolean open = false;
	
	Exit() {
		super(sprite, Permeability.PENETRABLE);
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	
}
