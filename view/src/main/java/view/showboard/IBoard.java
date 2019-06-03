package view.showboard;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;

import entity.Entity;
import entity.mobile.MobileEntity;

/**
 * <h1>The Interface IBoard.</h1>
 *
 * @author Anne-Emilie DIET
 * @version 1.0
 * @see Dimension
 * @see Rectangle
 * @see ISquare
 * @see IPawn
 */
public interface IBoard {

    /**
     * Adds the square.
     *
     * @param entity the square
     * @param x the x
     * @param y the y
     */
    void addMotionlessItem(MotionlessEntity entity, int x, int y);

    /**
     * Adds the pawn.
     *
     * @param mobileEntity the pawn
     */
    void addItem(MobileEntity mobileEntity);

    /**
     * Gets the observer.
     *
     * @return the observer
     */
    Observer getObserver();

    /**
     * Sets the dimension.
     *
     * @param dimension the new dimension
     */
    void setDimension(Dimension dimension);

    /**
     * Gets the dimension.
     *
     * @return the dimension
     */
    Dimension getDimension();

    /**
     * Sets the display frame.
     *
     * @param displayFrame the new display frame
     */
    void setDisplayFrame(final Rectangle displayFrame);

}
