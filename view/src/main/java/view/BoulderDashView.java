package view;

	
	import java.awt.Dimension;
	import java.awt.Rectangle;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.io.IOException;

	import javax.swing.JOptionPane;
	import javax.swing.SwingUtilities;
	
	import entity.mobile.*;
	import entity.motionless.*;
	import entity.*;



	public class BoulderDashView implements Runnable, KeyListener {

	    /** The Constant roadView. */
	    private static final int MapView   = 50;

	    /** The Constant squareSize. */
	    private static final int squareSize = 50;

	    /** The Constant closeView. */
	    private Rectangle        closeView;

	    /** The Map. */
	    private Map            Map;

	    /** Les Mobiles. */
	    private MobileEntity          TheCharacter, Boulder, Diamond, Ennemy;

	    /** The view. */
	    private int              view;

	   
	    private IOrderPerformer  orderPerformer;

	   
	    public BoulderDashView(final Map Map, final MobileEntity MyCharacter Boulder Diamond Ennemy) throws IOException {
	        this.setView(MapView);
	        this.setMap(Map);
	        this.setMyCharacter(MyCharacter);
	        this.getMyCharacter().getSprite().loadImage();
	        this.setCloseView(new Rectangle(0, this.getMyCharacter().getY(), this.getMap().getWidth(), MapView));
	        SwingUtilities.invokeLater(this);
	    }

	  
	    public final void displayMessage(final String message) {
	        JOptionPane.showMessageDialog(null, message);
	    }

	  
	    @Override
	    public final void run() {
	        final BoardFrame boardFrame = new BoardFrame("Close view");
	        boardFrame.setDimension(new Dimension(this.getWall().getWidth(), this.getWall().getHeight()));
	        boardFrame.setDisplayFrame(this.closeView);
	        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
	        boardFrame.setHeightLooped(true);
	        boardFrame.addKeyListener(this);
	        boardFrame.setFocusable(true);
	        boardFrame.setFocusTraversalKeysEnabled(false);

	        for (int x = 0; x < this.getMap().getWidth(); x++) {
	            for (int y = 0; y < this.getMap().getHeight(); y++) {
	                boardFrame.addSquare(this.Map.getOnTheRoadXY(x, y), x, y);
	            }
	        }
	        boardFrame.addPawn(this.getMyCharacter());

	        this.getWall().getObservable().addObserver(boardFrame.getObserver());
	        this.followMyCharacter();

	        boardFrame.setVisible(true);
	    }

	    /**
	     * Prints the road and the player's vehicle in the console.
	     *
	     * @param yStart
	     *            the y start
	     */
	    public final void show(final int yStart) {
	        int y = yStart % this.getWall().getHeight();
	        for (int view = 0; view < this.getView(); view++) {
	            for (int x = 0; x < this.getWall().getWidth(); x++) {
	                if ((x == this.getMyCharacter().getX()) && (y == yStart)) {
	                    System.out.print(this.getMyCharacter().getSprite().getConsoleImage());
	                } else {
	                    System.out.print(this.getWall().getOnTheMapXY(x, y).getSprite().getConsoleImage());
	                }
	            }
	            y = (y + 1) % this.getWall().getHeight();
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
	    private static UserOrder keyCodeToUserOrder(final int keyCode) {
	        UserOrder userOrder;
	        switch (keyCode) {
	            case KeyEvent.VK_RIGHT:
	                userOrder = UserOrder.RIGHT;
	                break;
	            case KeyEvent.VK_LEFT:
	                userOrder = UserOrder.LEFT;
	                break;
	          
	            default:
	                userOrder = UserOrder.NOP;
	                break;
	        }
	        return userOrder;
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
	        try {
	            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
	        } catch (final IOException exception) {
	            exception.printStackTrace();
	        }
	    }

	    /*
	     * (non-Javadoc)
	     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	     */
	    @Override
	    public void keyReleased(final KeyEvent keyEvent) {
	        // Nop
	    }

	    /*
	     * (non-Javadoc)
	     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followMyvehicle()
	     */
	    @Override
	    public final void followMyCharacter() {
	        this.getCloseView().y = this.getMyCharacter().getY() - 1;
	    }

	    /**
	     * Gets the road.
	     *
	     * @return the road
	     */
	    private IMap getMap() {
	        return this.Map;
	    }

	    /**
	     * Sets the road.
	     *
	     * @param road
	     *            the new road
	     * @throws IOException
	     *             Signals that an I/O exception has occurred.
	     */
	    private void setRoad(final IMap Map) throws IOException {
	        this.Map = Map;
	        for (int x = 0; x < this.getMap().getWidth(); x++) {
	            for (int y = 0; y < this.getMap().getHeight(); y++) {
	                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
	            }
	        }
	    }

	    /**
	     * Gets my vehicle.
	     *
	     * @return my vehicle
	     */
	    private IMobile getMyCharacter() {
	        return this.MyCharacter;
	    }

	    /**
	     * Sets my vehicle.
	     *
	     * @param myVehicle
	     *            my new vehicle
	     */
	    private void setMyCharacter(final IMobile MyCharacter) {
	        this.MyCharacter = MyCharacter;
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
	     * Gets the close view.
	     *
	     * @return the close view
	     */
	    private Rectangle getCloseView() {
	        return this.closeView;
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
	    private IOrderPerformer getOrderPerformer() {
	        return this.orderPerformer;
	    }

	    /**
	     * Sets the order performer.
	     *
	     * @param orderPerformer
	     *            the new order performer
	     */
	    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
	        this.orderPerformer = orderPerformer;
	    }
	}


}
