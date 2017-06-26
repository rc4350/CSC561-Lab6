package ui.command;
/**
 * attack command
 * @author Ryan Campbell
 *
 */
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
		if(player != null)
		{
			world.Attack(player);
	
		}
	}
	/**
	 * test code
	 */
	protected LifeForm getPlayer()
	{
		return player;
	}
	
	protected Environment getWorld()
	{
		return world;
	}

}
