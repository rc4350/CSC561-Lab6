package ui.command;

import environment.Environment;
import lifeform.LifeForm;

public class Acquire1CMD implements CommandInterface
{
	private LifeForm lifeForm;
	private Environment world;
	
	public Acquire1CMD(LifeForm player)
	{
		world = Environment.getInstanceOf();
		lifeForm = player;
	}
	
	@Override
	public void executeCMD()
	{
		lifeForm.pickUpWeapon(world.getWeapon1(lifeForm.getLocation()));
	}

	/**
	 * test method
	 */
	protected Environment getWorld()
	{
		return world;
	}

	public LifeForm getLifeForm()
	{
		// TODO Auto-generated method stub
		return lifeForm;
	}
}
