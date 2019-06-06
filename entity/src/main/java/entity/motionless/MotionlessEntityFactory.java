package entity.motionless;

public class MotionlessEntityFactory {

	private static BreakableWall breakableWall = new BreakableWall();
	private static UnbreakableWall unbreakableWall = new UnbreakableWall();
	private static DugWall dugWall = new DugWall();
	private static Spawnpoint spawnPoint = new Spawnpoint();
	private static BreakableWall exit = new BreakableWall();
	
	public static MotionlessEntity[] motionlessEntity = {breakableWall, unbreakableWall, dugWall, exit, spawnPoint};
	
	public static MotionlessEntity createBreakableWall() {
		return breakableWall;
	}
	
	public static MotionlessEntity createUnbreakableWall() {
		return unbreakableWall;
	}
	
	public static MotionlessEntity createDugWall() {
		return dugWall;
	}
	
	public static MotionlessEntity createSpawnPoint() {
		return spawnPoint;
	}
	
	public static MotionlessEntity createExit() {
		return breakableWall;
	}
	
	public static MotionlessEntity getFromDBSymbol(char symbol) {
		
		for(final MotionlessEntity motionlessEntity : motionlessEntity) {
			if(motionlessEntity.getSprite().getCharImage() == symbol) {
				return motionlessEntity;
			}
		}
		return dugWall;
	}
}
