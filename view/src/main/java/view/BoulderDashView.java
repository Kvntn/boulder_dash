package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.IController;
import entity.mobile.*;
import entity.motionless.*;
import view.showboard.BoardFrame;
import entity.*;


public class BoulderDashView implements Runnable, KeyListener {

	/** The Constant roadView. */
	private static final int MapView   = 50;

	/** The Constant squareSize. */
	private static final int squareSize = 50;

	/** The Constant closeView. */
	private Rectangle      closeView;

	/** The Map. */
	private Map            Map;

	/** Les Mobiles. */
	private MobileEntity    TheCharacter, Boulder, Diamond, Ennemy;

	/** The view. */
	private int            view;


	private IController  orderPerformer;


	public BoulderDashView(final Map Map, final MobileEntity TheCharacter, MobileEntity Boulder, MobileEntity Diamond, MobileEntity Ennemy) throws IOException {
		this.setView(MapView);
		this.setMap(Map);
		this.setTheCharacter(TheCharacter);
		this.getTheCharacter().getSprite().loadImage();
		this.getMap();
		this.setCloseView(new Rectangle(0, this.getTheCharacter().getY(), entity.Map.getWidth(), MapView));
		SwingUtilities.invokeLater(this);
	}


	public void setMap(Map map) {
		Map = map;
	}


	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}


	@Override
	public final void run() {
		final BoardFrame boardFrame = new BoardFrame("Close view");
		this.getMap();
		this.getMap();
		boardFrame.setDimension(new Dimension(entity.Map.getWidth(), entity.Map.getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setHeightLooped(true);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		this.getMap();
		for (int x = 0; x < entity.Map.getWidth(); x++) {
			this.getMap();
			for (int y = 0; y < entity.Map.getHeight(); y++) {
				boardFrame.addSquare(this.Map.getOnMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getTheCharacter());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		boardFrame.setVisible(true);
	}

	/**
	 * Prints the road and the player's vehicle in the console.
	 *
	 * @param yStart
	 *            the y start
	 */
	public final void show(final int yStart) {
		this.getMap();
		int y = yStart % entity.Map.getHeight();
		for (int view = 0; view < this.getView(); view++) {
			this.getMap();
			for (int x = 0; x < entity.Map.getWidth(); x++) {
				if ((x == this.getTheCharacter().getX()) && (y == yStart)) {
					System.out.print(this.getTheCharacter().getSprite().getCharImage());
				} else {
					System.out.print(this.getMap().getOnMapXY(x, y).getSprite().getCharImage());
				}
			}
			this.getMap();
			y = (y + 1) % entity.Map.getHeight();
			System.out.print("\n");
		}
	}

	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */



	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		this.getOrderPerformer().orderPerform(keyCodeToControllerOrder(keyEvent.getKeyCode()));
	}

	private ControllerOrder keyCodeToControllerOrder(int keyCode) {
		ControllerOrder ControllerOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			ControllerOrder = entity.ControllerOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			ControllerOrder = entity.ControllerOrder.LEFT;
			break;
		case KeyEvent.VK_DOWN:
			ControllerOrder = entity.ControllerOrder.DOWN;
			break;
		case KeyEvent.VK_UP:
			ControllerOrder = entity.ControllerOrder.UP;
			break;
		default:
			ControllerOrder = entity.ControllerOrder.NONE;
			break;
		}
		return ControllerOrder;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// None
	}

	/**
	 * Gets the road.
	 *
	 * @return the road
	 */
	private Map getMap() {
		return this.Map;
	}

	/**
	 * Gets my vehicle.
	 *
	 * @return my vehicle
	 */
	private MobileEntity getTheCharacter() {
		return this.TheCharacter;
	}

	/**
	 * Sets my vehicle.
	 *
	 * @param myVehicle
	 *            my new vehicle
	 */
	private void setTheCharacter(final MobileEntity TheCharacter) {
		this.TheCharacter = TheCharacter;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private int getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	private void setView(final int view) {
		this.view = view;
	}


	/**
	 * Sets the close view.
	 *
	 * @param closeView
	 *            the new close view
	 */
	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	private IController getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order performer.
	 *
	 * @param orderPerformer
	 *            the new order performer
	 */
	public final void setOrderPerformer(final IController orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
}



