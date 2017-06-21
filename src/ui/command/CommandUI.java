package ui.command;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CommandUI
{
	//JPanels used in command ui
	private JPanel mainPanel;
	private JPanel westPanel;
	private JPanel eastPanel;
	//buttons used in westPanel for direction change
	private JButton north, south, east, west;
	//buttons used in eastPanel for actions
	private JButton move, attack, reload, pickup1, pickup2, drop;
	
	public CommandUI()
	{
		mainPanel = new JPanel(new BorderLayout());
		westPanel = new JPanel(new BorderLayout());
		eastPanel = new JPanel(new GridLayout(2,3));
		
		buildWestPanel();
		buildEastPanel();
		mainPanel.add("West", westPanel);
		mainPanel.add("East", eastPanel);
		
	}
	
	/**
	 * builds components of westPanel and adds them to the panel
	 */
	private void buildWestPanel()
	{
		north = new JButton("N");
		south = new JButton("S");
		east = new JButton("E");
		west = new JButton("W");
		westPanel.add("North", north);
		westPanel.add("South", south);
		westPanel.add("West", west);
		westPanel.add("East", east);
	}
	/**
	 * builds components of eastPanel and adds them to the panel
	 */
	private void buildEastPanel()
	{
		move = new JButton("MOVE");
		attack = new JButton("ATTACK");
		reload = new JButton("RELOAD");
		pickup1 = new JButton("PICK UP 1");
		pickup2 = new JButton("PICK UP 2");
		drop = new JButton("DROP");
		
		eastPanel.add(move);
		eastPanel.add(attack);
		eastPanel.add(reload);
		eastPanel.add(pickup1);
		eastPanel.add(pickup2);
		eastPanel.add(drop);
	}
	/**
	 * gets the mainPanel and returns it.
	 * @return main JPanel for Command UI
	 */
	public JPanel getPanel()
	{
		// TODO Auto-generated method stub
		return mainPanel;
	}

}
