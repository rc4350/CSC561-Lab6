package recovery;
/**
 * Recovery behavior for fractional recovery
 * @author Ryan Campbell
 *
 */
public class RecoveryFractional implements RecoveryBehavior
{
	private double percentRecovery;
	
	public RecoveryFractional(double percent)
	{
		percentRecovery = percent;
	}

	/**
	 * method calculates new life value based on recovery
	 * @return new current life points
	 */
	@Override
	public int calculateRecovery(int currentLife, int maxLife)
	{
		int recoveryAmount;
		int newlife = currentLife;
		if (currentLife == maxLife)
		{
			return maxLife;
		}
		else if (currentLife == 0)
		{
			return 0;
		}
		else
		{
			recoveryAmount =(int) Math.ceil((double)maxLife*percentRecovery);
			newlife = currentLife+recoveryAmount;
			if(newlife >= maxLife)
			{
				return maxLife;
			}
			else
				return newlife;
		}
	}
	

}
