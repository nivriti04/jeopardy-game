import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RoboPower 
{
	// Declaring global variables, the JFRAME, the timers and the Rectangle2D boxes.
	private int xPlayer, yPlayer, xFire, yFire, FRAME_HEIGHT, FRAME_WIDTH, roboX, roboY;
	public int roboseconds;	//making them public so that they can also be accessible from the main class
	private ImageIcon Robot, player,gun;	//Storing the images
	public boolean isFired, inRoom;		//used for the gun shot
	private Ellipse2D fireMask;		//creating masks
	private Rectangle2D roboMask;	//creating masks 
	private Font f;		//setting font
	Random rand; 	
	public int robocount; 	//making these integer values accessible from main class

	public RoboPower()
	{
		//setting the x and y firePos of the player
		xPlayer = 100; 
		yPlayer = 250; 

		
		//robocount variable for how many robots are killed
		robocount = 0; 
		
		//x and y positions of the robot
		roboX = 0; 
		roboY = 0; 
		
		//x and y firePos of the fire. making it at the posiiton of the player
		xFire = xPlayer; 
		yFire = yPlayer;
		
		//height and width of the frame
		FRAME_HEIGHT = 500;
		FRAME_WIDTH = 800; 
		
		isFired = false; 
		inRoom = false; 
		
		//total roboseconds the game runs for 
		roboseconds = 30; 
		
		//images of robots, player and the fire 
		Robot = new ImageIcon("iRobot.png"); 
		player  = new ImageIcon("PlayerRight.png");
		gun = new ImageIcon("gun.png");
	
		//creating a variable to call a random class
		rand = new Random(); 
		
		//creating a mask for the robot and the fire 
		roboMask = new Rectangle2D.Double(roboX, roboY, Robot.getIconWidth(), Robot.getIconHeight());
		fireMask = new Ellipse2D.Double(xFire, yFire, gun.getIconWidth(), gun.getIconHeight());
		
	}
	
	//runs when the user presses the UP key 
	public void Up()
	{
		//checking if the player hits the top of the room and not moving it 
		if (yPlayer<=0)
		{
			yPlayer -=0; 
		}
		//moving the player up 
		else 
		{
			yPlayer-=10; 
		}

	}
	
	//runs when the user presses the DOWN key 
	public void Down()
	{
		//checking if the player hits the bottom of the room and not moving it
		if (((yPlayer+40)+player.getIconHeight())>=FRAME_HEIGHT)
		{	
			yPlayer+=0;  
		}	
		//moving the player down
		else 
		{
			yPlayer+=10; 
		}
	}
	
	//called for the initial firePos of the fire 
	public void firePos()
	{
		yFire = yPlayer+5; 
	}
	
	//called when the user presses SPACE key
	public void shoot()
	{		
			//setting them to true indicating that there is a fire instance in the room
			isFired = true; 
			inRoom = true; 
		
			//moving the fire to the right
			xFire+=80; 
		
			//if the fire goes outside the frame moving the fire 
			if (xFire>FRAME_WIDTH)
			{
				//setting the variable to false as the fire is outside now
				isFired = false; 
				inRoom = false; 
				
				//setting the x value of the fire to be that of the player 
				xFire = xPlayer;
			}
			else 
			{
				//if it isn't outside the frame
				inRoom = true; 
			}
			
	}
	
	//creating a random coordinate for the robots to spawn
		public void RoboSpawn()
		{	
			//generating robots at random positions when roboseconds is divisible by 3. If not then 
			//keeping them in the previous position
			if (roboseconds%3==0)
			{
				roboX = rand.nextInt(500)+250; 
				roboY = rand.nextInt(250)+100;
			}
		}
	
	
	public void collision()
	{
		//checking if the robot collides with the fire 
		if (fireMask.intersects(roboMask))
		{
			//moving the robot and the fire outside the room
			roboY = -50; 
			xFire = 1000; 
			
			//adding to the # of robots killed 
			robocount++; 
		}
	}

	
	public void draw(Graphics2D g2)
		{			
			//drawing the image of the player
			g2.drawImage(player.getImage(),xPlayer,yPlayer,null);
		
			//set the font and display the roboseconds robocount at the bottom of the screen
			f=new Font("BRITTANIC BOLD",Font.BOLD,20);
			
			//displaying how many seconds are remaining and how many robots they have killed already
			g2.setFont(f);
			g2.setColor(Color.WHITE);
			g2.drawString("Seconds remaining:" ,10,450);
			g2.drawString(Integer.toString(roboseconds), 220,450);
		
			g2.drawString("Robots Killed:" ,550,450);
			g2.drawString(Integer.toString(robocount), 700,450);
			
			// if the variables are true implying the user pressed the space key
			if (isFired==true && inRoom==true)
			{
				// draw the image of the fire at the specified coordinates
				g2.drawImage(gun.getImage(),xFire,yFire,null);
				
				fireMask = new Ellipse2D.Double(xFire, yFire, gun.getIconWidth(), gun.getIconHeight());
				
			}
			
		//calling the robospawn to generate fast moving robots only till the time the value of roboseconds is less than/equal to 0 and the robocount doesn't
		//equal to 6
		if (roboseconds>0 && robocount!=6)
		{
			RoboSpawn(); 
		}
			
			//drawing the robot and the mask
			g2.drawImage(Robot.getImage(), roboX, roboY, null);
			roboMask = new Rectangle2D.Double(roboX, roboY, Robot.getIconWidth(), Robot.getIconHeight());
		}
				
}