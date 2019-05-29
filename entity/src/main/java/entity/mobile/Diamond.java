package entity.mobile;

import java.awt.Point;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;

public class Diamond extends MobileEntity{

	private Permeability permeability = Permeability.MINEABLE;
	private static final char charImage ='D';
	private boolean fallSpeed;
    
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, "diamond.png");	
	
	public Diamond(int x, int y, Map map, Permeability perm) {
		super(x, y, sprite, map, perm);
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
	public boolean setHasMoved() {
		return true;
		// TODO Auto-generated method stub
		
	}
	@Override
	protected boolean canMoveTo(ControllerOrder down) {
		// TODO Auto-generated method stub
		return false;
	}
}
