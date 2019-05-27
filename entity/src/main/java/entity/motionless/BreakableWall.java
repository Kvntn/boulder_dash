package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class BreakableWall extends MotionlessEntity {

	private char charSprite = 'W';
	private Sprite sprite = new Sprite(charSprite, null);	
	
	protected BreakableWall(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

}
