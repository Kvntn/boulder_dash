package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
import entity.Map;
import entity.mobile.MobileEntity;
import entity.mobile.TheCharacter;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The map. */
	private Map map;
	private MobileEntity theCharacter;

	
	/**
	 * Instantiates a new model.
	 * @throws IOException 
	 */
	public Model(int level) throws IOException {
		this.setMap(DAOMapExtract.downloadMap(level));
		this.setTheCharacter(getMap().getTheCharacter());
	
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
	public Observable getObservable() {
		return this;
	}

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
	public void moveEntity() {
		ArrayList<MobileEntity>mEntity=new ArrayList<MobileEntity>(this.getMap().getMobileEntities());
		for(MobileEntity Mentity:mEntity) {
			Mentity.strat();
		}
	}
}





















