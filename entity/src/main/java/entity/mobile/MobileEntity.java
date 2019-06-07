package entity.mobile;
import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.Entity;
import entity.Map;
import entity.Permeability;
import entity.Sprite;
import entity.motionless.MotionlessEntityFactory;
import showboard2.showboard.IPawn;

public abstract class MobileEntity extends Entity implements IPawn{

	private Point position;
	public static boolean alive = true;
	private Map map;
	private boolean fallSpeed = false;
	
	public MobileEntity(Sprite sprite, Map map, Permeability permeability) {
		super(sprite, permeability);
		this.map=map;
		this.alive = true;
		this.position = new Point();
	}
	public MobileEntity(int x, int y, Sprite sprite, Map map, Permeability perm) {
        this(sprite, map, perm);
        this.setPosition(new Point(x, y));
    }
	public void moveUp() {
		this.setY(this.getY()-1);
		this.setHasMoved();
	}
	public void moveLeft() {
		this.setX(this.getX()-1);
		this.setHasMoved();
	}
	public void moveDown() {
		this.setY(this.getY()+1);
		this.setHasMoved();
	}
	public void moveRight() {
		this.setX(this.getX()+1);
		this.setHasMoved();
	}
	public void stay() {
		this.setHasMoved();
		this.fallSpeed=false;
	}
	public void setHasMoved() {
		this.getMap().setHasChanged();
	}
	public int getX(){
		return this.getPosition().x;
	}
	public void setX(int x) {
		this.getPosition().x=x;
		/*if(this.isCrushed()) {
			this.die();
		}*/
	}
	public void digDirt() {
		
		this.getMap().setOnMapXY(MotionlessEntityFactory.createDugWall(), this.getX(),this.getY());
		try {
			
			this.getMap().getOnMapXY(getX(),getY()).getSprite().loadImage();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public int getY() {
		return this.getPosition().y;
	}
	public void setY(int y) {
		this.getPosition().y=y;
		/*if(this.isCrushed()) {
			this.die();
		}*/
	}
	public Map getMap() {
		return this.map;
	}
	public boolean isAlive() {
		return this.alive;
	}
	public void die() {
		this.alive = false;
		this.setHasMoved();
	}
	/*public boolean isCrushed() {
		for(MobileEntity item : this.getMap().getMobileEntities()) {
			if(item.getSprite().getCharImage()=='B'||item.getSprite().getCharImage()=='D') {
				if(item.getPosition().x==this.getPosition().x && item.getPosition().y==this.getPosition().y-1 && item.isFalling()) {
					return true;
				}
			}
		}
		return this.getMap().getOnMapXY(this.getX(), this.getY()).getPermeability()==Permeability.BLOCKING;
	}*/
	
	
	public boolean canMove(ControllerOrder direction) {
		return this.mapAllowsMovementTo(direction) && this.itemsAllowMovementTo(direction);
	}
	
	
	protected boolean mapAllowsMovementTo(ControllerOrder direction) {
		switch(direction) {
		case UP:
			System.out.println(this.getMap().getOnMapXY(this.getX(), this.getY()-1).getPermeability());
			return this.getMap().getOnMapXY(this.getX(), this.getY()-1).getPermeability()==Permeability.PENETRABLE;
			
		case DOWN:
			return this.getMap().getOnMapXY(this.getX(), this.getY()+1).getPermeability()==Permeability.PENETRABLE;
		case RIGHT:
			return this.getMap().getOnMapXY(this.getX()+1, this.getY()).getPermeability()==Permeability.PENETRABLE;
		case LEFT:
			return this.getMap().getOnMapXY(this.getX()-1, this.getY()).getPermeability()==Permeability.PENETRABLE;
		case NONE :
			default:
				return true;
		}
	}
	protected boolean itemsAllowMovementTo(ControllerOrder direction) {
		Point desiredPosition = this.getPositionFromControllerOrder(direction);
		for(MobileEntity item : this.getMap().getMobileEntities()) {
			if(item.getPosition().equals(desiredPosition)) {
				if(item.getPermeability() !=Permeability.PENETRABLE) {
					return false;
				}else {
					return true;
				}
			}
		}
		return true;
	} 
	protected Point getPositionFromControllerOrder(ControllerOrder direction) {
		Point desiredPosition=null;
		switch(direction) {
		case UP:
			desiredPosition = new Point(this.getX(),this.getY()-1);
			break;
		case DOWN:
			desiredPosition = new Point(this.getX(),this.getY()+1);
			break;
		case RIGHT:
			desiredPosition = new Point(this.getX()+1,this.getY());
			break;
		case LEFT:
			desiredPosition = new Point(this.getX()-1,this.getY());
			break;
		default:
			break;
		
		
		}
		return desiredPosition;
	}

	public boolean isFalling() {
		return fallSpeed;
	}
	
	public void setFallSpeed(boolean fallSpeed) {
		this.fallSpeed = fallSpeed;
	}
	
	public ControllerOrder getLastWallTouched() {
		return ControllerOrder.NONE;
	}
	
	public void setLastWallTouched(ControllerOrder controllerOrder) {
		
	}
	public Point getPosition() {
		return this.position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
	public void removeFromBoard(Entity en) {
		this.setPosition(new Point(1,-1));
		this.getMap().getMobileEntities().remove(this);
	}
	public void strat(int x, int y) {
		
	}

}
