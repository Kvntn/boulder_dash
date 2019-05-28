package model.strategy;

import entity.Permeability;
import entity.*;

public abstract class FallingObjectStrategy {

	public void followStrategy(MobileEntity currentItem, Map map) {
		// if current pawn can go down
		if (currentItem.canMoveTo(UserOrder.DOWN)) {
			currentItem.moveDown();
		} else {

			// if not, check if he can fall on the sides
			for (Mobile pawnVerif : map.getPawns()) {

				// if there is a pawn under current pawn
				if (currentItem.getPosition().y == pawnVerif.getPosition().y - 1
						&& currentItem.getPosition().x == pawnVerif.getPosition().x) {

					// if the current pawn can go to left
					if (currentItem.canMoveTo(UserOrder.LEFT)) {

						// if the current pawn can go slide to the left to fall
						if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x - 1,
								pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentPawn.moveLeft();
							return;
						}
					}

					// if the current pawn can go to right
					if (currentItem.canMoveTo(UserOrder.RIGHT)) {

						// if the current pawn can go slide to the right to fall
						if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x + 1,
								pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
							currentItem.moveRight();
							return;
						}
					}
				}
			}
			currentItem.doNothing();
		}
	}
}
