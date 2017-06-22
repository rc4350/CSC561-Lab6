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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import environment.Environment;
import exceptions.MyNewException;
import lifeform.Alien;
import lifeform.LifeForm;
import weapon.Pistol;

import javax.swing.JLabel;

public class GUI extends JFrame implements ActionListener {

	private JPanel map, legend;
	JButton[][] SquareBtn;
	
	private static Environment e; 
	
	static final int rows = 8; 
    static final int cols = 8;
    int sizeGrid = 70;
    int sizeWeapon = 10;
    int sizeAttachment = 10;
    
    Color humanC = new Color(0,255,0);
    Color alienC = new Color(0,128,255);
    Color weaponC = new Color(255, 204, 204); // weapon without attachments
    Color weaponC1 = new Color(255, 102, 102); // weapon with 1 attachment
    Color weaponC2 = new Color(255, 0, 0); // weapon with 2 attachment

	/**
	 * Create the frame.
	 * @throws MyNewException 
	 */
	public GUI() throws MyNewException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 840, 640);
		setTitle("Aliens vs Humans");

		e.initialize(rows, cols);
		
		/**
		 * Map
		 */
		map = new JPanel();
		map.setLayout(new BorderLayout());
		map = new JPanel(new GridLayout(rows, cols));
		map.setPreferredSize(new Dimension(rows, cols));
		//Adding buttons in Jpanel Map
		SquareBtn = new JButton[rows][cols];
		for(int i = 0; i < rows; i ++)
		{
			for(int j = 0; j < cols; j++)
			{
				SquareBtn[i][j] = new JButton(createCell());
				SquareBtn[i][j].setBackground(Color.BLACK);
				SquareBtn[i][j].setActionCommand("cell: "+i+" "+j);
				SquareBtn[i][j].addActionListener(this);
				map.add(SquareBtn[i][j]);
			}
		}
		getContentPane().add("Center",map);
		
		/**
		 * Legend
		 */
		legend = new JPanel();
		GridLayout gl_legend = new GridLayout();
		gl_legend.setColumns(1);
		gl_legend.setRows(0);
		legend.setLayout(gl_legend);
		legend.setPreferredSize(new Dimension(200, 600)); 
		getContentPane().add("East",legend);
		
		JLabel lblLegend = new JLabel("LEGEND");
		legend.add(lblLegend);
		setVisible(true);
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
	public ImageIcon iconHuman()
    {
		 BufferedImage human = new 
		 BufferedImage(sizeGrid,sizeGrid,BufferedImage.TYPE_3BYTE_BGR);
		 Graphics drawer = human.getGraphics();
		                
		 drawer.setColor(humanC);
		 drawer.fillOval(30, 30, 10, 10);      
		 return new ImageIcon(human);
    }
	
	/**
	 * alien icon
	 * @return
	 */
	public ImageIcon iconAlien(LifeForm Alien)
    {
		int [] vx1 = {35, 40, 30};
	    int [] vy1 = {35, 40, 40};
	    
		BufferedImage alien = new 
		BufferedImage(sizeGrid,sizeGrid,BufferedImage.TYPE_3BYTE_BGR);
		Graphics drawer = alien.getGraphics();
		 
		Polygon myTri = new Polygon(vx1, vy1, 3);
			
		drawer.setColor(alienC);
		drawer.drawPolygon(myTri);
		drawer.fillPolygon(myTri);       
		return new ImageIcon(alien);
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
	public void actionPerformed(ActionEvent e) {	
	}
}