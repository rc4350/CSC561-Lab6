package environment;
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MyNewException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Scope;
/**
 * tests functionality of Cell class
 * @author Ryan Campbell, Deema Alrashdan
 *
 */
public class TestCell {

	//lab 5 test
	@Test
	public void testAddRemoveWeapon() throws MyNewException
	{
		Cell cell = new Cell();
		Pistol pl = new Pistol();
		PlasmaCannon pc1 = new PlasmaCannon();
		PlasmaCannon pc2 = new PlasmaCannon();
		Scope sc = new Scope(pc1);
		
		//adding a weapon with no current weapons
		assertTrue(cell.addWeapon(pl));
		assertEquals(pl, cell.getWeaponOne());
		assertNull(cell.getWeaponTwo());
		//adding a 2nd weapon
		assertTrue(cell.addWeapon(sc));
		assertEquals(pl, cell.getWeaponOne());
		assertEquals(sc, cell.getWeaponTwo());
		//trying to add a weapon when 2 already exist
		assertFalse(cell.addWeapon(pc2));
		assertEquals(pl, cell.getWeaponOne());
		assertEquals(sc, cell.getWeaponTwo());
		//removing a weapon when weapon is in slot one
		assertTrue(cell.removeWeapon(pl));
		assertNull(cell.getWeaponOne());
		assertEquals(sc, cell.getWeaponTwo());
		//adding a weapon when weaponOne is null and weaponTwo is not null
		assertTrue(cell.addWeapon(pl));
		assertEquals(pl, cell.getWeaponOne());
		assertEquals(sc, cell.getWeaponTwo());
		//removing weapon when weapon is in slot two
		assertTrue(cell.removeWeapon(sc));
		assertNull(cell.getWeaponTwo());
		assertEquals(pl, cell.getWeaponOne());
		//removing a weapon when only one weapon exists
		assertTrue(cell.removeWeapon(pl));
		assertNull(cell.getWeaponTwo());
		assertNull(cell.getWeaponOne());
	}
	
	
	//lab 1-2 tests
	@Test
	public void testInitialization() 
	{
		Cell cell = new Cell();
		assertNull(cell.getLifeForm());
	}

	@Test
	public void testSetLifeForm()
	{
		LifeForm bob = new MockLifeForm("Bob", 40);
		LifeForm fred = new MockLifeForm("Fred", 40);
		Cell cell = new Cell();
		//the cell is empty so this should work
		boolean success = cell.addLifeForm(bob);
		assertTrue(success);
		assertEquals(bob, cell.getLifeForm());
		//the cell is not empty so this should fail.
		success = cell.addLifeForm(fred);
		assertFalse(success);
		assertEquals(bob, cell.getLifeForm());
	}
	
	@Test
	public void testRemoveLifeForm()
	{
		Cell c = new Cell();
		LifeForm bob = new MockLifeForm("Bob", 40);
		c.addLifeForm(bob);
		boolean check = c.removeLifeForm();
		assertTrue(check);
	}
}
