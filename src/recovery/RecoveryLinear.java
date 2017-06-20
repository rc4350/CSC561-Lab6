package recovery;
/**
 * 
 * @author Ryan Campbell
 * class to define linear recovery behavior
 *
 */
public class RecoveryLinear implements RecoveryBehavior
{
	private int recoveryStep;
	
	public RecoveryLinear(int step)
	{
		recoveryStep = step;
	}
	/**
	 * method to calculate recovery
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		if (currentLife == maxLife) //if no recovery needed
		{
			return maxLife;
		}
		else if (currentLife == 0)
		{
			return 0;
		}
		else
		{
			int newLife = currentLife + recoveryStep;
			if(newLife<= maxLife) //if recovered to a valid current hp
			{
				return newLife;
			}
			else				//if recovered above max hp
				return maxLife;
		}
	}

}
