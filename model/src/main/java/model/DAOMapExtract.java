package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.motionless.MotionlessEntityFactory;
import entity.Map;
import entity.motionless.Exit;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOMapExtract {

	private final Connection connection;

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOMapExtract(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	protected Connection getConnection() {
		return this.connection;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	
	public boolean create(final Map map) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	
	public boolean delete(final Map map) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	
	public boolean update(final Map map) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	
	public String find(final int id) {

		try {
			final String sql = "{call helloworldById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(id, resultSet.getString("code"), resultSet.getString("message"));
			}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	
	public Map downloadMap(int level) {

		try {
			final String sql = "select item from level" + level;
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			char[] str = resultSet.getString(2).toCharArray();
			if (resultSet.first()) {
				Map map = new Map(level, charToEntity(str));
				return map;
			}
			return null;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Map resultToMap(final ResultSet result, int width, int level) throws SQLException, IOException{

		Entity[][] mapContent = null;
		Map map = new Map(level, mapContent);
		
		
		int currentX = 0;
		int currentY = 0;
		boolean skip = false;
		
		for(char ch : result.getString(2).toCharArray()) {
			
			for(int x = 0; x <= ; x++) {
				
				for(int y = 0; y <= 32; y++) {
	
					map.setOnMapXY(MotionlessEntityFactory.getFromDBSymbol(ch), x, y);
					
				}
			}
		}
		
		return map;
	}
	

}


















