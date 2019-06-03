package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.IController;
import contract.IView;
import entity.mobile.*;

import showboard2.showboard.BoardFrame;
import entity.*;


public class BoulderDashView implements Runnable, KeyListener, IView {
	
	/** The Constant mapView. */
	@SuppressWarnings("unused")
	private static final int MapView   = 50;

	/** The Constant squareSize. */
	private static final int squareSize = 50;

	/** The Constant closeView. */
	private Rectangle      closeView;

	/** The Map. */
	private Map            Map;

	/** Les Mobiles. */
	private MobileEntity    TheCharacter;
	
	private ArrayList<MobileEntity> mEntity;

	public ArrayList<MobileEntity> getEntity() {
		return mEntity;
	}


	public void setEntity(ArrayList<MobileEntity> entity) {
		mEntity = entity;
	}

	/** The view. */
	private int            view;


	private IController  orderPerformer;
	private  BoardFrame boardFrame;


	public BoulderDashView(final Map Map, final MobileEntity TheCharacter, ArrayList<MobileEntity> mE) throws IOException {
	
		this.setMap(Map);
		this.setTheCharacter(TheCharacter);
		this.getTheCharacter().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getTheCharacter().getY(), entity.Map.getWidth(), entity.Map.getHeight()));
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
		boardFrame = new BoardFrame("Close view");
		boardFrame.setDimension(new Dimension(entity.Map.getWidth(), entity.Map.getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setLocationRelativeTo(null);
		boardFrame.setHeightLooped(true);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		this.getMap();
		for (int x = 0; x < entity.Map.getWidth(); x++) {
			for (int y = 0; y < entity.Map.getHeight(); y++) {
				boardFrame.addSquare(this.Map.getOnMapXY(x, y), x, y);
			}
		}
		
		boardFrame.addPawn(this.getTheCharacter());
		for(MobileEntity Entities: mEntity) {
			boardFrame.addPawn(Entities);
		}
		

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		boardFrame.setVisible(true);
	}

	/**
	 * Prints the map and the player's character in the console.
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
	
	public void removeFromBoard(Entity en) {
		en = null;
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
	 * Gets the map.
	 *
	 * @return the map
	 */
	private Map getMap() {
		return this.Map;
	}

	/**
	 * Gets my character.
	 *
	 * @return my character
	 */
	private MobileEntity getTheCharacter() {
		return this.TheCharacter;
	}

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

	public void updateBoard() {
		for (int x = 0; x < entity.Map.getWidth(); x++) {
			for (int y = 0; y < entity.Map.getHeight(); y++) {
				boardFrame.addSquare(this.Map.getOnMapXY(x, y), x, y);
			}
		}
	}


	@Override
	public void printMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
}



