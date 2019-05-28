package entity.mobile;

import java.awt.Point;
import entity.Permeability;

public class TheCharacter extends MobileEntity {
	
	private Permeability permeability = Permeability.BLOCKING;
	private int ownedDiamond;
	private boolean fallSpeed;
	
	//il n'y a pas le SpriteStay
	
	public TheCharacter() {
		
	}
	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
		this.fallSpeed = true;
	}

	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}
	
	public void stay() {
		 this.setHasMoved();
	     this.fallSpeed = false;
	    
	}
	
	public void fall() {
		
	}
	
	@Override
	public int getX() {
		return this.getX();
	}
	
	@Override
	public void setX(int x) {
		this.setX(x);
		
	}
	@Override
	public int getY() {
		return this.getY();
	}
	
	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
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
