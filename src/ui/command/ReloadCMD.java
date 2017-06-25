package ui.command;

import lifeform.LifeForm;

public class ReloadCMD implements CommandInterface
{
	private LifeForm player;
	
	public ReloadCMD(LifeForm lf)
	{
		player = lf;
	}

	@Override
	public void executeCMD()
	{
		player.reload();
	}

}
