package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;
import entity.strategy.BoulderStrategy;

public class Boulder extends MobileEntity{

	private Permeability permeability = Permeability.BLOCKING;
	private static final char charImage ='B';
	private static BoulderStrategy bStrat;
	private static String imageName = "C:\\Users\\Kventin\\git\\boulder_dash\\entity\\Sprites\\world 1\\boulder.png";
	
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, imageName);
	
	public Boulder(int x, int y, Map map, Permeability perm) throws IOException {
		super(x, y, sprite, map, perm);
		sprite.loadImage();
	}
	
	public void moveLeft() {
		super.moveLeft();
	}
	
	public void moveRight() {
		super.moveRight();
	}
	
	public void moveUp() {
		//Cannot move up
	}
	
	@Override
	public void moveDown() {
		super.moveDown();
	}
	
	
	@Override
	public void stay() {
		super.stay();
	}
	
	//method to review on the fact [strategy]
	public void followMyStrategy() {
		Boulder.bStrat.followStrategy(this,this.getMap());
	}
	
	@Override
	protected boolean itemsAllowMovementTo(ControllerOrder direction) {
		Point desiredPosition=null;
		switch (direction) {
		case UP:
			desiredPosition=new Point(this.getX(),this.getY()-1);
			break;
		case DOWN:
			desiredPosition=new Point(this.getX(),this.getY()+1);
			break;
		case RIGHT:
			desiredPosition=new Point(this.getX()+1,this.getY());
			break;
		case LEFT:
			desiredPosition=new Point(this.getX()-1,this.getY());
			break;
		case NONE:
			default:
				return true;
		}
		if(this.getMap().getTheCharacter().getPosition().equals(desiredPosition)) {
			return false;
		}
		else {
			return super.itemsAllowMovementTo(direction);
		}
	}
}
