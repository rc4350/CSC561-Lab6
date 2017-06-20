package gameplay;
/**
 * tests for SimpleTimer
 * @author Ryan Campbell
 *
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimpleTimer
{
	//lab 3 tests
	@Test
	public void testConstruct()
	{
		SimpleTimer st = new SimpleTimer();
		assertNotNull(st);
		boolean x =  st instanceof Timer;
		assertTrue(x);
	}

	@Test
	public void testAddObserver()
	{
		SimpleTimer st = new SimpleTimer();
		MockSimpleTimerObserver mo = new MockSimpleTimerObserver();
		st.addTimeObserver(mo);
		assertEquals(mo, st.getIndexZero());
	}
	@Test
	public void testRemoveObserver()
	{
		SimpleTimer st = new SimpleTimer();
		MockSimpleTimerObserver mo = new MockSimpleTimerObserver();
		st.addTimeObserver(mo);
		st.removeTimeObserver(mo);
		assertNull(st.getIndexZero());
	}
	/*
	 * used 2 Mock Observers to test that for each was updating all elements properly
	 */
	@Test 
	public void testTimeChanged()
	{
		SimpleTimer st = new SimpleTimer();
		MockSimpleTimerObserver mo = new MockSimpleTimerObserver();
		MockSimpleTimerObserver mo2 = new MockSimpleTimerObserver();
		st.addTimeObserver(mo);
		st.addTimeObserver(mo2);
		st.timeChanged();
		assertEquals(1, mo.myTime);
		assertEquals(1, mo2.myTime);
	}
	@Test
	public void testTimeChangedNoObserver()
	{
		SimpleTimer st = new SimpleTimer();
		MockSimpleTimerObserver mo = new MockSimpleTimerObserver();
		st.timeChanged();
		st.addTimeObserver(mo);
		st.timeChanged();
		assertEquals(2, mo.myTime);
	}
	
	@Test
	public void testSimpleTimerAsThread() throws InterruptedException
	{
		SimpleTimer st = new SimpleTimer(1000);
		st.start();
		Thread.sleep(250); //so we are 1/4th a second different
		for(int x = 0; x<5; x++)
		{
			assertEquals(x,st.getRound());
			Thread.sleep(1000);
		}
	}
}

class MockSimpleTimerObserver implements TimeObserver
{
	public int myTime = 0;
	
	@Override
	public void updateTime(int time)
	{
		myTime = time;
		
	}
	
}
