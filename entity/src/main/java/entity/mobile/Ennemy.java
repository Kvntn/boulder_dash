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
    
    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite(charImage, null);	
	
	public Ennemy(int x, int y, Map map, Permeability perm) throws IOException {
		super(x, y, sprite,  map, perm);
		sprite.loadImage();
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
