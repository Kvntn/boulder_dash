package model;

import java.io.IOException;
import java.util.Observable;

import contract.IModel;
import entity.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Map map;
	private DAOMapExtract dao;

	/**
	 * Instantiates a new model.
	 * @throws IOException 
	 */
	public Model(int level) throws IOException {
		this.setMap(dao.downloadMap(level));
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
	/**
     * Load map.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	
}





















