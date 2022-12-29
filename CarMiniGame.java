import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class CarMiniGame  {

	//declaring variables and initializing it where needed
	
	private ImageIcon car, road, cone, stop, brokenCar; //used for storing images
	private int xCar, yCar, speed, round; 
	public Rectangle2D carMask, BrokencarMask; //creating rectangular masks
	public Ellipse2D coneMask, cone2Mask,cone3Mask,cone4Mask,cone5Mask, stopMask, stop2Mask, stop3Mask, stop4Mask, stop5Mask; //creating masks
	private boolean carWin; 
	public boolean lostCar; 

 
	//constructor	
	public  CarMiniGame()
	{	
		// initializing integer and boolean variables
		round = 0; 
		speed = 10; 
		xCar = 0; 
		yCar = 150; 
		carWin=false;
		lostCar=false; 
		 
		//images 
		car = new ImageIcon("car.png");
		road = new ImageIcon("road.png");
		cone = new ImageIcon("cone.png"); 
		stop = new ImageIcon("stop.png");
		brokenCar = new ImageIcon("BrokenCare.png");
		
		
		//masks for all the objects 
		carMask = new Rectangle2D.Double(xCar, yCar, car.getIconWidth(), car.getIconHeight());

		coneMask = new Ellipse2D.Double(900, 120, cone.getIconWidth(), cone.getIconHeight());
		cone2Mask = new Ellipse2D.Double(1100, 220, cone.getIconWidth(), cone.getIconHeight());
		cone3Mask = new Ellipse2D.Double(900, 170, cone.getIconWidth(), cone.getIconHeight());
		cone4Mask = new Ellipse2D.Double(250, 200, cone.getIconWidth(), cone.getIconHeight());
		cone5Mask = new Ellipse2D.Double(500, 20, cone.getIconWidth(), cone.getIconHeight());
		
		stopMask = new Ellipse2D.Double(800, 120, stop.getIconWidth(), stop.getIconHeight());
		stop2Mask = new Ellipse2D.Double(400, 150, stop.getIconWidth(), stop.getIconHeight());
		stop3Mask = new Ellipse2D.Double(1000, 30, stop.getIconWidth(), stop.getIconHeight());
		stop4Mask = new Ellipse2D.Double(200, 70, stop.getIconWidth(), stop.getIconHeight());
		stop5Mask = new Ellipse2D.Double(700, 150, stop.getIconWidth(), stop.getIconHeight());

		
	}

	
	//moves the car up 
	public void up()
	{
		//checking to see if the car touches the top of the screen

			if (yCar<=0)
			{
				// stopping it to prevent the car from going out of the screen

				yCar-=0; 
			}
			else 
			{
				//otherwise moving it up at a speed of 10
				yCar -=10;
			}
	}
	
	//moves the car down 
	public void down()
	{
		//checking to see if the car touches the bottom of the screen

			if (yCar+car.getIconHeight()>260)
			{
				// stopping it to prevent the car from going out of the screen

				yCar += 0; 
			}
			else 
			{
				//otherwise moving it down at a speed of 10

				yCar +=10; 
			}
	}
		
	//moves the car to the right
	public void MoveCar()	
	{
		//moving the car right at the speed specified
			xCar += speed; 
			
			//creating the BrokencarMask of the car according to the new coordinates 
			carMask = new Rectangle2D.Double(xCar, yCar, car.getIconWidth(), car.getIconHeight());
		
			// if the car moves out of the screen (indicating the user was able to cross level 1)
			if (xCar + car.getIconWidth() >= 1200)
			{
				//create the mask of the car
				carMask = new Rectangle2D.Double(xCar, yCar, car.getIconWidth(), car.getIconHeight());
				
				//set the x-position and increase the number of round
				xCar = 0 - car.getIconWidth(); 
				round++;	
			}	
			
			// if the user is on the second round, then speed is 15
			if (round ==1)
			{
				speed = 15; 
			}
	}
	
	//checks if the car has crashed or if it has done 2 rounds
	public boolean crash()
	{
		//set lostCar to false if it hasn't crashed
		lostCar = false; 
		
		//checking if the car intersects with any of the obstacles 
		if (coneMask.intersects(carMask) || cone2Mask.intersects(carMask) || cone3Mask.intersects(carMask) || cone4Mask.intersects(carMask)|| cone5Mask.intersects(carMask)
				|| stopMask.intersects(carMask)||  stop2Mask.intersects(carMask)|| stop3Mask.intersects(carMask)	|| stop4Mask.intersects(carMask)|| stop5Mask.intersects(carMask))
		{
			
			//reset the values and set lostCar to true indicating the car crashed
				carWin = false; 
				lostCar = true; 
				xCar = 0; 
				yCar = 150; 
				speed = 10; 
				round = 0; 
		}
		
		//return the value of lostCar
		return lostCar; 
	}
	
	//check to see if the user won
	public boolean carWin()
	{
		carWin = false; 
		
		// if round is 2 then reset the variables to their starting values
		if (round==2)
		{
			lostCar = false; 
			xCar = 0; 
			yCar = 150; 
			carWin = true; 
			speed = 10; 
			round = 0; 
		}
		
		//return the value of carWin
		return carWin; 
	}
	
	public void draw(Graphics2D g2)
	{
		//dracarWing background
		g2.drawImage(road.getImage(), -100, -10, null); 
		
		//dracarWing a BrokencarMask around the car 
		carMask = new Rectangle2D.Double(xCar, yCar, car.getIconWidth(), car.getIconHeight());
		
		//dracarWing the car 
		g2.drawImage(car.getImage(), xCar, yCar, null) ; 
		
		// if its the first round
		if (round ==0)
		{		
			//dracarWing the cones
			g2.drawImage(cone.getImage(), 900, 120, null); 
			g2.drawImage(cone.getImage(), 1100, 220, null); 
			g2.drawImage(cone.getImage(), 900, 170, null);
			g2.drawImage(cone.getImage(), 250, 200, null);
			g2.drawImage(cone.getImage(), 500, 20, null);
		
			//dracarWing the other obstacle
			g2.drawImage(stop.getImage(), 800, 120, null);
			g2.drawImage(stop.getImage(), 400, 150, null);
			g2.drawImage(stop.getImage(), 1000, 30, null);
			g2.drawImage(stop.getImage(), 200, 70, null);
			g2.drawImage(stop.getImage(), 700, 150, null);
			
			//creating the masks of all the obstacles
			coneMask = new Ellipse2D.Double(900, 120, cone.getIconWidth(), cone.getIconHeight());
			cone2Mask = new Ellipse2D.Double(1100, 220, cone.getIconWidth(), cone.getIconHeight());
			cone3Mask = new Ellipse2D.Double(900, 170, cone.getIconWidth(), cone.getIconHeight());
			cone4Mask = new Ellipse2D.Double(250, 200, cone.getIconWidth(), cone.getIconHeight());
			cone5Mask = new Ellipse2D.Double(500, 20, cone.getIconWidth(), cone.getIconHeight());
			
			stopMask = new Ellipse2D.Double(800, 120, stop.getIconWidth(), stop.getIconHeight());
			stop2Mask = new Ellipse2D.Double(400, 150, stop.getIconWidth(), stop.getIconHeight());
			stop3Mask = new Ellipse2D.Double(1000, 30, stop.getIconWidth(), stop.getIconHeight());
			stop4Mask = new Ellipse2D.Double(200, 70, stop.getIconWidth(), stop.getIconHeight());
			stop5Mask = new Ellipse2D.Double(700, 150, stop.getIconWidth(), stop.getIconHeight());
			
			BrokencarMask = new Rectangle2D.Double(-10, 400 , stop.getIconWidth(), stop.getIconHeight());
		}
		
		//changing the positions of the obstacles if its the second round
		else if (round ==1)
		{
			
			
			//drawing the cones
			g2.drawImage(cone.getImage(), 250, 200, null);
			g2.drawImage(cone.getImage(), 250, 150, null); 
			g2.drawImage(cone.getImage(), 259, 85, null); 
			g2.drawImage(cone.getImage(), 750, 150, null);	
			g2.drawImage(cone.getImage(), 750, 90, null);
		
			//drawing the other obstacle
			g2.drawImage(stop.getImage(), 500, 20, null);
			g2.drawImage(stop.getImage(), 580, 20, null);
			g2.drawImage(stop.getImage(), 1000, 25, null);
			g2.drawImage(stop.getImage(), 550, 200, null);
			g2.drawImage(stop.getImage(), 1100, 25, null);
			g2.drawImage(brokenCar.getImage(),900  ,100, null);
			
			//creating the masks
			coneMask = new Ellipse2D.Double(250, 200, cone.getIconWidth(), cone.getIconHeight());
			cone2Mask = new Ellipse2D.Double(250, 150, cone.getIconWidth(), cone.getIconHeight());
			cone3Mask = new Ellipse2D.Double(259, 85, cone.getIconWidth(), cone.getIconHeight());
			cone4Mask = new Ellipse2D.Double(750, 150, cone.getIconWidth(), cone.getIconHeight());
			cone5Mask = new Ellipse2D.Double(750, 90, cone.getIconWidth(), cone.getIconHeight());
			
			stopMask = new Ellipse2D.Double(500, 20, stop.getIconWidth(), stop.getIconHeight());
			stop2Mask = new Ellipse2D.Double(580, 20, stop.getIconWidth(), stop.getIconHeight());
			stop3Mask = new Ellipse2D.Double(1000, 25, stop.getIconWidth(), stop.getIconHeight());
			stop4Mask = new Ellipse2D.Double(500, 200, stop.getIconWidth(), stop.getIconHeight());
			stop5Mask = new Ellipse2D.Double(1100, 25, stop.getIconWidth(), stop.getIconHeight());
			
			BrokencarMask = new Rectangle2D.Double(900, 100, stop.getIconWidth(), stop.getIconHeight());
		}
		
		
		
	}	
	
}

