package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class UnbreakableWall extends MotionlessEntity {
	
	private static char charImage = 'X';
	private static Sprite sprite = new Sprite(charImage, "C:\\Users\\Kventin\\git\\boulder_dash\\entity\\Sprites\\world 1\\wall.png");
	
	protected UnbreakableWall() {
		super(sprite, Permeability.PENETRABLE);
	}

}
