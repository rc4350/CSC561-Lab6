package ui.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.MyNewException;
import lifeform.MockLifeForm;
import weapon.Pistol;
import weapon.PlasmaCannon;

public class TestAcquireCMD
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
		Acquire1CMD ci = new Acquire1CMD(mf);
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
		Acquire1CMD aq = new Acquire1CMD(mf);
		testE.addLifeForm(mf, 0, 0);
		aq.executeCMD();
		assertNull(mf.getWeapon());
		testE.addWeapon(pl, 0, 0);
		testE.addWeapon(pc, 0, 0);
		aq.executeCMD();
		assertEquals(pl, mf.getWeapon());
		
	}
}
