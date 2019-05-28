package entity.mobile;
import java.awt.Point;
import entity.Map;
import entity.Sprite;

public abstract class MobileEntity {

	private Point position;
	private Map map;
	private boolean alive;
	private boolean fallSpeed;	
	
	public MobileEntity(Sprite sprite, Map map) {
		
	}
	
	public MobileEntity(int x, int y, Map map) {
		
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
	public abstract boolean isAlive();
	public abstract boolean canMove();
	public abstract Point getPosition();
	public abstract void setPosition(Point position);
	public abstract void setHasMoved();
	
}
