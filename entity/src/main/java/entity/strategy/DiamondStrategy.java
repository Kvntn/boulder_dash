package entity.strategy;

import entity.Map;
import entity.mobile.MobileEntity;

public class DiamondStrategy extends FallingObjectStrategy{
	public void followStrategy(MobileEntity currentItem, Map map) {
		if((currentItem.getPosition().y==map.getTheCharacter().getPosition().y-1&&currentItem.getPosition().x==map.getTheCharacter().getPosition().x)||currentItem.getPosition().equals(map.getTheCharacter().getPosition())) {
			removeFromBoard(currentItem);
			map.decreaseDiamondCount();
			return;
		}
		super.followStrategy(currentItem, map);
	}
}
