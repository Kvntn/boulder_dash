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
 * @author Jean-Aymeric Diet
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

		int count = 0;
		int countB = 0;
		int countD = 0;
		int countE = 0;
		int countC = 0;
		
		Map tempMap = new Map(level, new Entity[Map.getWidth()][Map.getHeight()]);

		while (result.next()) {
			
			for(char ch : result.getString("item").toCharArray()) { 
					if (x == Map.getWidth()) {
						x = 0;
						y++;
					}
					
					tempMap.setOnMapXY(MotionlessEntityFactory.getFromDBSymbol(ch), x, y);

					if(ch == 'B') {
						tempMap.add(new Boulder(x, y, tempMap,Permeability.BLOCKING));
						countB++;
					}
					if(ch == 'E') {
						tempMap.add(new Ennemy(x, y, tempMap, Permeability.BLOCKING));
						countE++;
					}
					if(ch == 'D') {
						tempMap.add(new Diamond(x, y, tempMap, Permeability.PENETRABLE));
						countD++;
					}
					if(ch == 'A') {
						tempMap.add(new TheCharacter(x, y, tempMap, Permeability.BLOCKING));
						countC++;
					}
					++count;
					++x;
			}	
		}
		System.out.println(count);
		System.out.println("B = " + countB + "\n E = "+countE+"\n D = "+countD+"\n C = "+countC);
		return tempMap;
	}

	public static CallableStatement prepareCall(final String query) throws SQLException {
		return DBConnection.getInstance().getConnection().prepareCall(query);
	}
}


















