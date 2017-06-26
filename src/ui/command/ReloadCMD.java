package ui.command;
/**
 * reload command
 * @author Ryan Campbell
 *
 */
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
		if (player != null)
		{
			player.reload();
		}
	}
}
