package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

import entity.mobile.MobileEntity;
import showboard2.showboard.ISquare;

public class Map extends Observable {

	private Entity[][] mapContent;
	private static final int WIDTH = 32, HEIGHT = 16;
	public static int diamondCount = 0;
	private int level;
	
	private MobileEntity theCharacter;
	
	private ArrayList<MobileEntity> mobileEntities = new ArrayList<MobileEntity>(); 
	
	public Map(int level, Entity[][] mapContent) {
		this.mapContent = mapContent;
		this.level = level;
		this.mobileEntities = new ArrayList<MobileEntity>();
	}
	
	/*public Map() {
		this.level = 1;
		this.mapContent = null;
	}*/
	
	public Entity[][] getMapContent() {
		return mapContent;
	}
	
	public ArrayList<MobileEntity> getMobileEntities() {
		return mobileEntities;
	}

	public void setMapContent(Entity[][] mapContent) {
		this.mapContent = mapContent;
	}
	
	public int getDiamondCount() {
		return diamondCount;
	}
	
	public void setDiamondCount(int diamondCount) {
		this.diamondCount = diamondCount;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
		//this.setMapContent(mapContent);
	}
	
	public static int getWidth() {
		return WIDTH;
	}
	
	public static int getHeight() {
		return HEIGHT;
	}
	
	public void setOnMapXY(Entity entity, int x, int y ) {
		this.mapContent[x][y] = entity;
	}
	
	public Entity getOnMapXY(int x, int y) {
		if(x >= 0 && x < Map.getWidth() && y >= 0 && y < Map.getHeight())
            return this.mapContent[x][y];
        else
            return this.mapContent[0][0];
	}
	
	public void add(MobileEntity mE) {
		mobileEntities.add(mE);
	}
	
//	public final String toString() {
//        try {
//           for (int y = 0; y <= 16; y++) {
//             for (int x = 0; x <= 32; x++) {
//               System.out.println(this.getOnMapXY(x, y).getSprite().getCharImage());
//             }
//           }
//        }catch (Exception e) {
//               e.printStackTrace();
//           }
//        return "fin";
//     }
	
	public void setHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void increaseDiamondCount() {
		diamondCount++;
	}
	
	public void decreaseDiamondCount() {
		diamondCount--;
	}
	
	public MobileEntity getTheCharacter() {
		return theCharacter;
	}

	public void setTheCharacter(MobileEntity tC) {
		this.theCharacter = tC;
	}
	
	public Permeability getPermOfEntityXY(int x, int y) {
		Point point = new Point(x,y);
		for (MobileEntity mEntities : this.getMobileEntities()) {
			if (mEntities.getPosition().equals(point)) {
				return mEntities.getPermeability();
			}
			
		}
		if (this.getTheCharacter().getPosition().equals(point))
		return this.getTheCharacter().getPermeability();
		
		return this.getOnMapXY(x, y).getPermeability();
	}
	public Observable getObservable() {
		return this;
	}
}
















