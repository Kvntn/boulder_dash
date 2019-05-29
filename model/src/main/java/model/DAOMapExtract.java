package model;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.motionless.MotionlessEntityFactory;
import entity.Map;
import entity.mobile.*;


/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
public class DAOMapExtract {

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
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	
	public static final Map downloadMap(int level) throws IOException {

		
		try {
			final String sql = "select item from level" + level;
			final CallableStatement call = prepareCall(sql);
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
	
	
	private static Map resultToMap(final ResultSet result, int level) throws SQLException, IOException{

	
		Map tempMap = new Map(level, new Entity[Map.getWidth()][Map.getHeight()]);

		for(char ch : result.getString(1).toCharArray()) {
			
			for(int y = 0; y < Map.getHeight(); y++) {
				
				for(int x = 0; x < Map.getWidth(); x++) {
					System.out.println(ch);
					tempMap.setOnMapXY(MotionlessEntityFactory.getFromDBSymbol(ch), x, y);

					if(ch == 'B') {
						tempMap.add(new Boulder(x, y, tempMap));
					}
					if(ch == 'E') {
						tempMap.add(new Ennemy(x, y, tempMap));
					}
					if(ch == 'D') {
						tempMap.add(new Diamond(x, y, tempMap));
					}
					if(ch == 'C') {
						tempMap.add(new TheCharacter(x, y, tempMap));
					}
					
				}
			}
			
			
			
			
		}
		
		return tempMap;
	}
	

	public static CallableStatement prepareCall(final String query) throws SQLException {
		return DBConnection.getInstance().getConnection().prepareCall(query);
	}
}


















