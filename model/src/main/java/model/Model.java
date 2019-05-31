package model;

import java.io.IOException;
import java.util.Observable;

import contract.IModel;
import entity.Map;
import entity.mobile.TheCharacter;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The map. */
	private Map map;
	private TheCharacter theCharacter;

	
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
	
	public TheCharacter getTheCharacter() {
		return theCharacter;
	}
	
	public void setTheCharacter(TheCharacter theC) {
		this.theCharacter = theC;
	}
}





















