package weapon;
/**
 * Tests for Attachment Class
 * @author Ryan Campbell, Deema Alrashdan
 */
import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.MyNewException;

public class TestAttachment
{

	@Test
	public void testConstruct() throws MyNewException
	{
		Pistol pl = new Pistol();
		Attachment at = new MockAttachment(pl);
		assertNotNull(at);
		assertEquals(pl, at.baseWeapon);
		
	}
	@Test
	public void testGetters() throws MyNewException
	{
		Pistol pl = new Pistol();
		Attachment at = new MockAttachment(pl);
		assertEquals(pl.getBaseDamage(),at.getBaseDamage());
		assertEquals(pl.getMaxRange(), at.getMaxRange());
		assertEquals(pl.getRateOfFire(), at.getRateOfFire());
		assertEquals(pl.getMaxAmmo(), at.getMaxAmmo());
		assertEquals(pl.getActualAmmo(), at.getActualAmmo());
	}
	@Test
	public void testRange() throws MyNewException
	{
		Pistol pl = new Pistol();
		Attachment at = new MockAttachment(pl);
		assertTrue(at.checkRange(25));
		assertFalse(at.checkRange(26));
	}
	@Test
	public void testReload() throws MyNewException
	{
		Pistol pl = new Pistol();
		Attachment at = new MockAttachment(pl);
		at.damage(10);
		assertEquals(at.getMaxAmmo()-1,at.getActualAmmo());
		at.reload();
		assertEquals(at.getMaxAmmo(), at.getActualAmmo());
	}

}

class MockAttachment extends Attachment
{
	public MockAttachment(Weapon wpn) throws MyNewException
	{
		super(wpn);
	}

}