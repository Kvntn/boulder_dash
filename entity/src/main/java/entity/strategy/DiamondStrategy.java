package entity.strategy;

import java.awt.Point;

import entity.Map;
import entity.mobile.MobileEntity;

public class DiamondStrategy extends FallingObjectStrategy{
	public void followStrategy(MobileEntity currentItem, Map map, int x, int y) {
		if((currentItem.getPosition().y==map.getTheCharacter().getPosition().y-1&&currentItem.getPosition().x==map.getTheCharacter().getPosition().x)||currentItem.getPosition().equals(map.getTheCharacter().getPosition())) {
			currentItem.setPosition(new Point(-1, -1));
			map.getMobileEntities().remove(currentItem);
			map.decreaseDiamondCount();
			return;
		}
		super.followStrategy(currentItem, map, x, y);
	}
}
