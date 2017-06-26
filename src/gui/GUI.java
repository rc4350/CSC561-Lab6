/**
 * name: Deema Alrashdan
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import environment.Environment;
import exceptions.MyNewException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import ui.command.Acquire1CMD;
import ui.command.CommandUI;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JSeparator;

public class GUI extends JFrame implements ActionListener {

	private JPanel map, legend;
	private JPanel layer1;
	private JPanel commandPanel;
	private CommandUI commandUI;
	JButton[][] SquareBtn;
	private static Environment e; //the game environment
	static final int rows = 8; 
    static final int cols = 8;
    int sizeGrid = 70;
    int sizeWeapon = 10;
    int sizeAttachment = 10;
    int rowFromMap, colFromMap;
    JLabel lblStats;
    
    Color humanC = new Color(0,255,0);
    Color alienC = new Color(0,128,255);
    Color weaponC = new Color(255, 204, 204); // weapon without attachments
    Color weaponC1 = new Color(255, 102, 102); // weapon with 1 attachment
    Color weaponC2 = new Color(255, 0, 0); // weapon with 2 attachment
    Color plasmaC = new Color(0, 0, 255); // weapon with 2 attachment

	/**
	 * Create the frame.
	 * @throws MyNewException 
	 */
	public GUI() throws MyNewException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 840, 640);
		setTitle("Aliens vs Humans");

		Environment.initialize(rows, cols);
		e = Environment.getInstanceOf();
		Human h1 = new Human("Bob", 15, 3);
		e.setPlayer(h1);
		e.addLifeForm(h1, 4, 4);
		
		
		/**
		 * Map
		 */
		
		map = new JPanel();
		map.setLayout(new BorderLayout());
		
		
		
		map = new JPanel(new GridLayout(rows, cols));
		map.setPreferredSize(new Dimension(rows, cols));
		map.setBorder(new TitledBorder(null, "MAP", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//Adding buttons in Jpanel Map
		SquareBtn = new JButton[rows][cols];
		for(int i = 0; i < rows; i ++)
		{
			for(int j = 0; j < cols; j++)
			{
				SquareBtn[i][j] = new JButton(createCell());
				SquareBtn[i][j].setBackground(Color.BLACK);
				SquareBtn[i][j].setActionCommand("pos: "+i+" "+j);
				SquareBtn[i][j].addActionListener(this);
				map.add(SquareBtn[i][j]);
			}
		}
		getContentPane().add("Center",map);
		
		//ryan edit
				commandUI = new CommandUI();
				commandPanel = commandUI.getPanel();
				getContentPane().add("South", commandPanel);
		
		/**
		 * Legend
		 */
		legend = new JPanel();
		legend.setBorder(new TitledBorder(null, "LEGEND", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		legend.setPreferredSize(new Dimension(200, 600)); 
		getContentPane().add("East",legend);
		legend.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Label Information
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformation.setPreferredSize(new Dimension(180, 25));
		legend.add(lblInformation);
		
		//Separator
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(180, 5));
		separator.setMinimumSize(new Dimension(180, 5));
		legend.add(separator);
		
		lblStats = new JLabel("<html>"
				  +"LifeForm Name: name <br>"
				  +"Type OF LIFE: Alien or Human<br>"
				  +"Weapon: weapon<br>"
				  +"Life points: direction<br>"
				  +"<br>"
				  +"Attachment 1: <br>"
				  +"Attachment 2: </justify></html>");
		lblStats.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblStats.setPreferredSize(new Dimension(180, 100)); 
		legend.add(lblStats);
		
		//Separator
		JSeparator separator2 = new JSeparator();
		separator2.setPreferredSize(new Dimension(180, 5));
		separator2.setMinimumSize(new Dimension(180, 5));
		legend.add(separator2);
		setVisible(true);

		/**
		 * HUMAN
		 */
		ImageIcon imgIcon;
		/*Human h1 = new Human("Bob", 15, 3);
		e.setPlayer(h1);
		e.addLifeForm(h1, 4, 4);
		
		//ryan edit
		commandUI = new CommandUI();
		commandPanel = commandUI.getPanel();
		//layer1.add("South", commandPanel);
		//end*/
		imgIcon = (ImageIcon) SquareBtn[4][4].getIcon();  
		SquareBtn[4][4].setIcon(iconHuman(imgIcon, h1));
		
		/**
		 * ALIEN
		 */
		Alien a1 = new Alien("Alien", 30);
		e.addLifeForm(a1, 4, 5);
		
		imgIcon = (ImageIcon) SquareBtn[4][5].getIcon(); 
		SquareBtn[4][5].setIcon(iconAlien(imgIcon, a1));
		Acquire1CMD acq = new Acquire1CMD(a1);
		
		//ryan edit
		//getContentPane().add("Center",map);
		//getContentPane().add("East",legend);
		//getContentPane().add("South", commandPanel);
		//emd
		/**
		 * WEAPONS
		 */
				// 1 WEAPON
				Pistol gun = new Pistol();
				e.addWeapon(gun, 1, 2);
				imgIcon = (ImageIcon) SquareBtn[1][2].getIcon(); 
				SquareBtn[1][2].setIcon(iconWeaponOne(imgIcon, 0));
				
				// 2 Weapon
				PlasmaCannon pc = new PlasmaCannon();
				e.addWeapon(pc, 6, 2);
				imgIcon = (ImageIcon) SquareBtn[6][2].getIcon(); 
				SquareBtn[6][2].setIcon(iconWeaponTwo(imgIcon, 0));
				
				//Alien with weapon
				Alien a2 = new Alien("Predator", 30);
				Pistol gun3 = new Pistol();
				a2.pickUpWeapon(gun3);
				e.addLifeForm(a2, 3, 2);

				imgIcon = (ImageIcon) SquareBtn[3][2].getIcon(); 
				SquareBtn[3][2].setIcon(iconAlien(imgIcon, a2));
				
				//Human with weapon 
				Human h2 = new Human("Flash", 30, 10);
				Pistol gun4 = new Pistol();
				h2.pickUpWeapon(gun4);
				e.addLifeForm(h2, 6, 6);

				imgIcon = (ImageIcon) SquareBtn[6][6].getIcon(); 
				SquareBtn[6][6].setIcon(iconHuman(imgIcon, h2));
	}
	
	/**
	 * New cell
	 * @return
	 */
	public ImageIcon createCell()
    {
		 BufferedImage cell = new 
		 BufferedImage(sizeGrid,sizeGrid,BufferedImage.TYPE_3BYTE_BGR);
		 Graphics drawer = cell.getGraphics();              	        
		 return new ImageIcon(cell);
    }
	
	/**
	 * human icon
	 * @return
	 */
	public ImageIcon iconHuman(ImageIcon icon, Human human )
    {
		BufferedImage bi = new BufferedImage(
    	icon.getIconWidth(),
    	icon.getIconHeight(),
    	BufferedImage.TYPE_3BYTE_BGR);
    	Graphics drawer = bi.getGraphics();
    	// paint the Icon to the BufferedImage.
    	icon.paintIcon(null, drawer, 0,0);
    		
    	if(human.hasWeapon())
		{
			Weapon wp = human.getWeapon();
			if(wp.getAttachmentCount() == 0)
			{
				drawer.setColor(weaponC);
				
			}else if(wp.getAttachmentCount() == 1)
			{
				drawer.setColor(weaponC1);
			}
			else if(wp.getAttachmentCount() == 2)
			{
			    drawer.setColor(weaponC2);
			}
			
			    drawer.fillRect(20, 30, 10, 10);	
		}
    	drawer.setColor(humanC); 
    	drawer.fillOval(30, 30, 10, 10);
    		 
		 return new ImageIcon(bi);
    }
	/**
	 * alien icon
	 * @return
	 */
	public ImageIcon iconAlien(ImageIcon icon, Alien alien)
    {
		int [] vx1 = {35, 40, 30};
	    int [] vy1 = {35, 40, 40};
	    
	    BufferedImage bi = new BufferedImage(
    	icon.getIconWidth(),
    	icon.getIconHeight(),
    	BufferedImage.TYPE_3BYTE_BGR);
    	Graphics drawer = bi.getGraphics();
    	// paint the Icon to the BufferedImage.
    	icon.paintIcon(null, drawer, 0,0);
        //set the fill color to white
		Polygon myTri = new Polygon(vx1, vy1, 3);
			
		if(alien.hasWeapon())
		{
			Weapon wp = alien.getWeapon();
			
			if(wp.getAttachmentCount() == 0)
			{
				drawer.setColor(weaponC);
			}else if(wp.getAttachmentCount() == 1)
			{
				drawer.setColor(weaponC1);
			}
			else if(wp.getAttachmentCount() == 2)
			{
				drawer.setColor(weaponC2);
			}
			    drawer.fillRect(20, 35, 10, 10);
		}
		drawer.setColor(alienC);
		drawer.drawPolygon(myTri);
		drawer.fillPolygon(myTri);
		        
		return new ImageIcon(bi); 
    }
	public ImageIcon iconWeaponOne(ImageIcon icon, int attachment )
    {
		BufferedImage bi = new BufferedImage(
    		icon.getIconWidth(),
    		icon.getIconHeight(),
    		BufferedImage.TYPE_3BYTE_BGR);
    		Graphics drawer = bi.getGraphics();

    		icon.paintIcon(null, drawer, 0,0);

    		if(attachment == 0)
    		{
    			drawer.setColor(weaponC);
    		}else if(attachment == 1)
    		{
    			drawer.setColor(weaponC1);
    		}else if(attachment == 2)
    		{
    			drawer.setColor(weaponC2);
    		}
    		 drawer.fillRect(0, 0, 10, 10);	       
		     return new ImageIcon(bi);
    }
	
	public ImageIcon iconWeaponTwo(ImageIcon icon, int attachment )
    {
		BufferedImage bi = new BufferedImage(
    	    icon.getIconWidth(),
    		icon.getIconHeight(),
    		BufferedImage.TYPE_3BYTE_BGR);
    		Graphics drawer = bi.getGraphics();
    		icon.paintIcon(null, drawer, 0,0);
    	
    		if(attachment == 0)
    		{
    			drawer.setColor(weaponC);
    		}else if(attachment == 1)
    		{
    			drawer.setColor(weaponC1);
    		}else if(attachment == 2)
    		{
    			drawer.setColor(weaponC2);
    		}
    		 drawer.fillRect(sizeGrid-10, 0, 10, 10);
    		 drawer.setColor(plasmaC);
    		 drawer.fillRect(sizeGrid-10, 0, 5, 5);      
		 return new ImageIcon(bi); 
    }

	/**
	 * Main
	 * @param args
	 * @throws MyNewException 
	 */
	public static void main(String[] args) throws MyNewException
	{
		GUI gui = new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		String TextStats = null;
		String message = event.getActionCommand(); 
		if(message.contains("pos: "))
		{			
			Scanner s = new Scanner(message); 
			s.next(); //"pos: "
			rowFromMap = s.nextInt(); 
			colFromMap = s.nextInt();
			
			LifeForm life = e.getLifeForm(rowFromMap, colFromMap);
			Weapon wp = e.getWeapon(rowFromMap, colFromMap);

			if(life != null)
			{
				TextStats = "<html>"
						  +"LifeForm Name:  "+ life.getName() +" <br>"
						  +"Type OF LIFE: "+ life +"<br>"
						  +"Life points: "+ life.getCurrentLifePoints() +"<br>";
				if(life.hasWeapon())
				{
					TextStats+= "Weapon: "+life.getWeapon() +"<br>" ;

				}else
				{
					TextStats+= "Weapon: NOT WEAPON<br>" ;
				}
					  
			}else if(wp != null)
			{
				TextStats = "<html>"
						+ "Weapon: <br>"+wp.getClass()+"<br>"
						+ "Ammo: "+wp.getActualAmmo()+"<br>" 
						+ "Rate of fire: "+wp.getRateOfFire()+"<br>"
						+ "</html>";
				System.out.println(wp);
			}
			lblStats.setText(TextStats);
		}
	}
}