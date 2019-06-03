package contract;

import java.util.Observable;

import entity.Map;
import entity.mobile.MobileEntity;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	Map getMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	public MobileEntity getTheCharacter();
	
	public void setTheCharacter(MobileEntity theC) ;

	void setMap(Map map);
	void moveEntity();

	
}
