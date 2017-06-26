package ui.command;
/**
 * Runs tests for move command
 * @author Ryan Campbell
 *
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import exceptions.MyNewException;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

public class TestMoveCMD
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
		MoveCMD ci = new MoveCMD(mf);
		assertNotNull(ci);
		assertTrue(ci instanceof CommandInterface);
		assertEquals(Environment.getInstanceOf(), ci.getWorld());
		assertEquals(mf, ci.getPlayer());
	}

	@Test
	public void testMove() throws MyNewException
	{
		Environment.initialize(4, 4);
		MockLifeForm mf = new MockLifeForm("A", 10);
		MoveCMD mc = new MoveCMD(mf);
		Environment.getInstanceOf().addLifeForm(mf, 0, 0);
		mf.changeDirection(LifeForm.EAST);
		mf.setSpeed(2);
		mc.executeCMD();
		assertEquals(2, mf.getLocation()[1]);
	}
}
