package ui.command;
/**
 * Runs tests for reload command
 * @author Ryan Campbell
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.MyNewException;
import lifeform.MockLifeForm;
import weapon.Pistol;

public class TestReloadCMD
{
	@Before
	public void reset()
	{
		Environment.reset();
	}
	
	@Test
	public void testConstruct() 
	{
		MockLifeForm mf = new MockLifeForm("A", 10);
		CommandInterface rc = new ReloadCMD(mf);
		assertNotNull(rc);
		assertTrue(rc instanceof CommandInterface);
	}
	
	@Test
	public void testReload() throws MyNewException
	{
		Environment.initialize(4, 4);
		int x;
		MockLifeForm mf = new MockLifeForm("A", 10);
		MockLifeForm bf = new MockLifeForm("B", 10);
		ReloadCMD rc = new ReloadCMD(mf);
		Environment.getInstanceOf().addLifeForm(mf, 0, 0);
		Environment.getInstanceOf().addLifeForm(bf, 3, 3);
		rc.executeCMD();
		Pistol pl = new Pistol();
		mf.pickUpWeapon(pl);
		x = pl.getActualAmmo();
		mf.attack(Environment.getInstanceOf().getDistance(mf, bf));
		assertEquals(x-1, pl.getActualAmmo());
		rc.executeCMD();
		assertEquals(x, pl.getActualAmmo());
		rc.executeCMD();
		assertEquals(x, pl.getActualAmmo());
		
	}

}
