package alltests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({entity.EntityTest.class, entity.motionless.MotionlessEntityFactoryTest.class, entity.MapTest.class })
public class AllTests {

}