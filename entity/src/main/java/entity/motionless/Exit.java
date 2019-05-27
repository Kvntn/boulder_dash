package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Exit extends MotionlessEntity {

	private char charSprite = 'S';
	private Sprite sprite = new Sprite(charSprite, null);
	
	protected Exit(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

}
