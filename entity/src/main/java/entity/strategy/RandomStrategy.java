package entity.strategy;

import entity.ControllerOrder;
import entity.Map;
import entity.mobile.MobileEntity;

public class RandomStrategy extends EnnemyStrategy {

	@Override
	public void followStrategy(MobileEntity currentItem, Map map) {
		super.followStrategy(currentItem, map);
		if (currentItem.getPosition().y < 0) {
			return;
		}

		ControllerOrder orderToFollow = ControllerOrder.RIGHT;
		int tries = 0;
		while (!currentItem.canMove(orderToFollow) && tries < 4) {
			orderToFollow = randomOrder();
			tries++;
		}
		
		if(tries == 4)
			return;
		
		this.moveToOrder(orderToFollow, currentItem);
	}

	private ControllerOrder randomOrder() {
		
		switch((int)Math.random()) {
		case 0:
			return ControllerOrder.UP;
		case 1 :
			return ControllerOrder.DOWN;
		case 2:
			return ControllerOrder.LEFT;
		case 3:
			return ControllerOrder.RIGHT;
		default:
			randomOrder();
			
		return ControllerOrder.NONE;
			
		}
	}
	
	private void moveToOrder(final ControllerOrder orderToFollow, final MobileEntity currentItem) {
		if (currentItem.canMove(orderToFollow)) {
			switch (orderToFollow) {
			case UP:
				currentItem.moveUp();
				break;
			case DOWN:
				currentItem.moveDown();
				break;
			case LEFT:
				currentItem.moveLeft();
				break;
			case RIGHT:
				currentItem.moveRight();
				break;
			default:
				currentItem.stay();
				break;
			}
		}
	}
}