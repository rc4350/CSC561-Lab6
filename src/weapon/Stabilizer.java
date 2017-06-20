package weapon;
/**
 * Stabilizer is a weapon attachment
 * @author Ryan Campbell, Deema Alrashdan
 */
import exceptions.MyNewException;

public class Stabilizer extends Attachment
{

	public Stabilizer(Weapon wpn) throws MyNewException
	{
		super(wpn);
	}
	/**
	 * Stabilizer damage method
	 * calls damage of baseWeapon and modifies returned value
	 * @param distance distance between attacker and target
	 */
	@Override
	public int damage(int distance)
	{
		int dmg = super.baseWeapon.damage(distance);
		int moddmg = (int) ((float)dmg*1.25);
		if(super.getActualAmmo() == 0)
		{
			super.reload();
		}
		return moddmg;
	}

}
