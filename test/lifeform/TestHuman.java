package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests for Human class
 * @author Ryan Campbell
 *
 */
public class TestHuman
{
	//lab 3 tests
	@Test
	public void testAttack()
	{
		Human bob = new Human("Bob", 40, 0, 10);
		Human john = new Human("John", 50, 0, 10);
		assertNotNull(bob);
		john.takeHit(bob.attack());
		assertEquals(40, john.currentLifePoints);
	}
	
	@Test
	public void testArmor()
	{
		Human bob = new Human("Bob", 100, 10, 10);
		bob.takeHit(15);
		assertEquals(95, bob.currentLifePoints);
	}
	@Test
	public void testFullArmor()
	{
		Human bob =new Human("Bob", 100, 10, 10);
		bob.takeHit(7);
		assertEquals(100, bob.currentLifePoints);
	}
	@Test
	public void testAttackDefault()
	{
		Human bob = new Human("Bob", 100, 0);
		bob.takeHit(bob.attack());
		assertEquals(95, bob.currentLifePoints);
	}
	//lab 1-2 tests
	@Test
	public void testConstruct()
	{
		LifeForm lform = new Human("Bob", 40, 10);
		assertNotNull(lform);
		Human lform2 = new Human("Bob", 40, -1);
		assertEquals(0, lform2.getArmorPoints());
	}
	
	@Test
	public void testGetArmorPoints()
	{
		Human bob = new Human("Bob", 40, 10);
		assertEquals(10, bob.getArmorPoints());
	}

	@Test
	public void testSetArmorPoints()
	{
		Human bob = new Human("Bob", 40, 10);
		assertFalse(bob.setArmorPoints(-1));
		assertTrue(bob.setArmorPoints(0));
	}
}
