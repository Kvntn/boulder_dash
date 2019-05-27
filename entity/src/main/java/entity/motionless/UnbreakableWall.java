package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class UnbreakableWall extends MotionlessEntity {
	
	private char charSprite = 'X';
	private Sprite sprite = new Sprite(charSprite, null);
	
	protected UnbreakableWall(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

}
