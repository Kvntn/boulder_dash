package entity.strategy;

import entity.Map;
import entity.mobile.MobileEntity;

public class BoulderStrategy extends FallingObjectStrategy{
	public void followStrategy(MobileEntity currentItem,Map map, int x, int y) {
		super.followStrategy(currentItem, map, x, y);
	}
}
