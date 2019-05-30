package entity.strategy;

import entity.ControllerOrder;
import entity.Map;
import entity.mobile.MobileEntity;

public class FollowWallAntiClockWiseStrategy extends EnnemyStrategy {

	public void followStrategy(MobileEntity currentItem, Map map) {
		super.followStrategy(currentItem, map);
		if(currentItem.getPosition().y < 0)
		{
			return;
		}
		
		if (currentItem.getLastWallTouched() == ControllerOrder.NONE) {

			if (currentItem.canMove(ControllerOrder.RIGHT)) {

				currentItem.moveRight();
				if (!currentItem.canMove(ControllerOrder.RIGHT)) {
					currentItem.setLastWallTouched(ControllerOrder.RIGHT);
				}

			} else if (currentItem.canMove(ControllerOrder.UP)) {

				currentItem.moveUp();
				if (!currentItem.canMove(ControllerOrder.UP)) {
					currentItem.setLastWallTouched(ControllerOrder.UP);
				}

			} else if (currentItem.canMove(ControllerOrder.LEFT)) {

				currentItem.moveLeft();
				if (!currentItem.canMove(ControllerOrder.LEFT)) {
					currentItem.setLastWallTouched(ControllerOrder.LEFT);
				}

			} else if (currentItem.canMove(ControllerOrder.DOWN)) {

				currentItem.moveDown();
				if (!currentItem.canMove(ControllerOrder.DOWN)) {
					currentItem.setLastWallTouched(ControllerOrder.DOWN);
				}
			}
		}
		// a wall has been touched, follow it
		if (currentItem.getLastWallTouched() == ControllerOrder.RIGHT) {
			if (currentItem.canMove(ControllerOrder.UP)) {
				currentItem.moveUp();
				if (!currentItem.canMove(ControllerOrder.UP)) {
					currentItem.setLastWallTouched(ControllerOrder.UP);
				}
			} else if (currentItem.canMove(ControllerOrder.LEFT)) {
				currentItem.moveLeft();
				if (!currentItem.canMove(ControllerOrder.LEFT)) {
					currentItem.setLastWallTouched(ControllerOrder.LEFT);
				}
			} else if (currentItem.canMove(ControllerOrder.DOWN)) {
				currentItem.moveDown();
				if (!currentItem.canMove(ControllerOrder.DOWN)) {
					currentItem.setLastWallTouched(ControllerOrder.DOWN);
				}
			}
		} else if (currentItem.getLastWallTouched() == ControllerOrder.UP) {
			if (currentItem.canMove(ControllerOrder.LEFT)) {
				currentItem.moveLeft();
				if (!currentItem.canMove(ControllerOrder.LEFT)) {
					currentItem.setLastWallTouched(ControllerOrder.LEFT);
				}
			} else if (currentItem.canMove(ControllerOrder.DOWN)) {
				currentItem.moveDown();
				if (!currentItem.canMove(ControllerOrder.DOWN)) {
					currentItem.setLastWallTouched(ControllerOrder.DOWN);
				}
			} else if (currentItem.canMove(ControllerOrder.RIGHT)) {
				currentItem.moveRight();
				if (!currentItem.canMove(ControllerOrder.RIGHT)) {
					currentItem.setLastWallTouched(ControllerOrder.RIGHT);
				}
			}

		} else if (currentItem.getLastWallTouched() == ControllerOrder.LEFT) {
			if (currentItem.canMove(ControllerOrder.DOWN)) {
				currentItem.moveDown();
				if (!currentItem.canMove(ControllerOrder.DOWN)) {
					currentItem.setLastWallTouched(ControllerOrder.DOWN);
				}
			} else if (currentItem.canMove(ControllerOrder.RIGHT)) {
				currentItem.moveRight();
				if (!currentItem.canMove(ControllerOrder.RIGHT)) {
					currentItem.setLastWallTouched(ControllerOrder.RIGHT);
				}
			} else if (currentItem.canMove(ControllerOrder.UP)) {
				currentItem.moveUp();
				if (!currentItem.canMove(ControllerOrder.UP)) {
					currentItem.setLastWallTouched(ControllerOrder.UP);
				}
			}

		} else if (currentItem.getLastWallTouched() == ControllerOrder.DOWN) {
			if (currentItem.canMove(ControllerOrder.RIGHT)) {
				currentItem.moveRight();
				if (!currentItem.canMove(ControllerOrder.RIGHT)) {
					currentItem.setLastWallTouched(ControllerOrder.RIGHT);
				}
			} else if (currentItem.canMove(ControllerOrder.UP)) {
				currentItem.moveUp();
				if (!currentItem.canMove(ControllerOrder.UP)) {
					currentItem.setLastWallTouched(ControllerOrder.UP);
				}
			} else if (currentItem.canMove(ControllerOrder.LEFT)) {
				currentItem.moveLeft();
				if (!currentItem.canMove(ControllerOrder.LEFT)) {
					currentItem.setLastWallTouched(ControllerOrder.LEFT);
				}
			}
		}
}
}
