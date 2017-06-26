package ui.command;
/**
 * Runs tests for drop command
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
import weapon.PlasmaCannon;

public class TestDropCMD
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
		DropCMD dc = new DropCMD(mf);
		assertNotNull(dc);
		assertTrue(dc instanceof CommandInterface);
		assertEquals(mf, dc.getLifeForm());
	}
	
	@Test
	public void testNull() throws MyNewException
	{
		Environment.initialize(4, 4);
		DropCMD ci = new DropCMD(Environment.getInstanceOf().getPlayer());
		ci.executeCMD();
		assertTrue(true);	//code did not crash
	}
	
	@Test
	public void testDrop() throws MyNewException
	{
		Environment.initialize(4, 4);
		MockLifeForm mf = new MockLifeForm("A", 10);
		DropCMD dc = new DropCMD(mf);
		Pistol pl = new Pistol();
		PlasmaCannon pc = new PlasmaCannon();
		Environment.getInstanceOf().addLifeForm(mf, 0, 0);
		Environment.getInstanceOf().addWeapon(pl, 0, 0);
		mf.pickUpWeapon(pc);
		dc.executeCMD();
		assertNull(mf.getWeapon());
		assertEquals(pc, Environment.getInstanceOf().getWeapon2(mf.getLocation()));
		
	}
}
