package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.Permeability;
import entity.Sprite;
import entity.Map;

public class Ennemy extends MobileEntity{
	private Permeability permeability = Permeability.PENETRABLE;
	private static final char charImage ='E';
	private boolean fallSpeed;
    private ControllerOrder lastWallTouched = ControllerOrder.NONE;
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, null);	
	
	public Ennemy(int x, int y, Map map, Permeability perm) throws IOException {
		super(x, y, sprite,  map, perm);
		sprite.loadImage();
		switch((int)(Math.random()*(3))){
		case 1:
			this.myStrategy=Ennemy.randomStrategy;
			break;
		case 2:
			this.myStrategy=Ennemy.followWallAntiClockWiseStrategy;
			break
			default:
				this.myStrategy = Ennemy.followWallClockWiseStrategy;
				break;
		}
	}
	
	@Override
	public void moveLeft() {
		super.moveLeft();
	}
	@Override
	public void moveRight() {
		super.moveRight();
	}
	@Override
	public void moveUp() {
		super.moveUp();
	}
	@Override
	public void moveDown() {
		super.moveDown();
	}
	@Override
	protected void die() {
		super.die();
	}
	@Override
	public void stay() {
		super.stay();
	}
	public void followMyStrategy() {
		this.myStrategy.followStrategy(this,this.getMap());
	}
	public ControllerOrder getLastWallTouched() {
		return this.lastWallTouched;
	}
	public void setLastWallTouched(ControllerOrder controllerOrder) {
		this.lastWallTouched=controllerOrder;
	}
	public void removeStrategy() {
		this.myStrategy = Ennemy.noStrategy;
	}
	
	
	
}
