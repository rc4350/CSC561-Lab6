package lifeform;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;
import ui.command.CommandInterface;
import ui.command.TurnCMD;

public class TestTurnCMD
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
		CommandInterface turn = new TurnCMD(mf, 'n');
		assertNotNull(turn);
		assertTrue(turn instanceof CommandInterface);
		
		
	}
	@Test
	public void testTurn()
	{
		MockLifeForm mf = new MockLifeForm("A", 10);
		TurnCMD north = new TurnCMD(mf, LifeForm.NORTH);
		TurnCMD south = new TurnCMD(mf, LifeForm.SOUTH);
		TurnCMD east = new TurnCMD(mf, LifeForm.EAST);
		TurnCMD west = new TurnCMD(mf, LifeForm.WEST);
		mf.changeDirection(LifeForm.SOUTH);
		north.executeCMD();
		assertEquals(LifeForm.NORTH, mf.getCurrentDirection());
		west.executeCMD();
		assertEquals(LifeForm.WEST, mf.getCurrentDirection());
		south.executeCMD();
		assertEquals(LifeForm.SOUTH, mf.getCurrentDirection());
		east.executeCMD();
		assertEquals(LifeForm.EAST, mf.getCurrentDirection());
	}

}
