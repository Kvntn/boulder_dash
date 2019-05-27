package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class DugWall extends MotionlessEntity {

	private char charSprite = 'O';
	private Sprite sprite = new Sprite(charSprite, null);	
	
	protected DugWall(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

}
