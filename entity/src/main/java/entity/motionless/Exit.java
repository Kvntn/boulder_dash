package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Exit extends MotionlessEntity {

	private static char charImage = 'S';
	private static Sprite sprite = new Sprite(charImage, "C:\\Users\\Kventin\\git\\boulder_dash\\entity\\Sprites\\world 1\\endPortal.png");
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
