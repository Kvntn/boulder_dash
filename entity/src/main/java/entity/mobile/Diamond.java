package entity.mobile;

import java.awt.Point;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import entity.ControllerOrder;
import entity.Map;
import entity.Permeability;
import entity.Sprite;

public class Diamond extends MobileEntity{

	private Permeability permeability = Permeability.MINEABLE;
	private static final char charImage ='D';
	private boolean fallSpeed;
    
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, "diamond.png");	
	
	public Diamond(int x, int y, Map map, Permeability perm) {
		super(x, y, sprite, map, perm);
	}

	@Override
	public boolean canMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean canMoveTo(ControllerOrder order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setHasMoved() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
