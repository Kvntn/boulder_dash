package entity;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MapTest {

  private Map map;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    
    map = new Map(5, null);
    map.increaseDiamondCount();
    map.increaseDiamondCount();
    map.increaseDiamondCount();
  }

  @After
  public void tearDown() throws Exception {
  }

  /**
   * This test verifies that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testDecreaseDiamondCount() {
   int expected = 2;
   this.map.decreaseDiamondCount();
   assertEquals(expected, this.map.getDiamondCount());
  }

  /**
   * This test verifies that a piece has been properly initialized and are equals.
   * 
   */
  @Test
  public void testAddDiamondCount() {
    int expected = 4;
    this.map.increaseDiamondCount();
    assertEquals(expected, this.map.getDiamondCount());;
  }
  
  /**
   * This test verifies that a piece has been properly initialized and are equals,
   * and the method does not return a null result.
   * 
   */
  @Test
  public void testGetDiamondCount() {
    int expected = 3;
    assertNotNull(this.map.getDiamondCount());
    assertEquals(expected, this.map.getDiamondCount());
  }

  /**
   * This test verifies that a piece has been properly initialized and don't return a null result,
   * and is greater then 0.
   * 
   */
  @Test
  public void testGetWidth() {
    assertNotNull(this.map);
    assertTrue(Map.getWidth() > 0);
    
  }

  /**
   * This test verifies that a piece has been properly initialized and don't return a null result,
   * and is greater then 0.
   * 
   */
  @Test
  public void testGetHeight() {
    assertNotNull(this.map);
    assertTrue(Map.getHeight() > 0);
  }

  
}