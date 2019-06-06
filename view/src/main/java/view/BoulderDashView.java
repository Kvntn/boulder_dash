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
	
	/** The Constant squareSize. */
	private static final int squareSize = 50;

	/** The Constant closeView. */
	private Rectangle      closeView = null;

	/** The Map. */
	private Map            map = null;

	/** Les Mobiles. */
	private MobileEntity    TheCharacter = null;
	
	/**Mobile entities list*/
	private ArrayList<MobileEntity> mEntity = null;
	
	private IController  orderPerformer;
	private  BoardFrame boardFrame;

	public BoulderDashView(final Map Map, final MobileEntity TheCharacter, ArrayList<MobileEntity> mE) throws IOException {
	
		this.setMap(Map);
		this.setTheCharacter(TheCharacter);
		this.getTheCharacter().getSprite().loadImage();
		this.setEntity(mE);
		this.setCloseView(new Rectangle(0, 0, entity.Map.getWidth(), entity.Map.getHeight()));
		SwingUtilities.invokeLater(this);
	}

	public void setMap(Map map) throws IOException {
        this.map = map;
        for (int x = 0; x < Map.getWidth(); x++) {
            for(int y = 0; y < Map.getHeight(); y++) {
                this.getMap().getOnMapXY(x, y).getSprite().loadImage();
            }
        }
    }

	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public final void run() {
		boardFrame = new BoardFrame("Мохамeд");
		boardFrame.setDimension(new Dimension(entity.Map.getWidth(), entity.Map.getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setLocationRelativeTo(null);
		boardFrame.setHeightLooped(true);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

	for (int x = 0; x < Map.getWidth(); x++) {
			for (int y = 0; y < Map.getHeight(); y++) {
				boardFrame.addSquare(this.getMap().getOnMapXY(x, y), x, y);
			}
		}
		
		boardFrame.addPawn(this.getTheCharacter());
		
		for(MobileEntity Entities: mEntity) {
			boardFrame.addPawn(Entities);
		}
		
		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		boardFrame.setVisible(true);
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
	public  void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(BoulderDashView.keyCodeToControllerOrder(keyEvent.getKeyCode()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected static ControllerOrder keyCodeToControllerOrder(int keyCode) {
		
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			return ControllerOrder.RIGHT;
			
		case KeyEvent.VK_LEFT:
			return ControllerOrder.LEFT;
			
		case KeyEvent.VK_DOWN:
			return ControllerOrder.DOWN;
			
		case KeyEvent.VK_UP:
			return ControllerOrder.UP;
			
		default:
			return ControllerOrder.NONE;
		}
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
		return map;
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


	@Override
	public void printMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public ArrayList<MobileEntity> getEntity() {
		return mEntity;
	}

	public void setEntity(ArrayList<MobileEntity> entity) {
		mEntity = entity;
	}

	public void updateBoard() {
		for (int x = 0; x < Map.getWidth(); x++) {
			for (int y = 0; y< Map.getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnMapXY(x, y), x, y);
			}
		}

		}
}



