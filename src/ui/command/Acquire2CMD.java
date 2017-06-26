package ui.command;
/**
 * aquire command
 * @author Ryan Campbell
 *
 */
import environment.Environment;
import lifeform.LifeForm;
import weapon.Weapon;

public class Acquire2CMD implements CommandInterface
{
	private LifeForm player;
	private Environment world;
	
	public Acquire2CMD(LifeForm lf)
	{
		world = Environment.getInstanceOf();
		player = lf;
	}
	
	@Override
	public void executeCMD()
	{
		if(player != null)
		{
			Weapon wpn = world.getWeapon2(player.getLocation());
			if (wpn != null)
			{
				player.pickUpWeapon(wpn);
				Environment.getInstanceOf().removeWeapon(wpn, player.getLocation()[0], player.getLocation()[1]);
			}
		}
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
		return player;
	}
}
