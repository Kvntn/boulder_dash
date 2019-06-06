package entity.mobile;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;

public class TheCharacter extends MobileEntity {

	private static Permeability permeability = Permeability.BLOCKING;
	private int ownedDiamond = 0;	
	private final static char charImage = 'A';
	
	private static final Sprite sprite = new Sprite(charImage, Sprite.spriteSheetCharacter, new Rectangle(0, 0, 16, 16));

	/** The Constant spriteTurnLeft. */
	private static final Sprite sprite2 = new Sprite(charImage, Sprite.spriteSheetCharacter, new Rectangle(0, 16, 16, 16));

	/** The Constant spriteTurnRight. */
	private static final Sprite sprite3 = new Sprite(charImage, Sprite.spriteSheetCharacter, new Rectangle(48, 32, 16, 16));

	/** The Constant spriteTurnUp. */
	private static final Sprite sprite4 = new Sprite(charImage, Sprite.spriteSheetCharacter, new Rectangle(32, 80, 16, 16));

	/** The Constant spriteTurnDown. */
	private static final Sprite sprite5 = new Sprite(charImage, Sprite.spriteSheetCharacter, new Rectangle(32, 64, 16, 16));

	/** The Constant spriteExplode. */
	private static final Sprite sprite6 = new Sprite(charImage, Sprite.spriteSheetCharacter, new Rectangle(64, 0, 16, 16));

	
	
	public TheCharacter(int x, int y, Map map) throws IOException {
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
		this.setSprite(sprite2);
		super.moveUp();
		super.digDirt();
		
	}
	@Override
	public void moveDown() {
		this.setSprite(sprite5);
		super.moveDown();
		super.digDirt();
	}
	@Override
	public void moveLeft() {
		this.setSprite(sprite2);
		super.moveLeft();
		super.digDirt();
	}
	@Override
	public void moveRight() {
		this.setSprite(sprite3);
		super.moveRight();
		super.digDirt();
	}
	@Override
	public void stay() {
		this.setSprite(sprite);
		super.stay();
	}
	@Override
	public void die() {
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
			pushingAvailable = this.getMap().getOnMapXY(getX() + 2, getY()).getPermeability() == Permeability.PENETRABLE;
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
					item.setPosition(new Point(-1, -1));
					this.getMap().getMobileEntities().remove(item);
					//removeFromBoard(item);
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
	
	
	/*@Override
	public boolean isCrushed() {
		for(MobileEntity item : this.getMap().getMobileEntities()) {
			if(item.getSprite().getCharImage()=='E') {
				if(this.getPosition().equals(item.getPosition()))
					return true;
			}
		}
		return super.isCrushed();
	}*/
}