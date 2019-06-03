package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class BreakableWall extends MotionlessEntity {

	private static char charImage = 'W';
	private static Sprite sprite = new Sprite(charImage, "C:\\Users\\Kventin\\git\\boulder_dash\\entity\\Sprites\\world 1\\gound1.png");	
	
	protected BreakableWall() {
		super(sprite, Permeability.MINEABLE);
		// TODO Auto-generated constructor stub
	}

}
