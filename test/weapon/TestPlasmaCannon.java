package weapon;
/**
 * tests for plasma cannon class
 * @author Ryan Campbell, Deema Alrashdan
 */
import static org.junit.Assert.*;

import org.junit.Test;

import gameplay.SimpleTimer;

public class TestPlasmaCannon {

	/**
	 * Weapons need to do the correct amount of damage based 
	 * on the range of the target.
	 */
	@Test
	public void testPlasmaCannonDamage() 
	{
		PlasmaCannon pc = new PlasmaCannon();
		assertNotNull(pc);
		assertTrue(pc instanceof GenericWeapon);
	}

	/**
     * Weapons fired at targets too far away do 0 damage 
	 * as do weapons that have no ammo.
	 */
	@Test
	public void testZeroDamage()
	{
		PlasmaCannon pc = new PlasmaCannon();
		assertEquals(0,pc.damage(26));
		assertEquals(0,pc.damage(-1));
		
	}
	
	/**
	 * Weapons need to update ammo correctly when fired, 
	 * even if fired at a target too far away.
	 */
	@Test
	public void testUpdateAmmo() 
	{
		SimpleTimer st = new SimpleTimer();
		PlasmaCannon pc = new PlasmaCannon();
		st.addTimeObserver(pc);
		// without fires
		assertEquals(4, pc.getActualAmmo());
		// first fire
		pc.damage(10);	
		st.timeChanged();
		assertEquals(3, pc.getActualAmmo());
		//second fire
		pc.damage(20);
		st.timeChanged();
		assertEquals(2, pc.getActualAmmo());
		//third fire and target too far away
		pc.damage(20);
		st.timeChanged();
		assertEquals(1, pc.getActualAmmo());		
	} 
	
	@Test
	public void testDamage()
	{
		SimpleTimer st = new SimpleTimer();
		PlasmaCannon pc = new PlasmaCannon();
		st.addTimeObserver(pc);
		assertEquals(50, pc.damage(10));
		st.timeChanged();
		assertEquals(37, pc.damage(20));
		st.timeChanged();
		assertEquals(25, pc.damage(20));
	}
	 
	/**
	 * testReloaded
	 * Weapons can be reloaded.
	 */
	@Test
	public void testReloaded()
	{
		PlasmaCannon pc = new PlasmaCannon();
		// fire PlasmaCannon 4 times and actualAmmo should be 6
		pc.actualAmmo = 0;
		//reload pc
		pc.reload();
		assertEquals(pc.getMaxAmmo(), pc.getActualAmmo());
	}
}