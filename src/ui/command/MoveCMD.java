package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class MoveCMD implements CommandInterface
{
	private LifeForm player;
	private Environment world;
	
	public MoveCMD(LifeForm lf)
	{
		player = lf;
		world = Environment.getInstanceOf();
	}

	/**
	 * runs Environment's move command on player
	 */
	@Override
	public void executeCMD()
	{
		world.moveLifeForm(player);

	}
	/**
	 * 
	 * @return world
	 */
	public Environment getWorld()
	{
	
		return world;
	}
	/**
	 * @return player
	 */
	public LifeForm getPlayer()
	{
		
		return player;
	}

}
