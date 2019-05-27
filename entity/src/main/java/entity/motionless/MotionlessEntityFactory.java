package entity.motionless;

public class MotionlessEntityFactory {

	private static BreakableWall breakableWall = new BreakableWall();
	private static UnbreakableWall unbreakableWall = new UnbreakableWall();
	private static DugWall dugWall = new DugWall();
	private static Spawnpoint spawnPoint = new Spawnpoint();
	private static Exit exit = new Exit();
	
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
