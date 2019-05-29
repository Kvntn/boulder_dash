package entity.mobile;

import java.awt.Point;
import entity.Permeability;

public class TheCharacter extends MobileEntity {
	
	private Permeability permeability = Permeability.BLOCKING;
	private int ownedDiamond;	
	//il n'y a pas le SpriteStay
	
	public TheCharacter() {
		
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHasMoved() {
		// TODO Auto-generated method stub
		
	}
	
}
