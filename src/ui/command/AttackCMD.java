package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class AttackCMD implements CommandInterface
{
	private LifeForm player;
	private Environment world;
	public AttackCMD(LifeForm lf)
	{
		player = lf;
		world = Environment.getInstanceOf();
	}

	/**
	 * lifeForm will attack nearest
	 */
	@Override
	public void executeCMD()
	{
		world.Attack(player);
	}
	
	protected LifeForm getPlayer()
	{
		return player;
	}
	
	protected Environment getWorld()
	{
		return world;
	}

}
