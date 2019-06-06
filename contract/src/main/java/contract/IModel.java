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
	 * Gets the map.
	 *
	 * @return Map
	 * 			the map entity
	 */
	Map getMap();

	
	
	public MobileEntity getTheCharacter();
	
	public void setTheCharacter(MobileEntity theC) ;

	void setMap(Map map);
	
	void moveEntity(int x, int y);

	
}
