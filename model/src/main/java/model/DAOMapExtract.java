package model;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;
import entity.motionless.MotionlessEntityFactory;
import entity.Map;
import entity.Permeability;
import entity.mobile.*;


/**
 * The Class DAOHelloWorld.
 *
 * @author Quentin Amram
 */
public class DAOMapExtract {

	private final Connection connection;
	private static int x = 0, y = 0;

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
		Map map = null;
		try {
			final String sql = "call level" + level;
			final CallableStatement call = prepareCall(sql);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			map = resultToMap(resultSet, level);
			return map;
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Map resultToMap(final ResultSet result, int level) throws SQLException, IOException{

		Map tempMap = new Map(level, new Entity[Map.getWidth()][Map.getHeight()]);

		while (result.next()) {
			
			for(char ch : result.getString("item").toCharArray()) { 
					if (x == Map.getWidth()) {
						x = 0;
						y++;
					}
					
					tempMap.setOnMapXY(MotionlessEntityFactory.getFromDBSymbol(ch), x, y);

					if(ch == 'B') {
						tempMap.add(new Boulder(x, y, tempMap));
					}
					if(ch == 'E') {
						tempMap.add(new Ennemy(x, y, tempMap));
					}
					if(ch == 'D') {
						tempMap.add(new Diamond(x, y, tempMap));
						tempMap.increaseDiamondCount();
					}
					
					++x;
			}	
		}
		return tempMap;
	}
	
	public static CallableStatement prepareCall(final String query) throws SQLException {
		return DBConnection.getInstance().getConnection().prepareCall(query);
	}
}


















