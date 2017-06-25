/**
 * name: Deema Alrashdan
 */
package gui;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

public class TestGameDisplay {

	/**
	 * TEST MAP
	 */
	@Test
	public void testHumanIcon() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is the Human icon in the cell (4)(4) \nDoes it look right?"));
	}
	
	@Test
	public void testAlienIcon() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is the Alien icon in the cell (4)(5) \nDoes it look right?"));
	}
	
	@Test
	public void testAlienWithWeaponIcon() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Has the Alien a weapon in the cell (3)(2) \nDoes it look right?"));
	}
	
	@Test
	public void testHumanWithWeaponIcon() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Has the Human a weapon in the cell (6)(6) \nDoes it look right?"));
	}
	
	@Test
	public void testPistolIcon() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "is the Pistol Weapon in the cell (1)(2) \nDoes it look right?"));
	}
	
	@Test
	public void testPlasmCannonIcon() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "is the PlasmaCannon Weapon in the cell (6)(2) \nDoes it look right?"));
	}
	
	/**
	 * TEST LEGEND
	 */
	@Test
	public void testHumanDisplay() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (4)(4) of the Human, is the Information displayed correctly \nDoes it look right?"));
	}
	
	@Test
	public void testAlienDisplay() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (4)(5) of the Alien, is the Information displayed correctly \nDoes it look right?"));
	}
	
	@Test
	public void testWeaponDisplay() 
	{
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (3)(2) of the Weapon, is the Information displayed correctly \nDoes it look right?"));
	}
}