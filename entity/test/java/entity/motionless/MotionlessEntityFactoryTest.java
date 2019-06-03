package entity.motionless;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MotionlessEntityFactoryTest {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  
  /**
   * This test verifies that method testCreateDugDirt does not return a null result,
   * and we verifies that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testCreateDugDirt() {
    assertNotNull(MotionlessEntityFactory.createDugWall());
    assertEquals(entity.motionless.MotionlessEntityFactory.createDugWall().getSprite().getCharImage(), 'O');
  }
  
  /**
   * This test verifies that method testCreateFilledDirt does not return a null result,
   * and verifies that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testCreateFilledDirt() {
    assertNotNull(MotionlessEntityFactory.createBreakableWall());
    assertEquals(MotionlessEntityFactory.createBreakableWall().getSprite().getCharImage(), 'W');
  }
  
  /**
   * This test verifies that method testCreateWall does not return a null result,
   * and verifies that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testCreateWall() {
    assertNotNull(MotionlessEntityFactory.createUnbreakableWall());
    assertEquals(MotionlessEntityFactory.createUnbreakableWall().getSprite().getCharImage(), 'X');
  }

}