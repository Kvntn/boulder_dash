package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
import entity.Entity;
import entity.Map;
import entity.Permeability;
import entity.Sprite;
import entity.mobile.MobileEntity;
import entity.mobile.TheCharacter;
import showboard2.showboard.ISquare;

/**
 * The Class Model.
 *
 * @author Quentin Amram
 */
public final class Model  implements IModel {

	/** The map. */
	private Map map;
	
	/**Our main character*/
	private MobileEntity theCharacter;
	
	/**
	 * Instantiates a new model.
	 * @throws IOException 
	 * 			IOException
	 * @param level
	 * 		the chosen level
	 */
	public Model(int level) throws IOException {
		super();
		Sprite.loadBuffers();
		this.setMap(DAOMapExtract.downloadMap(level));
		this.setTheCharacter(new TheCharacter(2, 1, this.map));
	}
	
	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	

	@Override
	public Map getMap() {
		return this.map;
	}
	
	@Override
	public void setMap(Map map) {
		this.map = map;
	}
	
	public MobileEntity getTheCharacter() {
		return theCharacter;
	}
	
	public void setTheCharacter(MobileEntity theC) {
		this.theCharacter = theC;
	}
	
	@Override
	public void moveEntity(int x, int y) {
		ArrayList<MobileEntity>mEntity = new ArrayList<MobileEntity>(this.getMap().getMobileEntities());
		for(MobileEntity Mentity:mEntity) {
			Mentity.strat(x, y);
		}
	}
}








