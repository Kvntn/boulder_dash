package entity.mobile;

import java.awt.Point;

import entity.ControllerOrder;
import entity.Permeability;
import entity.Sprite;

public class TheCharacter extends MobileEntity {
    
    private Permeability permeability = Permeability.BLOCKING;
    private int ownedDiamond; 
    
    private final static char charSprite = 'C';
    
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charSprite, "charcterStandstill.png");	
    /** The Constant spriteTurnLeft. */
    private static final Sprite sprite2 = new Sprite(charSprite, "chracterRunningUp.png");	
    /** The Constant spriteTurnRight. */
    private static final Sprite sprite3 = new Sprite(charSprite, "characterRunningRight.png");	
    /** The Constant spriteTurnUp. */
    private static final Sprite sprite4 = new Sprite(charSprite, "characterRunningUp.png");		
    /** The Constant spriteTurnDown. */
    private static final Sprite sprite5 = new Sprite(charSprite, "characterRunningDown.png");	
    /** The Constant spriteExplode. */
    private static final Sprite sprite6 = new Sprite(charSprite, "characterDeath.png");
    
    public TheCharacter() {
        
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
    }

    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }
    
    public void stay() {
         this.setHasMoved();
        
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
        return true;
    }
    
    @Override
    public boolean canMove() {
        // TODO Auto-generated method stub
        return true;
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
    public void setHasMoved() {
        // TODO Auto-generated method stub
        
    }

	@Override
	protected boolean canMoveTo(ControllerOrder order) {
		// TODO Auto-generated method stub
		return false;
	}
}