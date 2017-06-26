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
	private LifeForm lifeForm;
	private Environment world;
	
	public Acquire2CMD(LifeForm player)
	{
		world = Environment.getInstanceOf();
		lifeForm = player;
	}
	
	@Override
	public void executeCMD()
	{
		Weapon wpn = world.getWeapon2(lifeForm.getLocation());
		if( wpn != null)
		{		
			lifeForm.pickUpWeapon(wpn);
			Environment.getInstanceOf().removeWeapon(wpn, lifeForm.getLocation()[0], lifeForm.getLocation()[1]);
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
		return lifeForm;
	}
}
