package weapon;
/**
 * tests for pistol class
 * @author Ryan Campbell, Deema Alrashdan
 */
import static org.junit.Assert.*;

import org.junit.Test;

import gameplay.SimpleTimer;

public class TestPistoL
{

	@Test
	public void testConstruct()
	{
		Pistol pl = new Pistol();
		assertNotNull(pl);
		assertTrue(pl instanceof GenericWeapon);
	}
	@Test
	public void testDamage()
	{
		Pistol pl = new Pistol();
		assertEquals(8, pl.damage(10));
		assertEquals(2, pl.damage(24));
	}
	@Test
	public void testOutOfRange()
	{
		Pistol pl = new Pistol();
		assertEquals(0, pl.damage(26));
		assertEquals(0, pl.damage(-1));
	}
	
	@Test
	public void testOutOfAmmo()
	{
		Pistol pl = new Pistol();
		pl.actualAmmo = 0;
		assertEquals(0, pl.damage(10));
		pl.reload();
		assertEquals(8, pl.damage(10));
		assertEquals(9, pl.actualAmmo);
	}
	@Test
	public void testRateOfFire()
	{
		Pistol pl = new Pistol();
		SimpleTimer st = new SimpleTimer();
		st.addTimeObserver(pl);
		assertEquals(8, pl.damage(10));
		assertEquals(8, pl.damage(10));
		assertEquals(0, pl.damage(10));
		st.timeChanged();
		assertEquals(8, pl.damage(10));
	}
}
