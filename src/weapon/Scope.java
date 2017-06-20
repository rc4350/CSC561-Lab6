package weapon;
/**
 * Scope is a weapon attachment
 * @author Ryan Campbell, Deema Alrashdan
 */
import exceptions.MyNewException;

public class Scope extends Attachment
{

	public Scope(Weapon wpn) throws MyNewException
	{
		super(wpn);
	
	}
	/**
	 * damage method for scope
	 * gets calls damage of baseweapon and modifies damage value
	 * @param distance distance between attacker and target
	 */
	@Override
	public int damage(int distance)
	{
		int dmg = super.baseWeapon.damage(distance);
		int moddmg =(int)( (float)dmg*(1.0+( ( (float)baseWeapon.getMaxRange()-(float)distance )/(float)baseWeapon.getMaxRange() )));
		return moddmg;
		
		
		
	}
}
