package controller;

import entity.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.mobile.TheCharacter;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. **/
	private IView view;

	/** The model. */
	private IModel	model;

	private static final int speed = 200;
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
				this.getmodel().getMyCharacter().moveUp();
				break;
				case DOWN:
				this.getModel().getMyCharacter().moveDown();
				break;
				case RIGHT:
				this.getModel().getMyCharacter().moveRight();
				break;
				case LEFT:
				this.getModel().getMyCharacter().moveLeft();
				break;
				default: 
				this.getModel().getMyCharacter().doNothing();
				break;
		}
}

	@Override
	public void control() {
		// TODO Auto-generated method stub
		
	}

}
