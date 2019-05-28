package entity.mobile;
import java.awt.Point;
import entity.Map;
import entity.Sprite;

public abstract class MobileEntity {

	private Point position;
	private Map map;
	private boolean alive;	
	public MobileEntity(Sprite sprite, Map map) {
		
	}
	
	public MobileEntity(int x, int y, Map map) {
		
	}
	
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	public abstract void stay();
	public abstract int getX();
	public abstract void setX(int x);
	public abstract int getY();
	public abstract void setY(int y);
	public abstract boolean isAlive();
	public abstract boolean canMove();
	public abstract Point getPosition();
	public abstract void setPosition(Point position);
	public abstract void setHasMoved();
	
}
