package entity;

import java.util.ArrayList;
import java.util.Observable;

import entity.mobile.MobileEntity;
import entity.mobile.TheCharacter;

public class Map extends Observable{

	private Entity[][] mapContent;
	private static final int WIDTH = 32, HEIGHT = 16;
	private static int diamondCount = 0;
	private int level;
	
	private ArrayList<MobileEntity> mobileEntities = new ArrayList<MobileEntity>(); 
	
	public Map(int level, Entity[][] mapContent) {
		this.mapContent = mapContent;
		this.level = level;
	}
	public Map() {
		this.level = 1;
		this.mapContent = null;
	}
	
	public Entity[][] getMapContent() {
		return mapContent;
	}
	
	public ArrayList<MobileEntity> getMobileEntities() {
		return mobileEntities;
	}

	public void setMapContent(Entity[][] mapContent) {
		this.mapContent = mapContent;
	}
	
	public static int getDiamondCount() {
		return diamondCount;
	}
	
	public static void setDiamondCount(int diamondCount) {
		Map.diamondCount = diamondCount;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
		this.setMapContent(mapContent);
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
		return mapContent[x][y];
	}
	
	public void add(MobileEntity mE) {
		mobileEntities.add(mE);
	}
	
	public final String toString() {
        try {
           for (int y = 0; y <= 16; y++) {
             for (int x = 0; x <= 32; x++) {
               System.out.println(this.getOnMapXY(x, y).getSprite().getCharImage());
             }
           }
        }catch (Exception e) {
               e.printStackTrace();
           }
        return "fin";
     }
	
	public void setHasChanged() {
		
	}
	
	public void increaseDiamondCount() {
		diamondCount++;
	}
	
	public void decreaseDiamondCount() {
		diamondCount--;
	}
	
	public TheCharacter getTheCharacter() {
		TheCharacter tC = null;
		for (int x = 0; x < mobileEntities.size(); x++) {

			if ((mobileEntities.get(x) instanceof TheCharacter) && (mobileEntities.get(x).getSprite().getCharImage() != tC.getSprite().getCharImage())){
				tC = (TheCharacter) mobileEntities.get(x);
				System.out.println(tC.getClass());
			}
		}
		return tC;
	}
	
	public void setTheCharacter(TheCharacter tCh) {
		
		for (int x = 0; x < mobileEntities.size(); x++) {
			
			if ((mobileEntities.get(x) instanceof TheCharacter) && (mobileEntities.get(x).getSprite().getCharImage() != tCh.getSprite().getCharImage())){
				mobileEntities.set(x, tCh);
			}
		}
	}
	
	public Permeability getPermOfEntityXY(int x, int y) {
		if (mapContent[x][y].getPermeability() != null) 
			return mapContent[x][y].getPermeability();
		else
			return null;
	}
}
















