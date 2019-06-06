package entity;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {
  
	private Sprite sprite;
  private Permeability permeability = Permeability.PENETRABLE;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }
  
  /**
   * We create a non-null size new sprite.
   * @throws Exception
   * 			exception
   */
  @Before
  public void setUp() throws Exception {
    sprite = new Sprite('Z', Sprite.mapSheet, new Rectangle(0, 0, 16, 16));
  }

  @After
  public void tearDown() throws Exception {
  }

  /**
   * This test verifie that method testGetsprite does not return a null result.
   */
  @Test
  public void testGetSprite() {
    assertNotNull(this.sprite);
    assertNotNull(this.sprite.getCharImage());
    
  }
  /**
   * This test verifie that method testGetPermeability does not return a null result.
   */
  @Test
  public void testGetPermeability() {
    assertNotNull(this.permeability);
  }

  @Test
  public void testGetImage() {
    /**
     * As we don't load the buffer, we don't have image to load
     * That why we have a null result
     */
    assertNull(this.sprite.getImage());
  }

}