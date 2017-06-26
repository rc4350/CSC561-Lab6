package ui.command;
/**
 * Runs tests for command builder
 * @author Ryan Campbell
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

import lifeform.MockLifeForm;

public class TestCommandBuilder
{

	@Test
	public void test()
	{
		MockLifeForm mf = new MockLifeForm("Bob", 40);
		CommandBuilder cb = new CommandBuilder(mf);
		assertNotNull(cb);
	}

}
