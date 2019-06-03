package contract;

import entity.ControllerOrder;

/**
 * The Interface IController.
 *
 * @author Quentin Amram
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
}
