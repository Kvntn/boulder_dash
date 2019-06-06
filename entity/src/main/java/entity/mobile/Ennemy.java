package entity.mobile;

import java.awt.Rectangle;
import java.io.IOException;

import entity.ControllerOrder;
import entity.Permeability;
import entity.Sprite;
import entity.strategy.EnnemyStrategy;
import entity.strategy.FollowWallAntiClockWiseStrategy;
import entity.strategy.FollowWallClockWiseStrategy;
import entity.strategy.NoStrategy;
import entity.strategy.RandomStrategy;
import entity.Map;

public class Ennemy extends MobileEntity{
	
	@SuppressWarnings("unused")
	private static Permeability permeability = Permeability.PENETRABLE;
	private static final char charImage ='E';
    private ControllerOrder lastWallTouched = ControllerOrder.NONE;
    
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, Sprite.mapSheet, new Rectangle(144, 16, 16, 16));	
    
    /**Ennemy's strategy*/
    private EnnemyStrategy eStrat;
    private static RandomStrategy rStrat;
    private static FollowWallAntiClockWiseStrategy fAntiClockStrat;
    private static FollowWallClockWiseStrategy fCloackStrat;
    private static NoStrategy noStrat;
	
	public Ennemy(int x, int y, Map map ) throws IOException {
		super(x, y, sprite,  map, Permeability.BLOCKING);
		sprite.loadImage();
		switch((int)(Math.random()*(3))){
		case 1:
			this.eStrat=Ennemy.rStrat;
			break;
		case 2:
			this.eStrat=Ennemy.fAntiClockStrat;
			break;
			default:
				this.eStrat = Ennemy.fCloackStrat;
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
	public void die() {
		super.die();
	}
	@Override
	public void stay() {
		super.stay();
	}
	public void followMyStrategy() {
		this.eStrat.followStrategy(this,this.getMap());
	}
	public ControllerOrder getLastWallTouched() {
		return this.lastWallTouched;
	}
	public void setLastWallTouched(ControllerOrder controllerOrder) {
		this.lastWallTouched=controllerOrder;
	}
	public void removeStrategy() {
		this.eStrat = Ennemy.noStrat;
	}
	
	
	
}
