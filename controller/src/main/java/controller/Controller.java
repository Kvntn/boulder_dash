package controller;

import entity.ControllerOrder;
import showboard2.showboard.BoardFrame;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController {
	
	private ControllerOrder order=ControllerOrder.NONE;
	public ControllerOrder getOrder() {
		return order;
	}


	public void setOrder(ControllerOrder order) {
		this.order = order;
	}


	public IView getView() {
		return view;
	}
	/** The view. **/
	@SuppressWarnings("unused")
	private IView view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		super();
		this.setView(view);
		this.setModel(model);
	}

	
	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
		
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@Override
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
				case UP :
					this.getModel().getMap().getTheCharacter().moveUp();
					break;
				case DOWN:
					this.getModel().getMap().getTheCharacter().moveDown();
					break;
				case RIGHT:
					this.getModel().getMap().getTheCharacter().moveRight();
					break;
				case LEFT:
					this.getModel().getMap().getTheCharacter().moveLeft();
					break;
				default: 
					this.getModel().getMap().getTheCharacter().stay();
					break;
		}
}

	public IModel getModel() {
		return model;
	}


	@Override
	public void control() {
		// TODO Auto-generated method stub
		
	}
	private void clearOrder() {
		this.order=ControllerOrder.NONE;
	}
	public final void play() throws InterruptedException{
		this.getModel().getMap().setTheCharacter(this.getModel().getTheCharacter());
		while(this.getModel().getTheCharacter().isAlive()) {
			Thread.sleep(200);
			if(this.getModel().getTheCharacter().canMove(this.getOrder())) {
		switch(this.getOrder()) {
		case RIGHT:
			this.getModel().getTheCharacter().moveRight();
			break;
		case LEFT:
			this.getModel().getTheCharacter().moveLeft();
			break;
		case UP:
			this.getModel().getTheCharacter().moveUp();
			break;
		case DOWN:
			this.getModel().getTheCharacter().moveDown();
			break;
		case NONE:
			default:this.getModel().getTheCharacter().stay();
			break;
			
					}
				}
			this.getModel().moveEntity();
			this.clearOrder();
			this.getView().updateBoard();
			if(this.getModel().getMap().getDiamondCount()==0) {
				this.getView().printMessage("Well Played");
				System.exit(0);
			}
			}
		this.getView().printMessage("You Loose");
		System.exit(0);
	
	}
	
}
