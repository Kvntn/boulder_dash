package entity.mobile;
import java.awt.Point;

import entity.ControllerOrder;
import entity.Entity;
import entity.Map;
import entity.Permeability;
import entity.Sprite;

public abstract class MobileEntity extends Entity{

	private Point position;
	private Map map;
	private boolean alive = false;
	private boolean fallSpeed;	
	private Permeability perm;
	
	public MobileEntity(Sprite sprite, Map map) {
		
		this.map = map;
	}
	
	public MobileEntity(int x, int y, Map map, Permeability perm) {
		this.getPosition().x = x;
		this.getPosition().y = y;
		this.map = map;
		this.perm = perm;
	}
	
	public void moveUp() {
		this.setY(this.getY()-1);
		this.setHasMoved();
	}
	
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
		this.fallSpeed=true;
	}
	
	public void moveLeft() {
		this.setX(this.getX()-1);
		this.setHasMoved();
	}
	
	public void moveRight() {
		this.setX(this.getX()+1);
		this.setHasMoved();
	}
	
	public void stay() {
		this.setHasMoved();
	}
	
	public void fall() {
		
	}
	
	public int getX() {
		return this.getX();
	}
	
	
	public void setX(int x) {
		this.setX(x);
	}
	
	public int getY() {
		return this.getY();
	}
	
	public void setY(int y) {
		this.setY(y);
	}

	public boolean isAlive() {
		return this.alive;
	}
	public abstract boolean canMove();

	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	protected abstract boolean canMoveTo(ControllerOrder order);
	public abstract boolean setHasMoved();
}
