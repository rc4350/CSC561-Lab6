package ui.command;

import lifeform.LifeForm;

public class DropCMD implements CommandInterface
{
	private LifeForm player;
	public DropCMD(LifeForm lf)
	{
		player = lf;
	}
	/**
	 * 
	 * @return returns player, the lifeForm passed during construction
	 */
	public LifeForm getLifeForm()
	{
	
		return player;
	}
	@Override
	public void executeCMD()
	{
		player.dropWeapon();
		
	}

}
