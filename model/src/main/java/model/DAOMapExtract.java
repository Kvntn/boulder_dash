package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.motionless.MotionlessEntityFactory;
import entity.Map;


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
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	
	public Map downloadMap(int level) throws IOException {

		try {
			final String sql = "select item from level" + level;
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				Map map = resultToMap(resultSet, level);
				return map;
			}
			return null;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Map resultToMap(final ResultSet result, int level) throws SQLException, IOException{

		Entity[][] mapContent = null;
		Map map = new Map(level, mapContent);
		
		for(char ch : result.getString(2).toCharArray()) {
			
			for(int x = 0; x <= Map.getWidth(); x++) {
				
				for(int y = 0; y <= Map.getHeight(); y++) {
	
					map.setOnMapXY(MotionlessEntityFactory.getFromDBSymbol(ch), x, y);
					
				}
			}
		}
		
		return map;
	}
	

}


















