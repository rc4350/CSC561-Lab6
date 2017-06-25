package ui.command;

import lifeform.LifeForm;

public class TurnCMD implements CommandInterface
{

	private LifeForm player;
	private char direction;
	public TurnCMD(LifeForm lf, char dir)
	{
		player = lf;
		direction = dir;
	}

	@Override
	public void executeCMD()
	{
		player.changeDirection(direction);

	}

}
