package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Spawnpoint extends MotionlessEntity {

	private char charSprite = 'A';
	private Sprite sprite = new Sprite();
	
	protected Spawnpoint(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

}
