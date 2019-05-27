package model;

public class Map {

	private String mapContent;
	private static final int WIDTH = 1536, HEIGHT = 768;
	private static int diamondCount = 0;
	private int level;
	
	public Map(int level, String mapContent) {
		this.mapContent = mapContent;
		this.level = level;
	}
	
	public String getMapContent() {
		return mapContent;
	}
	public void setMapContent(String mapContent) {
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
	
	
	
}
