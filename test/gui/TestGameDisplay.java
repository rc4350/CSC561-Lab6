/**
 * name: Deema Alrashdan
 */
package gui;

import static org.junit.Assert.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.junit.Test;
import environment.Environment;
import exceptions.MyNewException;
import lifeform.Alien;
import lifeform.Human;
import ui.command.Acquire1CMD;
import weapon.Pistol;
import weapon.PlasmaCannon;

public class TestGameDisplay
{

	/**
	 * TEST MAP
	 * @throws MyNewException
	 */
	@Test
	public void testMap() throws MyNewException
	{
		GUI gui = new GUI();
		Environment en = Environment.getInstanceOf();
		//add human to the environment
		Human h1 = new Human("Bob", 15, 3); 
		en.addLifeForm(h1, 4, 4);
		gui.update(4,4,h1,null,null);
		//add alien to the environment
		Alien a1 = new Alien("Alien", 30);
		en.addLifeForm(a1, 4, 5);
		gui.update(4,5,a1,null,null);
		//add weapons to the environment
		Pistol gun = new Pistol();
		en.addWeapon(gun, 1, 2);
		gui.update(1,2,null,gun,null);

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is the Human icon in the cell (4)(4) \nDoes it look right?"));
	
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Is the Alien icon in the cell (4)(5) \nDoes it look right?"));

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Has the Alien a weapon in the cell (3)(2) \nDoes it look right?"));
	
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Has the Human a weapon in the cell (6)(6) \nDoes it look right?"));

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "is the Pistol Weapon in the cell (1)(2) \nDoes it look right?"));

		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "is the PlasmaCannon Weapon in the cell (6)(2) \nDoes it look right?"));
	
	}

	/**
	 * TEST LEGEND
	 */
	@Test
	public void testHumanDisplay() 
	{
		//assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (4)(4) of the Human, is the Information displayed correctly \nDoes it look right?"));
	}
	
	@Test
	public void testAlienDisplay() 
	{
		//assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (4)(5) of the Alien, is the Information displayed correctly \nDoes it look right?"));
	}
	
	@Test
	public void testWeaponDisplay() 
	{
		//assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "If you click in the Cell (3)(2) of the Weapon, is the Information displayed correctly \nDoes it look right?"));
	}
}