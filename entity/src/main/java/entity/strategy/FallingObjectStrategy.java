package entity.strategy;

import entity.Permeability;
import entity.mobile.MobileEntity;
import entity.*;

public abstract class FallingObjectStrategy {

	public void followStrategy(MobileEntity currentItem, Map map, int x, int y) {
		// if current pawn can go down
		if (currentItem.canMove(ControllerOrder.DOWN)) {
			currentItem.moveDown();
			currentItem.setFallSpeed(true);
		}else if (currentItem.isFalling() == true && currentItem.getY() == y-1 && currentItem.getX() == x)  {
			map.getTheCharacter().die();
		}
		
		else {

			// if not, check if he can fall on the sides
			for (MobileEntity itemVerif : map.getMobileEntities()) {

				// if there is a pawn under current pawn
				if (currentItem.getPosition().y == itemVerif.getPosition().y - 1
						&& currentItem.getPosition().x == itemVerif.getPosition().x) {

					// if the current pawn can go to left
					if (currentItem.canMove(ControllerOrder.LEFT)) {

						// if the current pawn can go slide to the left to fall
						if (map.getPermOfEntityXY(itemVerif.getPosition().x - 1,
								itemVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentItem.moveLeft();
							return;
						}
					}

					// if the current pawn can go to right
					if (currentItem.canMove(ControllerOrder.RIGHT)) {

						// if the current pawn can go slide to the right to fall
						if (map.getPermOfEntityXY(itemVerif.getPosition().x + 1,
								itemVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentItem.moveRight();
							return;
						}
					}
				}
			}
			currentItem.stay();
		}
	}
	
	protected void removeFromBoard(MobileEntity currentItem) {
		currentItem = null;
	}
}
