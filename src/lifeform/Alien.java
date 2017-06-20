package lifeform;

import gameplay.SimpleTimer;
import gameplay.TimeObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryNone;
import exceptions.MyNewException;

/**
 * 
 * @author Ryan Campbell
 * Class to hold Alien - LifeForm
 *
 */
public class Alien extends LifeForm implements TimeObserver
{
	private int maxLifePoints; //max life points of alien
	private RecoveryBehavior recoveryBehavior;
	private static RecoveryNone rn = new RecoveryNone(); //default recovery behavior
	private int recoveryTime;	//how often alien recovers
	SimpleTimer timer;
	private int currentRound; //keeps track of current round
	/**
	 * constructor with recovery behavior
	 * @param name name of alien
	 * @param life max/starting life points for alien
	 * @param rb recovery behavior of alien
	 */
	public Alien(String name, int life, RecoveryBehavior rb)
	{
		super(name, life);
		maxLifePoints = life;
		recoveryBehavior = rb;
		super.setAttackPoints(10);
		
	}
	/**
	 * constructor without recovery behavior
	 * @param name name of alien
	 * @param life max/starting life points for alien
	 */
	public Alien(String name, int life)
	{
		this(name, life, rn);
	}
	/**
	 * constructor with name, life, RecoveryBehavior and attack points
	 * @param name name of alien
	 * @param life max/starting life points for alien
	 * @param rb recovery behavior of alien
	 * @param ap attack points of alien
	 */
	public Alien(String name, int life, RecoveryBehavior rb, int ap)
	{
		this(name, life, rb);
		super.setAttackPoints(ap);
	}
	/**
	 * Constructor with name, life, and attack points
	 * @param name name of alien
	 * @param life max/starting life points for alien
	 * @param ap attack points of alien
	 */
	public Alien(String name, int life, int ap)
	{
		this(name, life);
		super.setAttackPoints(ap);
	}
	/**
	 * Constructor with name, life, RecoveryBehavior, attack points, and recovery time
	 * @param name
	 * @param life
	 * @param rb
	 * @param ap
	 * @param rt
	 * @throws MyNewException 
	 */
	public Alien(String name, int life, RecoveryBehavior rb, int ap, int rt) throws MyNewException
	{
		this(name, life, rb,ap);
		recoveryTime = rt;
		if (rt < 0)
		{
			MyNewException e = new MyNewException();
			throw e;
		}
				
	}
	/**
	 * changes the current life points of alien (this.super.currentLifePoints)
	 * @param newLifePoints new current life points for alien
	 */
	public void setCurrentLifePoints(int newLifePoints)
	{
		super.currentLifePoints = newLifePoints;
	}
	
	/**
	 * executes alien's recovery behavior
	 */
	protected void recover()
	{
		super.currentLifePoints = recoveryBehavior.calculateRecovery(super.currentLifePoints, maxLifePoints);
	}
	@Override
	public void updateTime(int time)
	{
		currentRound = time;
		if(recoveryTime >0)
		{
			if (currentRound % recoveryTime == 0)
			this.recover();
		}
	}
}
