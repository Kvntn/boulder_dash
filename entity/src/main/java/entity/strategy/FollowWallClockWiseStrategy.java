package entity.strategy;

import entity.ControllerOrder;
import entity.Map;
import entity.mobile.MobileEntity;

public class FollowWallClockWiseStrategy extends EnnemyStrategy {
	
	public void followStrategy(MobileEntity currentPawn, Map map) {
		super.followStrategy(currentPawn, map);
		if(currentPawn.getPosition().y < 0)
		{
			return;
		}
		// first check until a wall is touched
		if (currentPawn.getLastWallTouched() == ControllerOrder.NONE) {

			if (currentPawn.canMove(ControllerOrder.LEFT)) {

				currentPawn.moveLeft();
				if (!currentPawn.canMove(ControllerOrder.LEFT)) {
					currentPawn.setLastWallTouched(ControllerOrder.LEFT);
				}

			} else if (currentPawn.canMove(ControllerOrder.DOWN)) {

				currentPawn.moveDown();
				if (!currentPawn.canMove(ControllerOrder.DOWN)) {
					currentPawn.setLastWallTouched(ControllerOrder.DOWN);
				}

			} else if (currentPawn.canMove(ControllerOrder.RIGHT)) {

				currentPawn.moveRight();
				if (!currentPawn.canMove(ControllerOrder.RIGHT)) {
					currentPawn.setLastWallTouched(ControllerOrder.RIGHT);
				}

			} else if (currentPawn.canMove(ControllerOrder.UP)) {

				currentPawn.moveUp();
				if (!currentPawn.canMove(ControllerOrder.UP)) {
					currentPawn.setLastWallTouched(ControllerOrder.UP);
				}
			}
		}

		// a wall has been touched, follow it
		if (currentPawn.getLastWallTouched() == ControllerOrder.LEFT) {
			if (currentPawn.canMove(ControllerOrder.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMove(ControllerOrder.DOWN)) {
					currentPawn.setLastWallTouched(ControllerOrder.DOWN);
				}
			} else if (currentPawn.canMove(ControllerOrder.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMove(ControllerOrder.RIGHT)) {
					currentPawn.setLastWallTouched(ControllerOrder.RIGHT);
				}
			} else if (currentPawn.canMove(ControllerOrder.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMove(ControllerOrder.UP)) {
					currentPawn.setLastWallTouched(ControllerOrder.UP);
				}
			}
		} else if (currentPawn.getLastWallTouched() == ControllerOrder.DOWN) {
			if (currentPawn.canMove(ControllerOrder.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMove(ControllerOrder.RIGHT)) {
					currentPawn.setLastWallTouched(ControllerOrder.RIGHT);
				}
			} else if (currentPawn.canMove(ControllerOrder.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMove(ControllerOrder.UP)) {
					currentPawn.setLastWallTouched(ControllerOrder.UP);
				}
			} else if (currentPawn.canMove(ControllerOrder.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMove(ControllerOrder.LEFT)) {
					currentPawn.setLastWallTouched(ControllerOrder.LEFT);
				}
			}

		} else if (currentPawn.getLastWallTouched() == ControllerOrder.RIGHT) {
			if (currentPawn.canMove(ControllerOrder.UP)) {
				currentPawn.moveUp();
				if (!currentPawn.canMove(ControllerOrder.UP)) {
					currentPawn.setLastWallTouched(ControllerOrder.UP);
				}
			} else if (currentPawn.canMove(ControllerOrder.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMove(ControllerOrder.LEFT)) {
					currentPawn.setLastWallTouched(ControllerOrder.LEFT);
				}
			} else if (currentPawn.canMove(ControllerOrder.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMove(ControllerOrder.DOWN)) {
					currentPawn.setLastWallTouched(ControllerOrder.DOWN);
				}
			}

		} else if (currentPawn.getLastWallTouched() == ControllerOrder.UP) {
			if (currentPawn.canMove(ControllerOrder.LEFT)) {
				currentPawn.moveLeft();
				if (!currentPawn.canMove(ControllerOrder.LEFT)) {
					currentPawn.setLastWallTouched(ControllerOrder.LEFT);
				}
			} else if (currentPawn.canMove(ControllerOrder.DOWN)) {
				currentPawn.moveDown();
				if (!currentPawn.canMove(ControllerOrder.DOWN)) {
					currentPawn.setLastWallTouched(ControllerOrder.DOWN);
				}
			} else if (currentPawn.canMove(ControllerOrder.RIGHT)) {
				currentPawn.moveRight();
				if (!currentPawn.canMove(ControllerOrder.RIGHT)) {
					currentPawn.setLastWallTouched(ControllerOrder.RIGHT);
				}
			}

		}

}
}
