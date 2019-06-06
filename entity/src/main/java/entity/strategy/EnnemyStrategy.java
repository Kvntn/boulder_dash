package entity.strategy;

import entity.Map;
import entity.mobile.Ennemy;
import entity.mobile.MobileEntity;

public class EnnemyStrategy {
	public void followStrategy(MobileEntity currentItem,Map map) {
		/*if(currentItem.isCrushed()) {
			Ennemy ennemy =(Ennemy)(currentItem);
			ennemy.removeStrategy();
			removeFromBoard(ennemy);
		}*/
	}
	
	private void removeFromBoard(MobileEntity currentItem) {
		currentItem = null;
	}
}
