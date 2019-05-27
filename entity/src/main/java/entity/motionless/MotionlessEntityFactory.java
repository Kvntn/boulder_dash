package entity.motionless;

public class MotionlessEntityFactory {

	private static BreakableWall breakableWall = new BreakableWall(null, null);
	private static UnbreakableWall unbreakableWall = new UnbreakableWall(null, null);
	private static DugWall dugWall = new DugWall(null, null);
	private static Spawnpoint spawnPoint = new Spawnpoint(null, null);
	private static Exit exit = new Exit(null, null);
	
	public MotionlessEntity[] motionlessEntity = {breakableWall, unbreakableWall, dugWall, exit, spawnPoint};
	
	public MotionlessEntity createBreakableWall() {
		return breakableWall;
	}
	
	public MotionlessEntity createUnbreakableWall() {
		return unbreakableWall;
	}
	
	public MotionlessEntity createDugWall() {
		return dugWall;
	}
	
	public MotionlessEntity createSpawnPoint() {
		return spawnPoint;
	}
	
	public MotionlessEntity createExit() {
		return exit;
	}
	
	public MotionlessEntity getFromDBSymbol(char symbol) {
		return null;
	}
}
