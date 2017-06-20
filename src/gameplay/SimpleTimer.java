package gameplay;
/**
 * implementation of Timer interface
 * @author Ryan Campbell
 *
 */
import java.util.ArrayList;

public class SimpleTimer extends Thread implements Timer
{
	private int round;
	private int mywait;
	ArrayList<TimeObserver> theObserver;
	
	/**
	 * Constructor, no arguments
	 */
	public SimpleTimer()
	{
		round = 0;
		theObserver = new ArrayList<TimeObserver>();
		mywait = 0;
	}
	/**
	 * Constructor with thread wait time
	 * @param wait wait time between rounds, in milliseconds
	 */
	public SimpleTimer(int wait)
	{
		round = 0;
		theObserver = new ArrayList<TimeObserver>();
		mywait = wait;
		
	}
	
	
	@Override
	public void run()
	{
		try
		{
			while (round <50)
			{
				Thread.sleep(mywait);
				this.timeChanged();
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void addTimeObserver(TimeObserver observer)
	{
		theObserver.add(observer);
		
	}

	@Override
	public void removeTimeObserver(TimeObserver observer)
	{
		theObserver.remove(observer);
		
	}

	@Override
	public void timeChanged()
	{
		round++;
		for(TimeObserver to : theObserver)
		{
			to.updateTime(round);
		}
	}
	/**
	 * gets first object in array list. for test purposes
	 * @return returns index 0 of array list 'theObserver'
	 */
	public TimeObserver getIndexZero()
	{
		if(theObserver.isEmpty())
		{
			return null;
		}
		else
			return theObserver.get(0);
	}

	@Override
	public int getRound()
	{
		// TODO Auto-generated method stub
		return round;
	}
}
