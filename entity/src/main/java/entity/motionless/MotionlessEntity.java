package entity.motionless;

import entity.Entity;
import entity.Permeability;
import entity.Sprite;

public abstract class MotionlessEntity extends Entity{

	protected MotionlessEntity(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
}
