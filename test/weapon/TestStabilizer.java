package weapon;
/**
 * tests for stabilizer class
 * @author Ryan Campbell, Deema Alrashdan
 */
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MyNewException;

public class TestStabilizer
{

	@Test
	public void testConstruct() throws MyNewException
	{
		Pistol pl = new Pistol();
		Attachment stb = new Stabilizer(pl);
		assertNotNull(stb);
		assertTrue(stb instanceof Attachment);
	}
	
	@Test
	public void testDamage() throws MyNewException
	{
		Pistol pl = new Pistol();
		Stabilizer stb = new Stabilizer(pl);
		
		assertEquals(10, stb.damage(10));
		assertEquals(5, stb.damage(20));
		assertEquals(0, stb.damage(10));
	}
	@Test
	public void testAutoReload() throws MyNewException
	{
		Pistol pl = new Pistol();
		Stabilizer stb = new Stabilizer(pl);
		pl.actualAmmo = 1;
		stb.damage(10);
		assertEquals(stb.getMaxAmmo(), stb.getActualAmmo());
	}
}
