package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class DugWall extends MotionlessEntity {

	private static char charImage = 'O';
	private static final Sprite sprite = new Sprite(charImage, "C:\\Users\\Kventin\\git\\boulder_dash\\entity\\Sprites\\world 1\\ground0.png");	
	
	protected DugWall() {
		super(sprite, Permeability.PENETRABLE);
	}

}
