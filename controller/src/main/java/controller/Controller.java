package controller;

import entity.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	private ControllerOrder order = ControllerOrder.NONE;

	private int x, y;

	public IView getView() {
		return view;
	}
	/** The view. **/
	private IView view;

	/** The model. */
	private IModel	model;

	private int timer = 250;

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
	 * @throws InterruptedException 
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@Override
	public void orderPerform(final ControllerOrder controllerOrder) throws InterruptedException {

		this.setOrder(controllerOrder);
		
		Thread.sleep(timer);
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
			default:
				this.getModel().getTheCharacter().stay();
				break;
			}
			
			this.getView().updateBoard();

		}
	}



	public final void play() throws InterruptedException{

		this.getModel().getMap().setTheCharacter(this.getModel().getTheCharacter());

		while(this.getModel().getTheCharacter().isAlive()) {


			Thread.sleep(timer);
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
				default:
					this.getModel().getTheCharacter().stay();
					break;
				}
			}

			x = this.getModel().getMap().getTheCharacter().getX();
			y = this.getModel().getMap().getTheCharacter().getY();

			this.getModel().moveEntity(x, y);
			this.clearOrder();

//			this.getView().updateBoard();

			if(this.getModel().getMap().getDiamondCount()==0) {
				this.getView().printMessage("Well Played");
				System.exit(0);
			}


		}

		this.getView().printMessage("You Loose");
		System.exit(0);

	}
	public ControllerOrder getOrder() {
		return order;
	}


	public void setOrder(ControllerOrder order) {
		this.order = order;
	}
	public IModel getModel() {
		return model;
	}


	@Override
	public void control() {

	}

	private void clearOrder() {
		this.order=ControllerOrder.NONE;
	}

}
