package ui.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.MyNewException;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.PlasmaCannon;

public class TestAcquire2CMD
{

	@Before
	public void reset()
	{
		Environment.reset();
	}
	
	@Test
	public void testConstruct() throws MyNewException
	{
		Environment.initialize(4, 4);
		MockLifeForm mf = new MockLifeForm("A", 10);
		Acquire2CMD ci = new Acquire2CMD(mf);
		assertNotNull(ci);
		assertTrue(ci instanceof CommandInterface);
		assertEquals(Environment.getInstanceOf(), ci.getWorld());
		assertEquals(mf, ci.getLifeForm());
	}

	@Test
	public void testAcquire() throws MyNewException
	{
		Environment.initialize(4, 4);
		Environment testE = Environment.getInstanceOf();
		MockLifeForm mf = new MockLifeForm("A", 10);
		Pistol pl = new Pistol();
		PlasmaCannon pc = new PlasmaCannon();
		Acquire2CMD aq = new Acquire2CMD(mf);
		testE.addLifeForm(mf, 0, 0);
		aq.executeCMD();
		assertNull(mf.getWeapon());
		testE.addWeapon(pl, 0, 0);
		testE.addWeapon(pc, 0, 0);
		aq.executeCMD();
		assertEquals(pc, mf.getWeapon());
		
	}
}
