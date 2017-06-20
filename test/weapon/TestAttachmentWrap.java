package weapon;
/**
 * Tests for multiple attachments
 * @author Ryan Campbell, Deema Alrashdan
 */
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MyNewException;

public class TestAttachmentWrap
{

	@Test
	public void testScopeScope() throws MyNewException
	{
		Pistol pl = new Pistol();
		Scope sp1 = new Scope(pl);
		Scope sp2 = new Scope(sp1);
		
		assertNotNull(sp2);
		assertEquals(19, sp2.damage(10));
	}
	@Test
	public void testScopeStabilizer() throws MyNewException
	{
		PlasmaCannon pc = new PlasmaCannon();
		Scope sp1 = new Scope(pc);
		Stabilizer stb = new Stabilizer(sp1);
		
		assertNotNull(stb);
		assertEquals(93, stb.damage(10));
	}
	
	@Test
	public void testStabilizerStabilizer() throws MyNewException
	{
		Pistol pl = new Pistol();
		Stabilizer st1 = new Stabilizer(pl);
		Stabilizer st2 = new Stabilizer(st1);
		assertNotNull(st2);
		assertEquals(12, st2.damage(10));
	}
	
	@Test
	public void testStabilizerScope() throws MyNewException
	{
		PlasmaCannon pc = new PlasmaCannon();
		Stabilizer stb = new Stabilizer(pc);
		Scope sp1 = new Scope(stb);
		assertNotNull(sp1);
		assertEquals(93,sp1.damage(10));
		
	}
	
	@Test(expected = MyNewException.class)
	public void testAttachmentLimit() throws MyNewException
	{
		Pistol pl = new Pistol();
		Scope sp1 = new Scope(pl);
		Scope sp2 = new Scope(sp1);
		@SuppressWarnings("unused")
		Scope sp3 = new Scope(sp2);
		assertTrue(false);
	}
}
