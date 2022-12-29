/* PROGRAM DESCRIPTION: The program mirrors the real-world Jeopardy game with some twists. As soon as the game begins, the user is shown the intro background
 * with the instructions to either press enter to start playing or press the i key to access the instructions . If the user presses i, a JOptionPane
 * appears asking the user for their name and once they enter it, another JOptionpane appears that contains the instructions. The user is then taken back to 
 * the start screen where they can then press enter to start the game or access the instructions again. If the user presses the enter key next, the user is 
 * taken to another JOptionPane that displays 3 categories that they can choose from and a quit button. The three main categories all lead to another 
 * JOptionPane that asks them how many points they want to play for. The first category is that of Netflix where the user can select their points (100, 200 or
 * 300). Each set of points contain 3 questions stored in an array and a random number is generated from 0-2. Based on the number generated, the question in 
 * that index of the array is asked to the user. As soon as the question is displayed, a 30 second timer begins and they only have those 30 seconds to answer
 * the question. If the answer is correct, they get the respective value of points and if not, their score doesn't change. In both circumstances they are 
 * shown their current score, a message of either Congratulations or losing and are taken back to the category JOptionPane where they can choose to play from
 * any of the 3 categories listed or quit with the help of the quit button. Next listed is the travel category which works in the same way as the Netflix 
 * category for 100 and 200 points. However, under Travel, the 300 points category has been made to reflect daily double. The user is shown a JOption Pane 
 * indicating that they have reached daily double and asked for the number of points that they like to bet for. The question is being displayed and the answer
 * Timer starts as soon as the user is done selecting their points that they want to bet for. The user can only enter in an integer value and they are shown
 * an error pane if they enter an invalid input/ leave it blank and are taken back to the pane again where they can choose their points that they want to bet.
 * The score increases or decreases by the points they bet depending upon whether their answer was correct or not. The twist is that they can only play the 
 * daily double once. If they try to access it again, they will be asked a random question and only 300 points will be given which is what the points category
 * is for.The next category listed is mini games. There are 3 different games each corresponding to either 100, 200 or 300 points. Under the 100 
 * points, is a bouncing ball game. The aim of the game is to prevent the ball from hitting the bottom of the screen with the help of the paddle as it bounces
 * off of the paddle. The player can move the paddle right and left with the respective arrow keys. As soon as the ball touches the bottom of the screen, the 
 * game ends and the user doesn't get the 100 points, is told the current score and is taken back to the category option. However, if the user survives the 20
 * seconds, they get a winning message and get the points! The user is then taken back to the categories option again. Under the 200 points option is a robot 
 * game in which the user has 30 seconds to kill 6 robots. The robots randomly spawn around the room however they try to move all across the screen before 
 * selecting a position to confuse the player so they have to be careful. The player also cannot spam the space key and keep shooting. The user can only move
 * up and down using the arrow keys and cannot move towards the robots. The user has to use the space bar to shoot fireballs at the robots and kill them. As 
 * soon as the user kills 6 robots, they are shown a congratulations message and their score with added 200 points. If the time ends the user is shown the 
 * number of robots they killed and their score stays the same. Under the 300 points option, there is a mini car racing game. There are two levels in the game
 * and the car can only move up and down using the respective arrow keys. There are a lot of obstacles on the track and the user has to navigate his/her way 
 * around the obstacles and reach the end. Once the user reaches the end, the second level begins where the speed of the car is faster and the goal is again 
 * to reach the end without crashing into any obstacles. If the user is able to do it, the score increases by 300, they are shown their current score, 
 * a congratulations message and taken back to the categories option and if not, they are told the current score and are taken back to selecting the 
 * categories as well. This is how the game works and the user has a total of minutes to score as many points as they can. Once the 5 minutes are over, a
 * message shows that the game is over and that they can't play any longer, they are shown their final score and the game exits. At any point of time, if they
 * click the quit button under the categories option, they are shown a confirmation pane as to whether they really want to exit. If they click yes, they are 
 * shown their final score and the game exits however if they click no, they are taken back to selecting a category again. The same happens if they click on 
 * the red cross at the top right corner of the category JOptionPane or the one where they select the points.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jeopardize extends JPanel implements  ActionListener, KeyListener
{
	//creating fields(Global variables)
	public JFrame frame;    
	public static int choice=3, option=0, choicepoints=5;		
	private String[] Netflix100, Netflix100ans, Netflix200, Netflix200ans, Netflix300, Netflix300ans, Travel100, Travel200, Travel300, Travel100ans, Travel200ans, Travel300ans; 
	private int randomnum, score, seconds, jeopardySecCount, ballseconds, dailydoublefinal;
	private String dailydouble, name;
	private Font font,f, fontball;
	private static String answer; 
	
	//these are used for animating objects 
	private Timer ansTimer, carMove, fireTimer, jeopardyTimer, BallTimer, BallgameTimer, robogameTimer; 
	private boolean  enterchecker, checkcarpane, checkrobopane, checkballpane, postercheck, ddcheck, valid, ddscore, instructionchecker; 
	
	// these are used for storing images
	private ImageIcon questionbackground, Robobackground, dailyDouble, ballinst, carinst, roboinst, pointsIcon, quit, error, categoryIcon, 
	thanks, answerIcon, congrats, lose, scoreimg, startbackground, nameimg, timeup, instrimg;
	
	//creating objects that point to their respective classes
	RoboPower robogame= new RoboPower();
	CarMiniGame carGame = new CarMiniGame(); 
	BouncingBallGame ballgame= new BouncingBallGame();	
	
	JOptionPane pane = new JOptionPane();
	
	//constructor
	public Jeopardize()
	{
		
		postercheck=true;
		
		//JFrame setup 
		frame = new JFrame(); 
		frame.setVisible(true);
		frame.setContentPane(this); 
		frame.setSize(437, 612);
		frame.setTitle("FINAL JEOPARDY 2021");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);


		//JPanel setup 
		setLayout(null); 
		setBackground(Color.WHITE); 

		addKeyListener(this); 
		setFocusable(true); 
		requestFocus(); 
		
		//setting the backgrounds and images in the answer panes
		questionbackground = new ImageIcon("background.jpg");
		Robobackground= new ImageIcon("Robobackground.jpg");
		ballinst= new ImageIcon("ball.gif");
		carinst= new ImageIcon ("ferrari.png");
		roboinst= new ImageIcon ("playerRight.png");
		pointsIcon = new ImageIcon("points.png"); 
		quit= new ImageIcon ("quit.png");
		error= new ImageIcon ("error.png");
		categoryIcon = new ImageIcon ("category.png");
		thanks= new ImageIcon("Thanks.jpg");
		answerIcon = new ImageIcon("answer.png"); 
		congrats= new ImageIcon ("congrats.jpg");
		lose= new ImageIcon ("lose.png");
		scoreimg= new ImageIcon ("score.png");
		dailyDouble = new ImageIcon("dailyDouble.png"); 
		instrimg= new ImageIcon("nameimg.png");
		timeup= new ImageIcon ("timeUp.png");
		nameimg= new ImageIcon("nameimage.png");
		
		//initializing strings
		dailydouble = "1"; 
		name="";
			
		//setting the value of all the boolean variables
		
		enterchecker=false;
		checkcarpane=true;
		checkrobopane=true;
		checkballpane=true;
		ddcheck=true;
		ddscore=true;
		valid=true;	
		instructionchecker=true;
				
		// initializing the length of the question and answer arrays
		Netflix100= new String[3];
		Netflix200 = new String[3]; 
		Netflix300 = new String[3];

		Netflix100ans= new String[3];
		Netflix200ans = new String[3]; 
		Netflix300ans= new String[3];
		
		Travel100= new String[3];
		Travel200 = new String[3]; 
		Travel300 = new String[3];

		Travel100ans= new String[3];
		Travel200ans = new String[3]; 
		Travel300ans= new String[3];

		
		//setting the values of the question and answer arrays

		Netflix100[0] = "WHEN 2020 ENDED, WHAT SHOW WAS NOT    \"THERE FOR YOU\" ON NETFLIX ANYMORE?";
		Netflix100[1] = "WHAT IS A CW SERIES THAT FOCUSES ON   SMALL TOWN MYSTERIES AND FEATURED ARCHIE IN THE ORIGINAL COMIC?";
		Netflix100[2] = "WHAT SHOW (ABOUT DETECTIVES) WAS SAVED    BY FANS AFTER AN OUTCRY ON SOCIAL MEDIA?";

		Netflix100ans[0]="FRIENDS";
		Netflix100ans[1]="RIVERDALE";
		Netflix100ans[2]="BROOKLYN 99";

		Netflix200[0]= "SHE WRITES LETTERS TO 5 DIFFERENT GUYS IN \"TO ALL THE BOYS I HAVE EVER LOVED BEFORE\". WHO IS SHE?";
		Netflix200[1]="BORED WITH BEING LORD OF HELL, HE     RELOCATES TO LOS ANGELES, WHERE HE OPENS A NIGHTCLUB";
		Netflix200[2]="EIGHT THIEVES TAKE HOSTAGES AND       LOCK THEMSELVES IN THE ROYAL MINT OF SPAIN";

		Netflix200ans[0]="LARA JEAN";
		Netflix200ans[1]="LUCIFER";
		Netflix200ans[2]="MONEY HEIST";

		Netflix300[0]="WHAT SHOW IS BASED ON A COMIC BOOK    AND PORTRAYS LIFE AFTER A ZOMBIE APOCALYPSE?";
		Netflix300[1]="WHAT IS A TIMELESS CLASSIC SHOW ABOUT A STRONG BOND BETWEEN THE MOTHER AND DAUGHTER?";
		Netflix300[2]="WHO IS THE FOUNDER OF NETFLIX?      							";

		Netflix300ans[0]="THE WALKING DEAD";
		Netflix300ans[1]="GILMORE GIRLS";
		Netflix300ans[2]="REED HASTINGS";
		
		Travel100[0]= "WHICH IS THE ONLY CONTINENT NOT TO HAVE ANTS?                      ";
		Travel100[1]= "NAME ITALY'S MOST POPULAR FROZEN DESERT                                     ";
		Travel100[2]= "WHICH LANDMARK IS LOCATED ON THE SOUTH BANK   OF THE YAMUNA RIVER IN THE CITY OF AGRA?";
		
		Travel100ans[0]= "Antarctica";
		Travel100ans[1]= "Gelato";
		Travel100ans[2]="Taj Mahal";
		
		Travel200[0]="NAME THE CAPITAL CITY OF DOMINICAN REPUBLIC                  ";
		Travel200[1]="FANS OF THIS MOVIE SERIES CAN TOUR THE LONDON LOCALES USED IN THE FILMING INCLUDING THE ONE SEEN HERE";
		Travel200[2]= "A SNOWMAN NAMED BONHOMME IS THE OFFICIAL      REPRESENTATIVE OF THIS CANADIAN CITY'S WINTER CARNIVAL";
		
		Travel200ans[0]="Santo Domnigo";
		Travel200ans[1]= "Harry Potter";
		Travel200ans[2]="Quebec City";
		
		Travel300[0]="ANNE HATHAWAY'S COTTAGE IN THIS BRITISH TOWN  FEATURES A BUTTERFLY TRAIL & A FLORAL GARDEN";
		Travel300[1]="WHILE IN REGINA SASKATCHEWAN, VISIT THE       CENTENNIAL MUSEUM OF THIS LAW ENFORCEMENT GROUP";
		Travel300[2]= "BUILDINGS IN THIS BERMUDAN CAPITAL ARE OFTEN  PAINTED IN PASTELS & THE ROOFS ARE MADE OF CORAL";
		
		Travel300ans[0]="Stratford";
		Travel300ans[1]="The Mounties";
		Travel300ans[2]="Hamilton";
		
		//setting the value of all integer variables
		randomnum=0;
		score=0;
		seconds = 30;
		ballseconds=20;
		dailydoublefinal=-1;
		jeopardySecCount=0;
		
		//setting the fonts
		f = new Font("Britanic Bold", Font.PLAIN, 96);
		fontball= new Font ("Brittanic Bold", Font.PLAIN, 45);
		
		//setting the timers
		fireTimer= new Timer(100, this);
		robogameTimer= new Timer(1000, this);
		carMove = new Timer(100, this); 
		ansTimer = new Timer(1000, this);
		jeopardyTimer= new Timer(1000, this);
		BallTimer= new Timer(50, this);
		BallgameTimer= new Timer(1000, this);
	}

	public static void main(String[] args)
	{
		//calling on the main constructor
		new Jeopardize();	
	}

	public void keyPressed(KeyEvent f)
	{
		// if the user presses the enter key
			if(f.getKeyCode() == KeyEvent.VK_ENTER)
			{
				//set postercheck to false (this variable is used to make sure that the poster is being drawn only till the time the user doesn't press the enter key)
				postercheck=false;
				
				// check to see if enterchecker is false (this is to make sure that pressing enter will take the user to selecting the categories only once so that in case the user presses enter by mistake during the game, he/she is not taken back to the categories option)
				if (enterchecker==false)
				{
					//start the timer of the full game
					jeopardyTimer.start();
					
					// go to the method category
					category();
				}
			}
			
			// checking to see if the user pressed i letter
			if (f.getKeyCode()==KeyEvent.VK_I)
			{
				if (instructionchecker==true)
				{
				// creating a for loop that will only run once
				for (int i=0; i<1;i++)
				{
					//setting the frame visibility to false and displaying the instructions
					
					frame.setVisible(false);	
					name= (String) JOptionPane.showInputDialog(null, "We are delighted to have you! Please enter your name", "NAME", JOptionPane.PLAIN_MESSAGE, nameimg, null, null);
					
					//checking to see if they didn't enter their name or pressed the cross button
					if (name==null || name==" ")
					{
						//calling them user instead of by their name and printing the instructions
						JOptionPane.showMessageDialog(null, "Hey user !! \n\nHere are the Instructions for you: \nOnce you press the enter key to start the game, you will be taken to a window that displays 3 categories that you can \nchoose from and a quit button. The three main categories all lead to another window that asks you how many points you want \nto play for. The first category is that of Netflix where you can select your points (100, 200 or 300). As soon as you are \ndone selecting the points you want to play for, the question will be displayed, a 30 second timer begins and you only have \nthose 30 seconds to answer the question. If the answer is correct, you get the respective value of points and if not, your \nscore doesn't change. You will be taken back to the category window where you can choose your category again. Next listed is \nthe travel category which works in the same way as the Netflix category. The next category listed is mini games. There are \n3 different games each corresponding to either 100, 200 or 300 points. The instructions for those games will be displayed \nonce you choose to play any of them!\n\nKeep in mind you only have 5 minutes so you have to try to maximize your score in these 5 minutes and once the \ntime's up, you will be shown your final score and the game will close. \n\nThere is also a daily double chance hidden in one of the categories under one of the points options where you can choose how \nmany points you want to bet for. If you are successful, you get those points however if not, you will lose the \nsame number of points. You can only access it once and once you have used it that points option will only give you \nthe respective points. \n\nGood luck!!! ", "Instructions",JOptionPane.PLAIN_MESSAGE, instrimg);
						
					}
					
					// if they enter in their name
					else
					{
						//calling them by their name and printing the instructions
						JOptionPane.showMessageDialog(null, "Hey " + name + " !! \n\nHere are the Instructions for you: \nOnce you press the enter key to start the game, you will be taken to a window that displays 3 categories that you can \nchoose from and a quit button. The three main categories all lead to another window that asks you how many points you want \nto play for. The first category is that of Netflix where you can select your points (100, 200 or 300). As soon as you are \ndone selecting the points you want to play for, the question will be displayed, a 30 second timer begins and you only have \nthose 30 seconds to answer the question. If the answer is correct, you get the respective value of points and if not, your \nscore doesn't change. You will be taken back to the category window where you can choose your category again. Next listed is \nthe travel category which works in the same way as the Netflix category. The next category listed is mini games. There are \n3 different games each corresponding to either 100, 200 or 300 points. The instructions for those games will be displayed \nonce you choose to play any of them!\n\nKeep in mind you only have 5 minutes so you have to try to maximize your score in these 5 minutes and once the \ntime's up, you will be shown your final score and the game will close. \n\nThere is also a daily double chance hidden in one of the categories under one of the points options where you can choose how \nmany points you want to bet for. If you are successful, you get those points however if not, you will lose the \nsame number of points. You can only access it once and once you have used it that points option will only give you \nthe respective points. \n\nGood luck!!! ", "Instructions", JOptionPane.PLAIN_MESSAGE, instrimg);
					}
				}
				
				//setting postercheck to true so that it can be drawn again, setting the frame size and visibility 
				postercheck=true;
				frame.setSize(437,612);
				frame.setVisible(true);
				
				//setting enterchecker to true so that the user can still press enter and go to the categories option
				enterchecker=false;
				
				
			}
			}
			
		//checking if up key is pressed 
		else if (f.getKeyCode() == KeyEvent.VK_UP)
		{
			// if the user selected to play for 200 points under mini games
			if (choice==2 && choicepoints==1)
			{
				//call on the setYup method from the RoboPower class (which contains the code for moving the player up)
				robogame.Up();
					
			}
					
		// if the user selected to play for 300 points under mini games
			else if (choice==2 && choicepoints==2 )
			{
				// call on the up method from the CarMiniGame class (which contains the code for moving the car up)
				carGame.up(); 
						
			}
					//repaint the Frame to avoid images being drawn repeatedly
					repaint();
		}
		
		// if the user pressed the down arrow
		else if (f.getKeyCode()==KeyEvent.VK_DOWN)
			{
				// if the user selected to play for 200 points under mini games
				if (choice==2 && choicepoints==1)
				{
					//call on the setYdown method from the RoboPower class (which contains the code for moving the player down)

					robogame.Down();
				}
				
				// if the user selected to play for 300 points under mini games
				else if (choice==2 && choicepoints==2 )
				{
					// call on the down method from the CarMiniGame class (which contains the code for moving the car down)

					carGame.down(); 
				}
				//repaint the Frame to avoid images being drawn repeatedly
				repaint();
			}
		
		// if the user pressed the left key
		else if (f.getKeyCode()==KeyEvent.VK_LEFT)
			{
				
				// if the user selected to play for 100 points under mini games
				 if (choice == 2 && choicepoints==0)
				{
					//call on the PaddleLeft method from the Bouncingball class (which contains the code for moving the Paddle left)

					ballgame.PaddleLeft();
				}
				//repaint the Frame to avoid images being drawn repeatedly
				repaint();
				
			}
		
		// if the user pressed the right key
		else if (f.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				// if the user selected to play for 100 points under mini games
				if (choice == 2 && choicepoints==0)
				{
					//call on the PaddleRight method from the Bouncingball class (which contains the code for moving the Paddle right)

					ballgame.PaddleRight();
				}
				//repaint the Frame to avoid images being drawn repeatedly
				repaint();
			}
		
		// if the user pressed the space key
		else if (f.getKeyCode()==KeyEvent.VK_SPACE)
			{
				// if the user selected to play for 200 points under mini games
				if (choice==2 && choicepoints==1)
				{
					// start the fireTimer and go to the shoot method from the RoboPower class
					fireTimer.start(); 
					robogame.firePos(); 
				}
				//repaint the Frame to avoid images being drawn repeatedly
				repaint();
			}
				
	}
		
	public void keyReleased (KeyEvent e) {}
	public void keyTyped (KeyEvent e) {}

	//checks for the timers 
	public void actionPerformed(ActionEvent e)
	{
		//checking if the answer timer is the one that's working
		if (e.getSource() == ansTimer)
		{	
			
			//decreasing the seconds (initialized to 30) each second by 1  (It is the total time they have to answer the question)
			seconds --;    
			
			// if seconds elapse
			if (seconds==0)
			{
				//stop the timer, show that they couldn't answer
				ansTimer.stop();
				
				//set answer to null
				answer = null;
				
				// dispose of the answer pane 
				 if (answer == null)
					{
					 	pane.getRootFrame().dispose();	  
					    answer="";
					}
				 
				// show that the time is over, their current score and take them back to the category method
				JOptionPane.showMessageDialog(null, "The time is over! You could not answer.", "Time over", JOptionPane.INFORMATION_MESSAGE, timeup);
				JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.OK_OPTION, scoreimg);
				//category();
			}
			
				//repaint the frame to avoid seconds being drawn on top of each other
				repaint();
			
		}
		
		// if the fire timer is started (when space key is presses)
		else if (e.getSource()== fireTimer)
		{	
			//caling the shoot method which moves the fireball to the right 
			robogame.shoot();
			
			//calling the collision method which checks if the fireball collided with any of the robots. 
			robogame.collision(); 
			
			//if the fireball goes out of the room stopping its timer
			if (robogame.inRoom == false)
			{
				fireTimer.stop(); 
			}
			
			//repainting the frame
			repaint();
		}
		
		// if the Robot game timer is working 
		else if (e.getSource()==robogameTimer)
		{
			//reducing the seconds in the game 
			robogame.roboseconds--;		
			
			//if the user has killed 6 robots 
			if (robogame.robocount == 6)
			{
				//stopping the game timer
				robogameTimer.stop();
				
				//adding 200 to their total score 
				score=score+200;
				
				//telling the user they won and showing them their score 
				JOptionPane.showMessageDialog(null, "Congrats you killed 6 robots and got 200 points. " ,"WON", JOptionPane.PLAIN_MESSAGE, congrats);
				JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
				
				//resetting the variables and calling the category method to start again
				seconds = 30;   
				robogame.robocount = 0; 
				category();
			}
			
			// else if the player was unable to kill 6 robots and the time elapses
			else if (robogame.roboseconds==0 && robogame.robocount!=6)
			{
			
				//stop the game timer and the robot Move timer
				robogameTimer.stop();
				
				//show them a message of lost and their current score
				JOptionPane.showMessageDialog(null, "Sorry you only killed " + robogame.robocount+" robot(s)" ,"LOST", JOptionPane.PLAIN_MESSAGE, lose);
				JOptionPane.showMessageDialog(null, "Your current score is " + score, "SCORE", JOptionPane.PLAIN_MESSAGE, scoreimg);
				
				//reset the variables and calling upon the category method
				seconds = 30; 
				robogame.robocount = 0; 
				category();
			}
			
			
			// repaint the Frame
			repaint();
		}
		
		
		// if the carMove timer is the one that's working
		else if (e.getSource() == carMove)
		{
			// call upon the MoveCar method (which automatically moves the car to the right and checks to see if it was able to pass round 1)
			carGame.MoveCar();	
			
			// if the value of the boolean method crash is true
			if (carGame.crash() == true)
			{
				// stop the car from moving by stopping its timer
				carMove.stop();
				
				//show to the user that they lost, show the current score and take them back to the categories option
				JOptionPane.showMessageDialog(null, "The car crashed! You Lost", "LOST", JOptionPane.PLAIN_MESSAGE, lose);
				JOptionPane.showMessageDialog(null,"Your current score is " + score, "SCORE", JOptionPane.PLAIN_MESSAGE, scoreimg);
				category(); 
				
				//change its value to false so that it resets if the the user chooses to play again
				carGame.lostCar = false; 
	
			}
			
			// if the value of the boolean method win is true
			else if (carGame.carWin()==true)
			{
				// stop the car by stopping its timer
				carMove.stop();
				
				// show that they won, increase their score by 300 and show their current score
				JOptionPane.showMessageDialog(null, "Yay! You finished without crashing and won 300 points!", "WON", JOptionPane.PLAIN_MESSAGE, congrats );
				score=score+300;
				JOptionPane.showMessageDialog(null,"Your current score is " + score, "SCORE",  JOptionPane.PLAIN_MESSAGE, scoreimg);
				
				//call upon the category method
				category(); 
			}
			
			// repaint the Frame
			repaint();
		}
		
		
		// if the Jeopardy Timer is the one that's working (this keeps track of how much time has elapsed since the user started playing)
		else if (e.getSource()==jeopardyTimer)
		{
			// increase the value by 1 each second
			jeopardySecCount++;	
			
			// once 300 seconds (5 minutes) have passed
			if (jeopardySecCount==300)
			{
				//stop all the timer so the game so that no matter where they are, everything stops
				BallTimer.stop();
				BallgameTimer.stop();
				carMove.stop();
			
				robogameTimer.stop();
				jeopardyTimer.stop();
				fireTimer.stop();
				ansTimer.stop();
		
				
				// show them their current score and tell them that they can't play any longer
				JOptionPane.showMessageDialog(null, "Time's UP!!! Can't play any more! Your final score was " + score, "Time's UP", JOptionPane.PLAIN_MESSAGE, timeup);
				
				//exit the game
				System.exit(0);
			}
			
			//repaint 
			repaint();
		}
		
		// if the ballTimer is working (which makes the ball move)
		if (e.getSource()==BallTimer)
		{
			
			//call upon the move method and the intersection method from the Bouncing Ball class  (which contain the code for moving the ball and checking to see if it intersects with the paddle)
			ballgame.move();
			ballgame.intersection();
			
			// if the value of the lost variable is true
			if(ballgame.lost()==true)
			{
				// stop the timer of the game so that the seconds don't keep on decreasing and stop the ball from moving as well by stopping its timer
				BallgameTimer.stop();
				BallTimer.stop();
				
				// show that they lost and display their current score and call upon the method category
				JOptionPane.showMessageDialog(null, "You lost! The ball touched the ground!", "LOST",  JOptionPane.PLAIN_MESSAGE, lose);
				JOptionPane.showMessageDialog(null, "Your current score is " + score, "SCORE", JOptionPane.PLAIN_MESSAGE, scoreimg);
				category(); 
				
				//reset the value of the variable to false so that the loop doesn't run immediately again if the user chooses to play again
				ballgame.lostBall=false; 
			}
				
			//repaint
			repaint();
		}
		
		// if the BallGameTimer is running
		if (e.getSource()==BallgameTimer)
		{
			
			//decrease the value of ballseconds by 1 each second (which is initialized to 20 as they have to survive in the game for 20 seconds)
			ballseconds--;	
			
			// if the seconds have elapsed
			if (ballseconds==0)
			{
				//stop the ball and the timer of the game and increase the score by 100
				BallTimer.stop();
				BallgameTimer.stop();
				score=score+100;
				
				//show that they were successful and show their current score 
				JOptionPane.showMessageDialog(null,"Great Job! You were able to save the ball from touching the floor and got 100 points", "WON",  JOptionPane.PLAIN_MESSAGE, congrats);
				JOptionPane.showMessageDialog(null, "Your current score is " + score, "SCORE", JOptionPane.PLAIN_MESSAGE, scoreimg);
				
				//resetting the ball's and the paddle's x and y values
				ballgame.ballxPos=450;
				ballgame.ballyPos=50;
				ballgame.paddleX=400;
				ballgame.paddleY=420;
				
				//call upon the category method
				category();
			}
			
			//repaint
			repaint();
		
		}
	}

	
	//calling upon the method category which asks the user for the category they wanna play and for how many points
	public void category()
	{
		
		//setting instructionchecker to false so that the user doesn't access the instructions again if they press i by mistake during the program
		instructionchecker=false;
		
		//set the visibility of the frame to false so that we can only see the JOptionPanes
		frame.setVisible(false);
		
		//personalizing the options and storing them in an array
		String [] buttons= {"Netflix", "Travel", "Mini Games","Quit"};

		// keep prompting the user for an input 
		do
		{
			//storing their choice of category in the variable choice
			choice = JOptionPane.showOptionDialog(null, "Choose a category to play:", "FINAL JEOPARDY",JOptionPane.INFORMATION_MESSAGE, 0, categoryIcon, buttons, null);
			
			
			// if the user clicks the quit option
			if (choice!=0 && choice!=1 && choice!=2)
			{
				// ask for confirmation to quit
				option= JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Quit",JOptionPane.YES_NO_OPTION, 0, quit);

				// if the user selects yes
				if (option==JOptionPane.YES_OPTION)                                                                           
				{
					//stop the game timer and show thank you for playing message
					jeopardyTimer.stop();
					JOptionPane.showMessageDialog(null,"Thank you for playing! Your final score was " + score, "Thank You", 0, thanks);
					//exit the game 
					System.exit(0);
				}
			}
		
		}
		//keep asking till the time they keep pressing quit
		while (choice!=0 && choice!=1 && choice!=2);
		

		// keep prompting the user for an input 
		do 
		{
		//checking if any other option is chosen other than quit
			if (choice==0||choice==1 || choice==2)
			{
			// personalizing the options available
			String[] points= {"100", "200","300"};

			//storing their option selected in the variable choicepoints
			choicepoints = JOptionPane.showOptionDialog(null, "How many points would you like to play for?", "FINAL JEOPARDY",JOptionPane.INFORMATION_MESSAGE, 0, pointsIcon, points , null);			
		
			// if they press the cross button
			if (choicepoints!=0 && choicepoints!=1 && choicepoints!=2)
			{
				// ask for confirmation to quit
				option= JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Quit",JOptionPane.YES_NO_OPTION, 0, quit);

				// if the user selects yes
				if (option==JOptionPane.YES_OPTION)
				{
					// stop the game timer and show them thank you for playing
					jeopardyTimer.stop();
					JOptionPane.showMessageDialog(null,"Thank you for playing! Your final score was " + score,"Exit", JOptionPane.PLAIN_MESSAGE, thanks);
					
					//exit the game  
					System.exit(0);
				}
			}
			}
		// do this till the time they don't select a value of points to play for; this is done so that in case the user presses the red cross at the top, it doesn't show us an error
		} while (choicepoints!=0 && choicepoints!=1 && choicepoints!=2);
		
		
		//generating a random number between 0 and 2 and using this number to generate a question for the travel and netflix category stored in that index
		randomnum = (int) (Math.random()*3);
			
		//calling on the method level which creates the frame
		level();	
		
		// if the user selected 300 points under the travel category
		if (choice==1 && choicepoints==2)
			{
			//reset the seconds to 30 every time so that each time the user plays again and the dailydoublefinal is reset as well
			seconds=30;
			dailydoublefinal = -1; 
			
			// ddcheck is used to ensure that they can only access daily double once and if they enter the category again, then a random question is asked and only 300 points are awarded instead of the points chosen to be bet for by the user
			// while its set to true
			
			if (ddcheck==true)
			{
				
				//setting valid to true and running the while loop till the time valid is true
			valid = true;
			while (valid == true)
			{
				
				//using a try-catch statement to defend against invalid input from the user
				try 
				{
					//display the JoptionPane indicating that they have reached daily double and asking for how many points they want to bet for
					dailydouble = (String) JOptionPane.showInputDialog(null, "Congrats you got the daily double!!\n\n\nBet an amount! (Max of 9 digits)", "DAILY DOUBLE",
							JOptionPane.DEFAULT_OPTION, dailyDouble, null, "300" );
					
					// if the user doesn't enter anything or press the cancel button
					if (dailydouble==null || dailydouble==" ")
					{
						// show an error message and ask for an input again
						
						JOptionPane.showMessageDialog(null, "Error!! The value must be an integer", "ERROR",JOptionPane.PLAIN_MESSAGE, error);
						
						dailydouble = (String) JOptionPane.showInputDialog(null, "Congrats you got the daily double!!\n\n\nBet an amount! (Max of 9 digits)", "DAILY DOUBLE",
								JOptionPane.DEFAULT_OPTION, dailyDouble, null, "300" );
					}
					
					//as dailydouble is a string variable, here we parse the data and store it into another variable as an integer
					dailydoublefinal = Integer.parseInt(dailydouble); 
					
					// if dailydoublefinal is greater than or equal to zero (indicating that the user inputted a valid input)
					if (dailydoublefinal>=0)
					{
						//set valid to false so that the while loop doesn't run again and set ddcheck to false so that daily double can no longer be accessed
						valid = false;
						ddcheck=false;
						ddscore=true;
						
						//start the answerTimer and go to the question method
						ansTimer.start(); 
						question();
					}
				}
				
				
				//catch statement checking for invalid input
				catch (Exception e)
				{
					// checking to see that the catch should only run till the time ddcheck is true
					if (ddcheck==true)
					{
						
						//show an error message if the input entered is invalid (not a number). The loop goes back to the while loop again and the suer is asked for input again
						JOptionPane.showMessageDialog(null, "Error!! The value must be an integer", "ERROR",JOptionPane.PLAIN_MESSAGE, error); 
					}	
				}		
			}
			
			} 
			
			// if ddcheck is not true implying that the user has accessed daily double once
			else
			{
				//simply start the answer timer and go to the question method
				ansTimer.start();
				question();
			}
			
		}		
	
		// if Netflix is chosen for however many points
		if (choice==0 && choicepoints==0 ||choicepoints==1|| choicepoints==2)
		{
			//set the value of seconds to 30 as this is the time they have to answer the questions from any of the points and this will also reset their value every time the user chooses to play
			seconds=30;
			ansTimer.start(); 
			question(); 
				
		}
		
		// if travel is chosen for 100 or 200 points	
		if (choice==1 && choicepoints==0 ||choicepoints==1)
			
		{
			//set the value of seconds to 30 as this is the time they have to answer the questions from any of the points and this will also reset their value every time the user chooses to play
			seconds=30;
			ansTimer.start(); 
			question(); 	
		}
		
		
		// if mini games is chosen for 100 points
		if (choice==2 && choicepoints==0 )
		{
			
			ansTimer.stop();
			
			//set the value of ball seconds to 20 as this is the time that they have to survive for
			ballseconds=20;
			
			// if the value of checkballpane is true (it is initialized to true as well)
			if (checkballpane==true)
			{
				//display the welcome message and the instructions
				JOptionPane.showMessageDialog(null,"Welcome to Bouncing Ball!! \n\nINSTRUCTIONS: \nThe aim of the game is to prevent the ball from hitting the bottom \nof the screen with the help of the paddle as it bounces off of the \npaddle. The player can move the paddle right and left with the respective \narrow keys. As soon as the ball touches the bottom of the screen, the game \nends the player doesn't get the points and is taken back to the \ncategory option. However if you survive the 20 seconds, you win \nand get the points!", "Instructions",JOptionPane.PLAIN_MESSAGE, ballinst);
				
				//change the value to false so that the message is only displayed once
				checkballpane=false;
			}
			
			//start the ballTimer which moves the ball and the game timer which starts the 20 seconds
			BallTimer.start();
			BallgameTimer.start();
			
		}
		
		//if mini games is chosen for 200 points 
		
		if (choice==2 && choicepoints==1)
		{
			//stopping the answer time in case its still running in the background
			ansTimer.stop();
			
			// if the value of checkrobopane is true (it is initialized to true as well)
			if (checkrobopane==true)
			{
				//display the welcome message and the instructions
				JOptionPane.showMessageDialog(null,"Welcome to Robo Power! \n\nINSTRUCTIONS: \nYou have 30 seconds to kill 6 robots which randomly select a position in the room. Keep in mind that they try to move all \nacross the screen to confuse you so be careful before you shoot as you can't spam the space button. You can only move up \nand down using the respective arrow keys and use the space button to shoot fireballs at the robots and kill them. As soon \nas you are done killing the 6 robots, you will be shown a congratulations message and your score will increase by 200 however \nif you fail, you score stays the same and you are taken back to selecting a category again.", "Instructions",JOptionPane.PLAIN_MESSAGE, roboinst);
				//change the value to false so that the message is only displayed once
				checkrobopane=false;
			}
			
			//set the value of the seconds to 30 as this is the time that they have to survive for and this also resets it every time the suer chooses to play for 200 points under the mini games option
			robogame.roboseconds=30;
			
			//start the robogame timer which starts the seconds count down as well as the roboMove timer which increases the value of how many robots have been killed
			robogameTimer.start();		
	
		}
		
		// if mini games is chosen for 300 points
		if (choice==2 && choicepoints==2)
		{
			ansTimer.stop();
	
			
			// check if checkcarpane is set to true (this is to make sure the instructions pane is only displayed once to the user)
				if (checkcarpane==true)
				{
					// show the instructions pane and change the value of checkcarpane to false so that the loop can't run again
					JOptionPane.showMessageDialog(null,  "WELCOME TO MINI CAR GAME: \n\nInstructions: \nThere are two levels in the game and the car can only move up and down using the respective arrow keys however it \nautomatically moves right over which you have no control. There are obstacles on the track and you have to navigate your \nway around them and reach the end. Then, the second level begins and the goal is again to reach the end without crashing \ninto any obstacles. If you are able to do it, your score increases by 300, if not, you are shown your current \nscore and taken back to selecting the categories.", "Instructions", JOptionPane.PLAIN_MESSAGE, carinst);
					checkcarpane=false;
				
				}
			//start the carMove timer which automatically starts moving the car
			carMove.start(); 
		}
		
		//change the value of enterchecker to true so that the enter key can only be used once to go to the categories option (when the game first loads) and that the jeopardy game timer also can only be started once
		enterchecker=true;
		
	}
	
	//paint method (draws stuff for us)
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g; 
		
		// checking to see if the value of posterceck is true (to make sure it only comes once as its set to false once the user presses enter)
		if (postercheck==true)
		{
			//storing the image of the background and creating the image
			startbackground = new ImageIcon ("Jeopardize.png");
			g2.drawImage(startbackground.getImage(),0,0, this);
		}
		
		// if 100 points were selected for Netflix
		if (choice==0 && choicepoints==0) 
		{
			//draw the background, set the font, display the text (which is split up using the substring method from the String class)
			g2.drawImage(questionbackground.getImage(), 0, 0, this); 
			g2.setFont(font);				
			g2.setColor(Color.WHITE);
			g2.drawString(Netflix100[randomnum].substring(0,37), 10, 100);
			g2.drawString(Netflix100[randomnum].substring(38), 10, 120);
			g2.setFont(f);
			
			//display the seconds and start the answer Timer
			g2.drawString(Integer.toString(seconds), (frame.getWidth() / 2)-50 ,400);
			
		}
		
		// if 200 points were chosen for Netflix
		else if (choice==0 && choicepoints==1)
		{
			//draw the background, set the font, display the text (which is split up using the substring method from the String class)

			g2.drawImage(questionbackground.getImage(), 0, 0, this); 
			g2.setFont(font);				
			g2.setColor(Color.WHITE);
			g2.drawString(Netflix200[randomnum].substring(0,37), 10, 100);
			g2.drawString(Netflix200[randomnum].substring(38), 10, 120);
			g2.setFont(f);
			
			//display the seconds and start the answer Timer

			g2.drawString(Integer.toString(seconds), (frame.getWidth() / 2)-50 ,400);
		}
		
		//if 300 points were chosen for Netflix
		else if (choice==0 && choicepoints==2)
		{
			//draw the background, set the font, display the text (which is split up using the substring method from the String class)

			g2.drawImage(questionbackground.getImage(), 0, 0, this); 
			g2.setFont(font);				
			g2.setColor(Color.WHITE);
			g2.drawString(Netflix300[randomnum].substring(0,37), 10, 100);
			g2.drawString(Netflix300[randomnum].substring(38), 10, 120);
			g2.setFont(f);
			
			//display the seconds and start the answer Timer

			g2.drawString(Integer.toString(seconds), (frame.getWidth() / 2)-50 ,400);
			 

		}
		
		// if travel is chosen for 100 points
		else if (choice==1 && choicepoints==0)
		{
			//draw the background, set the font, display the text (which is split up using the substring method from the String class)

			g2.drawImage(questionbackground.getImage(), 0, 0, this); 
			g2.setFont(font);				
			g2.setColor(Color.WHITE);
			g2.drawString(Travel100[randomnum].substring(0,45), 10, 100);
			g2.drawString(Travel100[randomnum].substring(46), 10, 120);
			g2.setFont(f);
			
			//display the seconds and start the answer Timer

			g2.drawString(Integer.toString(seconds), (frame.getWidth() / 2)-50 ,400);
		}
		
		// if travel is chosen for 200 points
		else if (choice==1 && choicepoints==1)
		{
			//draw the background, set the font, display the text (which is split up using the substring method from the String class)

			g2.drawImage(questionbackground.getImage(), 0, 0, this); 
			g2.setFont(font);				
			g2.setColor(Color.WHITE);
			g2.drawString(Travel200[randomnum].substring(0,45), 10, 100);
			g2.drawString(Travel200[randomnum].substring(46), 10, 120);
			g2.setFont(f);
			
			//display the seconds and start the answer Timer

			g2.drawString(Integer.toString(seconds), (frame.getWidth() / 2)-50 ,400);
		}
		
		//if travel is chosen for 300 points
		else if (choice==1 && choicepoints==2)
		{
			//draw the background, set the font, display the text (which is split up using the substring method from the String class)

			g2.drawImage(questionbackground.getImage(), 0, 0, this); 
			g2.setFont(font);				
			g2.setColor(Color.WHITE);
			g2.drawString(Travel300[randomnum].substring(0,45), 10, 100);
			g2.drawString(Travel300[randomnum].substring(46), 10, 120);
			g2.setFont(f);
			
			//display the seconds and start the answer Timer

			g2.drawString(Integer.toString(seconds), (frame.getWidth() / 2)-50 ,400);
		}
		
		// if mini games was chosen for 100 points
		else if (choice==2 && choicepoints==0)
		{
			//call upon the draw method from the Bouncing Ball class which draws the background, the ball and the paddle
			ballgame.draw(g2);	
			
			//set the font and color and display the seconds at the top of the screen
			g2.setFont(fontball);
			g2.setColor(Color.WHITE);
			g2.drawString(Integer.toString(ballseconds), 350,100);	
		}
		
		// if mini games was chosen for 200 points
		else if (choice==2 && choicepoints==1 )
		{
			//draw the background and call upon the draw method from the RoboPower class
			g2.drawImage(Robobackground.getImage(),0,0, this);
			robogame.draw(g2);
		}
		
		// if mini games was chosen for 300 points
		else if (choice==2 && choicepoints==2)
		{		
			//reset the size of the frame and centre it 
			frame.setSize(1200,300);
			frame.setLocationRelativeTo(null);
			
			// call upon the draw method from the CarMiniGame class which draws other objects
			carGame.draw(g2); 
		}

	}
	
	//method level (creates the JFrame for us)
	public void level() 
	{
		// if the user selects 100, 200 or 300 points
		if (choicepoints==0 || choicepoints==1||choicepoints==2  )
		{
			// sets the size of the new frame, its location, and visibility
			frame.setSize(800,500);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			//setting the font
			font=new Font ("Century Gothic",Font.BOLD,17);
			
			
		}
		//repainting the frame
		repaint();


	}
	
	// question method which checks how many points the user chose to play for from the category Netflix
	public void question()
	{
		// if the user chose netflix for 100 points
		if (choice==0 && choicepoints==0)
		{
			//showing the answer pane that asks for input
			answer= (String) pane.showInputDialog(null,"Enter in your answer (You only have 30 seconds)", "Answer", JOptionPane.QUESTION_MESSAGE, answerIcon, null, null);
			
			// if the user does not put anything, they are taken to the category method
				
			if (answer==null)
			{
				ansTimer.stop();
				category();
			}
				
			else
			{
				// if the answer the user put matches the correct answer
				if (answer.trim().equalsIgnoreCase(Netflix100ans[randomnum]) )
				{
					//stop the answer Timer (so that it doesn't go up till 0 and show that they lost even though they have already answered)
					ansTimer.stop();
					
					//show the congratulations message, increase the score by 100, show the current score and call upon the category method
					JOptionPane.showMessageDialog(null,"Congratulations! Your answer was correct! You got 100 points!", "Win", JOptionPane.PLAIN_MESSAGE, congrats);
					score=score+100;
					JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
						
					category();
				}
		
			// if the user's answer does not match with the correct answer
				else 
				{
					//stop the answer timer
					ansTimer.stop();
					
					 // resetting answer to equal null
					 answer="";
					
					// show a message saying they couldn't answer, their current score and call upon the category method
					JOptionPane.showMessageDialog(null,"Sorry, your answer was incorrect.", "Lose", JOptionPane.PLAIN_MESSAGE, lose);
					JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
						
					category();
				}
			}
			
			
		}
		
		// if the user chose Netflix for 200 points
		else if (choice==0 && choicepoints==1)
		{
				//showing the answer pane that asks for input

				answer= (String) pane.showInputDialog(null,"Enter in your answer (You only have 30 seconds)", "Answer", JOptionPane.QUESTION_MESSAGE, answerIcon, null, null);
			
				// if the user does not put anything, they are taken to the category method

				if (answer==null)
				{
					ansTimer.stop();
					category();
				}
				
				else
				{
				// if the answer the user put matches the correct answer
				if (answer.trim().equalsIgnoreCase(Netflix200ans[randomnum]))
				 {
					//stop the answer Timer (so that it doesn't go up till 0 and show that they lost even though they have already answered)

					 ansTimer.stop();
					 
					//show the congratulations message, increase the score by 200, show the current score and call upon the category method

					 JOptionPane.showMessageDialog(null,"Congratulations! Your answer was correct! You got 200 points!", "Win", JOptionPane.PLAIN_MESSAGE, congrats);
					 score=score+200; 
					 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
						
					 category();
				 }	
				
				// if the user's answer does not match with the correct answer

				 else
				 {
					//stop the answer timer

					 ansTimer.stop();
					 
					 // resetting answer to equal null
					 answer="";
					 
					// show a message saying they couldn't answer, their current score and call upon the category method

					 JOptionPane.showMessageDialog(null,"Sorry, your answer was incorrect.", "Lose", JOptionPane.PLAIN_MESSAGE, lose);
					 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
						
					 category();
				 }
				}
				
		}
		
		// if the user chooses Netflix for 300 points
		else if (choice==0 && choicepoints==2)
		{
			
			//showing the answer pane that asks for input
			answer= (String) pane.showInputDialog(null,"Enter in your answer (You only have 30 seconds)", "Answer", JOptionPane.QUESTION_MESSAGE, answerIcon, null, null);
			
			// if the user does not put anything, they are taken to the category method
			if (answer==null)
			{
				ansTimer.stop();
				category();
			}
			
			else
			{
			// if the answer the user put matches the correct answer
			if (answer.trim().equalsIgnoreCase(Netflix300ans[randomnum]))
			 {
				//stop the answer Timer (so that it doesn't go up till 0 and show that they lost even though they have already answered)
				 ansTimer.stop();
				 
				//show the congratulations message, increase the score by 300, show the current score and call upon the category method

				 JOptionPane.showMessageDialog(null,"Congratulations! Your answer was correct! You got 300 points!", "Win", JOptionPane.PLAIN_MESSAGE, congrats);
				 score=score+300;
				 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
					
				 category();
			 }
			
			 // if it doesn't
			 else
			 {
				//stop the answer timer

				 ansTimer.stop();
				 
				 // resetting answer to equal null
				 answer="";
				 
				// show a message saying they couldn't answer, their current score and call upon the category method
				 JOptionPane.showMessageDialog(null,"Sorry, your answer was incorrect.", "Lose", JOptionPane.PLAIN_MESSAGE, lose);
				 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
					
				 category();
			}	
			
			}
		}
		
		// if travel is chosen for 100 points
		else if (choice==1 && choicepoints==0)
		{
			
			//showing the answer pane that asks for input
			answer= (String) pane.showInputDialog(null,"Enter in your answer (You only have 30 seconds)", "Answer", JOptionPane.QUESTION_MESSAGE, answerIcon, null, null);
			
			// if the user does not put anything, they are taken to the category method
			if (answer==null)
			{
					ansTimer.stop();
					category();
			}
			
			//run these statements only is the answer does not equal null
			else
			{
				// if the answer the user put matches the correct answer
				
				if (answer.trim().equalsIgnoreCase(Travel100ans[randomnum]) )
				{
					//stop the answer Timer (so that it doesn't go up till 0 and show that they lost even though they have already answered)
					ansTimer.stop();
					
					//show the congratulations message, increase the score by 100, show the current score and call upon the category method
					JOptionPane.showMessageDialog(null,"Congratulations! Your answer was correct! You got 100 points!", "Win", JOptionPane.PLAIN_MESSAGE, congrats);
					score=score+100;
					JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
					category();
				}
		
			// if the user's answer does not match with the correct answer
				else 
				{
					//stop the answer timer
					ansTimer.stop();
					
					 // resetting answer to equal null
					 answer="";
					
					// show a message saying they couldn't answer, their current score and call upon the category method
					JOptionPane.showMessageDialog(null,"Sorry, your answer was incorrect.", "Lose", JOptionPane.PLAIN_MESSAGE, lose);
					JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
					category();
				}
			}
		}
		
		// if travel is chosen for 200
		else if (choice==1 &&  choicepoints==1)
		{
			//showing the answer pane that asks for input
			answer= (String) pane.showInputDialog(null,"Enter in your answer (You only have 30 seconds)", "Answer", JOptionPane.QUESTION_MESSAGE, answerIcon, null, null);
			
			// if the user does not put anything, they are taken to the category method

			if (answer==null)
			{
				ansTimer.stop();
				category();
			}	
		
			//run these statements only if the answer does not equal null
			else 
			{
				// if the answer the user put matches the correct answer
			if (answer.trim().equalsIgnoreCase(Travel200ans[randomnum]))
			 {
				//stop the answer Timer (so that it doesn't go up till 0 and show that they lost even though they have already answered)

				 ansTimer.stop();
				 
				//show the congratulations message, increase the score by 200, show the current score and call upon the category method

				 JOptionPane.showMessageDialog(null,"Congratulations! Your answer was correct! You got 200 points!", "Win", JOptionPane.PLAIN_MESSAGE, congrats);
				 score=score+200; 
				 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
				 category();
			 }	
			
			// if the user's answer does not match with the correct answer

			 else
			 {
				//stop the answer timer

				 ansTimer.stop();
				 	
				 // resetting answer to equal null
				 answer="";
				 
				// show a message saying they couldn't answer, their current score and call upon the category method

				 JOptionPane.showMessageDialog(null,"Sorry, your answer was incorrect. ", "Lose", JOptionPane.PLAIN_MESSAGE, lose);
				 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
					
				 category();
			 }
			
			}
		}
		
		// if the user chooses travel for 300
		else if (choice==1 &&  choicepoints==2)
		{
			// show the answer pane that asks for input
			answer= (String) pane.showInputDialog(null,"Enter in your answer (You only have 30 seconds)", "Answer", JOptionPane.QUESTION_MESSAGE, answerIcon, null, null);
			
			// if the user does not put anything, they are taken to the category method

			if (answer==null)
			{
				
				ansTimer.stop();
				category();
			}
			
			// run these statements only if the answer does not equal null
			else
			{
			// if the answer the user put matches the correct answer
	
			if (answer.trim().equalsIgnoreCase(Travel300ans[randomnum]))
			 {
				//stop the answer Timer (so that it doesn't go up till 0 and show that they lost even though they have already answered)

				 ansTimer.stop();
				
				 //check if ddcheck==true implying that the user is accessing 300 points for the first time so the get daily double
				 if (ddscore==true)
					{
					 // if yes, then increase their score by the number of points they chose to bet for
					 score=score+ dailydoublefinal; 
					 
					//show the congratulations message
					 JOptionPane.showMessageDialog(null,"Congratulations! Your answer was correct! You got " + dailydouble+ " points", "Win", JOptionPane.PLAIN_MESSAGE, congrats);
					 ddscore=false;
					}
				 
				// if ddcheck==false implying that they have accessed daily double once
				 else
				 {
					 // increase the score by 300
					 score=score+300;
					 
					//show the congratulations message
					 JOptionPane.showMessageDialog(null,"Congratulations! Your answer was correct! You got 300 points", "Win", JOptionPane.PLAIN_MESSAGE, congrats);
						
				 }
				 
				 // show them their current score and take them back to selecting a category
				 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
				 category();
			 }	
			
			// if the user's answer does not match with the correct answer

			 else
			 {
				//stop the answer timer

				 ansTimer.stop();
				 
				 // resetting answer to equal null
				 answer="";
				 
				 //check if ddcheck==true implying that the user is accessing 300 points for the first time so the get daily double
				 if (ddscore==true)
				 {
					 // if yes, then decrease their score by the number of points they chose to bet for

					 score = score - dailydoublefinal;
					 
					 //show them the losing message
					 JOptionPane.showMessageDialog(null,"Sorry, your answer was incorrect. You lost " + dailydouble + " points", "Lose", JOptionPane.PLAIN_MESSAGE, lose);
					 ddscore=false;
				 }
				 
				// if ddcheck==false implying that they have accessed daily double once
				 else
				 {
					 //keep the score as is
					 score=score;
					 
					 //show them the losing message
					 JOptionPane.showMessageDialog(null,"Sorry, your answer was incorrect. You lost ", "Lose", JOptionPane.PLAIN_MESSAGE, lose);
						
				 }
				 
				 // show them the message that their answer was incorrect and later show them their current score and take them back to the category option
				 JOptionPane.showMessageDialog(null, "Your current score is " + score, "Score", JOptionPane.PLAIN_MESSAGE, scoreimg);
				 category();
			 }
			}
		}	
		
	}
}
