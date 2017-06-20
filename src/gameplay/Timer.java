package gameplay;
/**
 * Timer interface
 * @author Ryan Campbell
 *
 */
public interface Timer
{
	public void addTimeObserver(TimeObserver observer);
	public void removeTimeObserver(TimeObserver observer);
	public void timeChanged();
	public int getRound();

}
