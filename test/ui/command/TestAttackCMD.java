package ui.command;

/**
 * Runs tests for attack command
 * @author Ryan Campbell
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.MyNewException;
import lifeform.Alien;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestAttackCMD
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
		AttackCMD ci = new AttackCMD(mf);
		assertNotNull(ci);
		assertTrue(ci instanceof CommandInterface);
		assertEquals(Environment.getInstanceOf(), ci.getWorld());
		assertEquals(mf, ci.getPlayer());
	}
	
	@Test
	public void testAttack() throws MyNewException
	{
		Environment.initialize(4, 4);
		MockLifeForm mf = new MockLifeForm("A", 10, 20);
		AttackCMD ac = new AttackCMD(mf);
		Alien al = new Alien("Al", 100);
		
		Environment.getInstanceOf().addLifeForm(mf, 1, 0);
		mf.changeDirection(LifeForm.EAST);
		Environment.getInstanceOf().addLifeForm(al, 2, 2);
		ac.executeCMD();
		assertEquals(80, al.getCurrentLifePoints());
	}

}
