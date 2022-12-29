import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class BouncingBallGame 
{
	// declaring variables and Masks
	private int  ballxDir, ballyDir;	
	public int ballxPos, ballyPos, paddleX, paddleY;
	private final int  FRAME_WIDTH, FRAME_HEIGHT;		//creating constants
	private ImageIcon background, ball, paddle;		//used for storing the images
	private Rectangle2D paddleMask;		//creating masks
	private Ellipse2D ballMask;		//creating masks
	public boolean lostBall;  
	
	// creating the constructor
	public BouncingBallGame()
	{
		// initializing the values of the variables
		ballxPos=200;	
		ballyPos=100;
		ballxDir=11;
		ballyDir=13;
		paddleX = 400; 
		paddleY = 420; 
		lostBall = false; 
		FRAME_WIDTH=800;
		FRAME_HEIGHT=500;
		
		// creating the backgrounds
		background= new ImageIcon ("ballbackground.jpg");
		ball= new ImageIcon ("Ball.png");
		paddle= new ImageIcon ("paddle.png");
		
		//creating the masks of the ball and the paddle
		ballMask= new Ellipse2D.Double(ballxPos,ballyPos,ball.getIconWidth(),ball.getIconHeight());
		paddleMask= new Rectangle2D.Double(paddleX,paddleY, paddle.getIconWidth(), paddle.getIconHeight());
	}
	

	// method move 
	public void move()
	{
		// moves the ball vertically up and horizontally right according to the specified values of ballxDir and ballyDir
		ballxPos += ballxDir; 
		ballyPos += ballyDir; 
		
		//checking to see if the ball touches the left of the screen
		if ((ballxPos-10)<=0)
		{
			// reversing the direction if it does to prevent the ball from going out of the screen
			ballxDir=-ballxDir;
		}
		
		//checking to see if the ball touches the right of the screen
		else if (ballxPos+ball.getIconWidth()>=FRAME_WIDTH)
		{
			// reversing the direction if it does to prevent the ball from going out of the screen

			ballxDir=-ballxDir;
		}
		
		//checking to see if the ball touches the top of the screen
		else if ((ballyPos-10)<=0)
		{
			// reversing the direction if it does to prevent the ball from going out of the screen

			ballyDir=-ballyDir;
			ballyPos+=2;
		}
		
		// creating the mask of the ball according to the new coordinates as it moves across the screen
		ballMask= new Ellipse2D.Double(ballxPos,ballyPos, ball.getIconWidth(), ball.getIconHeight());
		
	}
	
	// method intersection
	public void intersection()
	{
		//checking to see if the ball intersects the paddle
		if (ballMask.intersects(paddleMask))
		{
			//reversing its direction to give a bouncing effect
			ballyDir=-ballyDir;
			ballyPos-=2;
		}
	}
	
	//method lostBall
	public boolean lost()
	{
		//initial value of lostBall is false
		lostBall = false; 
		
		// if the ball touches the bottom of the screen
		if ((ballyPos+28)+ball.getIconHeight()>=FRAME_HEIGHT)
		{
			//changing the value of the variable lostBall to true indicating that the player lostBall as the ball touched the bottom of the screen
			lostBall = true; 
			
			//resetting the x and y coordinates of the ball and paddle
			ballxPos= 100; //rand.nextInt(500)+150; 
			ballyPos= 50;
			
			paddleX=400;
			paddleY=420;
		}
		
		// returning the variable lostBall 
		return lostBall; 
	}

	// method for moving the paddle right
	public void PaddleRight()
	{
		// checking to see if it touches the right side of the screen
		if (( paddleX+25)+paddle.getIconWidth() >=FRAME_WIDTH)
		{
			// stopping the paddle if it does to prevent it from going outside the screen
			paddleX+=0;
		}
		
		else
		{
			// else moving the paddle right towards at a speed of 16
			paddleX+=20; 
		}
		
		//creating the mask according to the new position of the paddle as it moves
		paddleMask= new Rectangle2D.Double(paddleX, paddleY, paddle.getIconWidth(), paddle.getIconHeight());
	}
	
	// method for moving the paddle left
	public void PaddleLeft()
	{
		// checking to see if it touches the left side of the screen
		if ((paddleX-10)<=0)
		{
			// stopping the paddle if it does to prevent it from going outside the screen
			paddleX-=0;
		}
		else
		{
			// else moving the paddle left towards at a speed of 16
			paddleX-=19;
		}
		
		//creating the mask according to the new position of the paddle as it moves

		paddleMask= new Rectangle2D.Double(paddleX, paddleY, paddle.getIconWidth(), paddle.getIconHeight());

	}
	
	public void draw(Graphics2D g2)
	{
		// creating the background and creating the image of the ball and the paddle
		g2.drawImage(background.getImage(),0,0,null);
		g2.drawImage(ball.getImage(), ballxPos,ballyPos,null);
		g2.drawImage(paddle.getImage(), paddleX, paddleY, null);
	}
	
	
}
