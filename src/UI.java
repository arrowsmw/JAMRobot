import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Rectangle;

import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.Timer;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Choice;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;





public class UI {

	private JFrame frmRobot;
	private JTextField RockX;
	private JTextField RockY;
	private JTextField WaterX;
	private JTextField WaterY;
	private JTextField WorldX;
	private JTextField WorldY;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {			//Program Start. Creates and instance of GUI UI and sets it visible.
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmRobot.setVisible(true);
					Data.initialize();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {								//Main method for the GUI.
		
		
		frmRobot = new JFrame();
		frmRobot.setTitle("JAM Agent Robot");
		frmRobot.setSize(new Dimension(1000, 600));
		frmRobot.getContentPane().setLayout(null);
		JButton SetWorldBounds = new JButton("Set Bounds");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 412, 246, 104);
		frmRobot.getContentPane().add(scrollPane);
		JPanel Grid;
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setTabSize(6);
		textArea.setColumns(1);
		textArea.setEditable(false);
		textArea.setRows(6);
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		
		JLabel lblEnterRockX = new JLabel("Enter Rock X Position:");
		lblEnterRockX.setBounds(10, 111, 105, 14);
		lblEnterRockX.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmRobot.getContentPane().add(lblEnterRockX);
		
		RockX = new JTextField();
		RockX.setBounds(116, 108, 40, 20);
		frmRobot.getContentPane().add(RockX);
		RockX.setColumns(10);
		
		JLabel lblEnterRockY = new JLabel("Enter Rock Y Position: ");
		lblEnterRockY.setBounds(10, 136, 108, 14);
		lblEnterRockY.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmRobot.getContentPane().add(lblEnterRockY);
		
		RockY = new JTextField();
		RockY.setBounds(116, 133, 40, 20);
		frmRobot.getContentPane().add(RockY);
		RockY.setColumns(10);
		
		
		
		JLabel lblRockWithoutWater = new JLabel("Rock Without Water");
		lblRockWithoutWater.setBounds(10, 83, 140, 17);
		lblRockWithoutWater.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmRobot.getContentPane().add(lblRockWithoutWater);
		
		JLabel lblNewLabel = new JLabel("Rock With Water");
		lblNewLabel.setBounds(10, 156, 116, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmRobot.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterRockX_1 = new JLabel("Enter Rock X Position:");
		lblEnterRockX_1.setBounds(10, 187, 105, 14);
		lblEnterRockX_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmRobot.getContentPane().add(lblEnterRockX_1);
		
		WaterX = new JTextField();
		WaterX.setBounds(116, 184, 40, 20);
		frmRobot.getContentPane().add(WaterX);
		WaterX.setColumns(10);
		
		JLabel lblEnterRockY_1 = new JLabel("Enter Rock Y Position:");
		lblEnterRockY_1.setBounds(10, 212, 105, 14);
		lblEnterRockY_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmRobot.getContentPane().add(lblEnterRockY_1);
		
		WaterY = new JTextField();
		WaterY.setBounds(116, 209, 40, 20);
		frmRobot.getContentPane().add(WaterY);
		WaterY.setColumns(10);
		
		
		
		
		JLabel lblWorldBorder = new JLabel("World Border");
		lblWorldBorder.setBounds(10, 10, 93, 17);
		lblWorldBorder.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmRobot.getContentPane().add(lblWorldBorder);
		
		JLabel lblEnterWorldBorder = new JLabel("Enter World X Bound:\r\n");
		lblEnterWorldBorder.setBounds(10, 33, 103, 14);
		lblEnterWorldBorder.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmRobot.getContentPane().add(lblEnterWorldBorder);
		
		JLabel lblEnterWorldBorder_1 = new JLabel("Enter World Y Bound:\r\n");
		lblEnterWorldBorder_1.setBounds(10, 58, 103, 14);
		lblEnterWorldBorder_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmRobot.getContentPane().add(lblEnterWorldBorder_1);
		
		
		SetWorldBounds.setHorizontalAlignment(SwingConstants.LEFT);
		SetWorldBounds.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmRobot.getContentPane().add(SetWorldBounds);
		
		JButton GridSearch = new JButton("Begin Grid Search");	//Begins First Jam Method.
		GridSearch.setBounds(10, 347, 246, 25);
		GridSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Main main = new Main();							//Jam agent creating in a second thread to allow the GUI to update at the same time.
				main.jam();
			}
		});
		GridSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmRobot.getContentPane().add(GridSearch);
		
		
		
		

		Grid = new JPanel()										//JPanel for the grid.
		{
			
			int columns=0;
			int rows=0;
			int startX=0;
			int startY=0;
			int endX=0;
			int endY=0;
			int width = 0;
			int height = 0;
				
				@Override
				public void paintComponent(Graphics g)			//This is called with repaint. 
				{								
					super.paintComponent(g);					//Draw methods are ordered to ensure correct overlaping.
					
					eraseGrid(g);
					paintGrid(g);
					paintRobot(g);
					drawRocks(g);
					foundRock(g);
				}
				
				
				
				public void setXandY()					//Sets up grid data.
				{
					 columns = Data.World_Border[0];
					 rows = Data.World_Border[1];
					 width = Math.abs(columns*(630/columns));
					 height = Math.abs(rows*(480/rows));
					 startX = 30+((630-width)/2);
					 startY = 20+((480-height)/2);
					 endX = 660-((630-width)/2);
					 endY = 500-((480-height)/2);
				}
				
				public void eraseGrid(Graphics g)				//Wipes the previous grids to prevent a messy screen.
				{
					setXandY();
					g.setColor(getBackground());
					g.fillRect(startX, startY, endX-startX, endY-startY);
				}
				
				public void paintGrid(Graphics g)				//Paints the grid according to the world border size.
				{
					setXandY();
					
					
					g.setColor(Color.WHITE);
					g.fillRect(startX, startY, endX-startX, endY-startY);			//Fills the background of the grid.
					
					g.setColor(Color.BLACK);
					g.drawRect(startX, startY, endX-startX, endY-startY);
					for(int i=columns; i>0; i--)
					{
						for(int j=rows; j>0; j--)
						{
							g.drawLine(startX-5, startY+Math.abs((j*(480/rows))), endX, startY+Math.abs((j*(480/rows))));			//Sets up the grid lines.
							g.drawString(String.valueOf(j), startX-20, (endY+5)-(Math.abs(j*(480/rows))));							//Adds the numbering for the grid.
						
						}
						g.drawLine(startX+Math.abs(i*(630/columns)), startY, startX+Math.abs(i*(630/columns)), endY+5);
						g.drawString(String.valueOf(i), startX-5+(Math.abs(i*(630/columns))),endY+20);
					}
				}
				
				public void paintRobot(Graphics g)				//Draws the robot as a red dot.
				{
					int robotX = Data.Robot_Pos[0];
					int robotY = Data.Robot_Pos[1];
					g.setColor(Color.RED);
					g.fillOval(startX+(Math.abs((robotX)*(630/columns))-((630/columns)/4)), endY-(Math.abs((robotY)*(480/rows))+((480/columns)/3)), (630/columns)/2, (630/columns)/2);
				}	//Dot is alligned to fit on the cross section of the grid axis.
				
				public void drawRocks(Graphics g)		//Draws all the rocks in the array. A maximum of 20.
				{
					setXandY();
					for(int i=0; i<Data.count; i++)
					{
						
						if((Data.rockPos[i][0] != -1 && Data.rockPos[i][1] != -1))
						{
							g.setColor(Color.BLACK);
							int rockX = Data.rockPos[i][0];
							int rockY = Data.rockPos[i][1];
							g.fillOval(startX+(Math.abs((rockX)*(630/columns))-((630/columns)/8)), endY-(Math.abs((rockY)*(480/rows))+((480/columns)/8)), (630/columns)/4, (630/columns)/4);
						
						}
					}
				}
				
				public void foundRock(Graphics g)			//Draw the water rock being carried by the robot.
				{
					if((Data.foundX >0 || Data.foundY > 0))
					{
						setXandY();
						g.setColor(Color.CYAN);
						Data.foundX = Data.Robot_Pos[0];
						Data.foundY = Data.Robot_Pos[1];
						int rockX = Data.foundX;
						int rockY = Data.foundY;
						g.fillOval(startX+(Math.abs((rockX)*(630/columns))-((630/columns)/8)), endY-(Math.abs((rockY)*(480/rows))+((480/columns)/8)), (630/columns)/4, (630/columns)/4);
					}
				}
				
		};
		
		
		Grid.setBounds(270, 20, 700, 600);
		frmRobot.getContentPane().add(Grid);
		
		int delay = 1;
		ActionListener taskPerformer = new ActionListener()		//Repeating timer to refresh the screen 
		{
			public void actionPerformed(ActionEvent e)
			{
				if(Data.oldText != Data.text)					//Prints passed text to the screen and scrolls the text area.
				{
					Data.oldText = Data.text;
					textArea.append(Data.text);
					
					Grid.repaint();								//Repaints the grid.
				}
				
			}
		};
		new Timer(delay, taskPerformer).start();			
		
		//JButton VisionSearch = new JButton("Begin Vision Search");			//Begins the second method. NOT IMPLEMENTED.
		//VisionSearch.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//		
        //        Grid.repaint();
		//		
		//	}
		//});
		//VisionSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		//VisionSearch.setBounds(10, 383, 246, 23);
		//frmRobot.getContentPane().add(VisionSearch);
		
		JLabel lblMethods = new JLabel("Methods:");
		lblMethods.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMethods.setBounds(10, 319, 65, 17);
		frmRobot.getContentPane().add(lblMethods);
		
		
		
		JLabel SpeedLabel = new JLabel("Speed: 100");
		SpeedLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		SpeedLabel.setBounds(10, 237, 93, 17);
		frmRobot.getContentPane().add(SpeedLabel);
		
		JSlider SpeedSlider = new JSlider();						//Sets up the slider for the speed variable.
		SpeedSlider.setValue(100);
		SpeedSlider.setMaximum(200);
		SpeedSlider.setMajorTickSpacing(50);
		SpeedSlider.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent e) 				//Sets the speed label to be the value shown on the slider.
			{
				SpeedLabel.setText("Speed: " + SpeedSlider.getValue());
			}
		});
		SpeedSlider.setBounds(0, 263, 256, 45);
		frmRobot.getContentPane().add(SpeedSlider);
		SpeedSlider.setPaintTicks(true);
		SpeedSlider.setPaintLabels(true);
		SpeedSlider.setMinorTickSpacing(25);
		
		
		WorldX = new JTextField();
		WorldX.setBounds(116, 30, 40, 20);
		frmRobot.getContentPane().add(WorldX);
		WorldX.setColumns(10);
		
		WorldY = new JTextField();
		WorldY.setBounds(116, 55, 40, 20);
		frmRobot.getContentPane().add(WorldY);
		WorldY.setColumns(10);
		
		
		SetWorldBounds.setBounds(166, 30, 90, 45);
		SetWorldBounds.setForeground(new Color(0, 0, 0));
		SetWorldBounds.addActionListener(new ActionListener() 				//Sets the world bounds to the value entered. 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Data.World_Border[0] = Integer.parseInt(WorldX.getText());
				Data.World_Border[1] = Integer.parseInt(WorldY.getText());
				textArea.append("World width set to: " + WorldX.getText() + ".\n");
				textArea.append("World height set to: " + WorldY.getText() + ".\n");
				WorldX.setText("");
				WorldY.setText("");
				
				Grid.repaint();
				
				
			}
		});
		
		SpeedSlider.addMouseListener(new MouseAdapter() 				//Sets the speed to the value shown when mouse is released.
		{
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				if(SpeedSlider.getValue() == 0)
				{
					Data.speed = 1;
				}
				else
				{
					Data.speed = SpeedSlider.getValue();
					textArea.append("Speed is now: " + SpeedSlider.getValue() + ".\n");
				}
				
			}
		});
                
                JButton Reset = new JButton("Reset");					//Resets the main variables involved in the grid and repaints.
		Reset.setFont(new Font("Tahoma", Font.BOLD, 14));
		Reset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				for(int i=0; i<Data.count; i++)
				{
					Data.rockPos[i][0] = -1;
					Data.rockPos[i][1] = -1;
					
				}
				
				Data.count = 0;
				
				for(int i=0; i<Data.waterCount; i++)
				{
					Data.waterRockPos[i][0] = -1;
					Data.waterRockPos[i][1] = -1;
				}
				
				Data.waterCount = 0;
				
				Data.World_Border[0] = 1;
				Data.World_Border[1] = 1;
                                
                Grid.repaint();
			}
		});
		Reset.setBounds(10, 527, 246, 23);
		frmRobot.getContentPane().add(Reset);
                
                JButton AddWaterRock = new JButton("Add Rock");					
		AddWaterRock.setBounds(166, 184, 90, 45);
		AddWaterRock.addActionListener(new ActionListener() 			//Adds a water rock and a regular rock at the location entered.
		{
			public void actionPerformed(ActionEvent e) 
			{
				int x = Integer.parseInt(WaterX.getText());
				int y = Integer.parseInt(WaterY.getText());
				
				Data.addRock(x, y);
				Data.addWaterRock(x, y);
				textArea.append("Rock with water added at (" + x + "," + y + ").\n");
				WaterX.setText("");
				WaterY.setText("");
                Grid.repaint();
			}
		});
                AddWaterRock.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmRobot.getContentPane().add(AddWaterRock);							//Ads
             
		
		
		
		
        JButton AddRock = new JButton("Add Rock");								//Add rock button.
		AddRock.setBounds(166, 108, 90, 45);									//Takes input from RockX and RockY.
		AddRock.setFont(new Font("Tahoma", Font.PLAIN, 11));					//Passes the integers to Data.addrock to add the rock to the array. 
		AddRock.addActionListener(new ActionListener() 							//Triggers repaint so rock is visible.
		{
			public void actionPerformed(ActionEvent e) 
			{
				Data.addRock(Integer.parseInt(RockX.getText()),Integer.parseInt(RockY.getText()));
				textArea.append("Rock added at (" + RockX.getText() + "," + RockY.getText() + ").\n");
				RockX.setText("");
				RockY.setText("");
                Grid.repaint();
			}
		});
		frmRobot.getContentPane().add(AddRock);
		
		
	}
	
	
}	
	

