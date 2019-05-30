package entity.mobile;

import java.awt.Point;
import java.io.IOException;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;

public class TheCharacter extends MobileEntity {

	private static Permeability permeability = Permeability.BLOCKING;
	private int ownedDiamond;	
	//il n'y a pas le SpriteStay
	private final static char charImage = 'A';

	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite(charImage, "characterStandstill.png");	
	/** The Constant spriteTurnLeft. */
	private static final Sprite sprite2 = new Sprite(charImage, "characterRunningLeft.png");	
	/** The Constant spriteTurnRight. */
	private static final Sprite sprite3 = new Sprite(charImage, "characterRunningRight.png");	
	/** The Constant spriteTurnUp. */
	private static final Sprite sprite4 = new Sprite(charImage, "characterRunningUp.png");		
	/** The Constant spriteTurnDown. */
	private static final Sprite sprite5 = new Sprite(charImage, "characterRunningDown.png");	
	/** The Constant spriteExplode. */
	private static final Sprite sprite6 = new Sprite(charImage, "characterDeath.png");
	
	
	public TheCharacter(int x, int y, Map map, Permeability perm) throws IOException {
		super(x, y,sprite, map, Permeability.BLOCKING);
		sprite.loadImage();
		sprite2.loadImage();
		sprite3.loadImage();
		sprite4.loadImage();
		sprite5.loadImage();
		sprite6.loadImage();
	}
	
	@Override
	public void moveUp() {
		super.digDirt();
		this.setSprite(sprite2);
		super.moveUp();
		
	}
	@Override
	public void moveDown() {
		super.digDirt();
		this.setSprite(sprite5);
		super.moveDown();
	}
	@Override
	public void moveLeft() {
		super.digDirt();
		this.setSprite(sprite2);
		super.moveLeft();
	}
	@Override
	public void moveRight() {
		super.digDirt();
		this.setSprite(sprite3);
		super.moveRight();
	}
	@Override
	public void stay() {
		this.setSprite(sprite);
		super.stay();
	}
	@Override
	protected void die() {
		this.setSprite(sprite6);
		super.die();
	}
	@Override
	protected boolean mapAllowsMovementTo(ControllerOrder direction) {
		switch(direction) {
		case UP:
			return this.getMap().getOnMapXY(this.getX(),this.getY()-1).getPermeability()!=Permeability.BLOCKING;
		case DOWN:
			return this.getMap().getOnMapXY(this.getX(),this.getY()+1).getPermeability()!=Permeability.BLOCKING;
		case RIGHT:
			return this.getMap().getOnMapXY(this.getX()+1,this.getY()).getPermeability()!=Permeability.BLOCKING;
		case LEFT:
			return this.getMap().getOnMapXY(this.getX()-1,this.getY()).getPermeability()!=Permeability.BLOCKING;
		case NONE:
			
			default:
				return true;
				
		}
	}
	
	@Override
	protected boolean itemsAllowMovementTo(ControllerOrder direction) {
		boolean pushingAvailable=false;
		switch(direction) {
		case RIGHT:
			pushingAvailable = this.getMap().getOnMapXY(getX() + 2, getY())
					.getPermeability() == Permeability.PENETRABLE;
			if (pushingAvailable) {
				for (MobileEntity pawn : this.getMap().getMobileEntities()) {
					if (pawn.getPosition().x == getX() + 2 && pawn.getPosition().y == getY()
							&& pawn.getPermeability() != Permeability.PENETRABLE) {
						pushingAvailable = false;
						break;
					}
				}
			}
			break;
		case LEFT:
			pushingAvailable = this.getMap().getOnMapXY(getX() - 2, getY())
					.getPermeability() == Permeability.PENETRABLE;
			if (pushingAvailable) {
				for (MobileEntity pawn : this.getMap().getMobileEntities()) {
					if (pawn.getPosition().x == getX() - 2 && pawn.getPosition().y == getY()
							&& pawn.getPermeability() != Permeability.PENETRABLE) {
						pushingAvailable = false;
						break;
					}
				}
			}
			break;
		case NONE:
		default:
			break;
		}
		
		Point desiredPosition=this.getPositionFromControllerOrder(direction);
		for (MobileEntity item : this.getMap().getMobileEntities()) {
			if (item.getPosition().equals(desiredPosition)) {
				if (item.getPermeability() == Permeability.BLOCKING) {
					if (pushingAvailable) {
						if (direction == ControllerOrder.RIGHT)
							item.moveRight();
						else
							item.moveLeft();
						return true;
					} else {

						return false;
					}

				} else if (item.getPermeability() == Permeability.MINEABLE) {
					// Player stepped on a diamond

					item.removeFromBoard();
					this.getMap().decreaseDiamondCount();

					return true;
				}
			}
		}
return true;
		
	}

	@Override
	public boolean canMove(ControllerOrder direction) {
		return this.mapAllowsMovementTo(direction)&&this.itemsAllowMovementTo(direction);
	}
	public void setMap(Map map) {
		this.getMap().setTheCharacter(this);
	}
	@Override
	public boolean isCrushed() {
		for(MobileEntity item : this.getMap().getMobileEntities()) {
			if(item.getSprite().getCharImage()=='E') {
				if(this.getPosition().equals(item.getPosition()))
					return true;
			}
		}
		return super.isCrushed();
	}
	public void followMyStrategy() {
		//not any strategy in here
	}
	
}