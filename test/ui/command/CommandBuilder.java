package ui.command;

import lifeform.LifeForm;

public class CommandBuilder
{

	private LifeForm player;
	public CommandBuilder(LifeForm lf)
	{
		player = lf;
	}
	/**
	 * sets commands of commandUI
	 * @param cui Command UI
	 */
	public void buildInvoker(CommandUI cui)
	{
		cui.setNorth(new TurnCMD(player, LifeForm.NORTH));
		cui.setSouth(new TurnCMD(player, LifeForm.SOUTH));
		cui.setEast(new TurnCMD(player, LifeForm.EAST));
		cui.setWest(new TurnCMD(player, LifeForm.WEST));
		
		cui.setAttack(new AttackCMD(player));
		cui.setMove(new MoveCMD(player));
		cui.setReload(new ReloadCMD(player));
		cui.setPick1(new Acquire1CMD(player));
		cui.setPick2(new Acquire2CMD(player));
		cui.setDrop(new DropCMD(player));
		
	}

}
