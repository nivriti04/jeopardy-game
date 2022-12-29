/* ICS3U1 CPT: JEOPARDIZE
 * GROUP MEMBER NAMES: NIVRITI BAJWA AND ASHNOOR RANDHAWA
 * TEACHER'S NAME: MR. CONWAY
 * DATE: 28 JANUARY 2021
 * PROGRAM DESCRIPTION: The program mirrors the real-world Jeopardy game with some twists. As soon as the game begins, the user is shown the intro background
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
 * 
 * PROGRAM DETAILS: INTEGER VARIABLES: choice- the variable choice is used to store the user’s choice of category. There are 4 options (Netflix, 
 * Travel, Mini games and quit). As string indexing starts at 0, the values of choice can be from 0 to 3. option=0: This stores the user’s option if they
 * press the quit button. Yes button stands for 0 and No stands for 1. choicepoints=5: this stores the user’s choice of how many points they want to play 
 * for (100, 200 or 300) with the respective values of 0,1 or 2. randomnum- this is used to generate a random number between 0 and 2 and based on that number, 
 * a question is selected from netflix+travel question arrays of the points the user chose to play for. Seconds, ballseconds, roboseconds and jeopardysecCount
 * all keep track of how many seconds the user has remaining to answer the question or finish the game. dailydoublefinal- this is what stores how many points 
 * the user wants to bet for in case they get daily double. xPlayer, xFire, roboX, xCar, paddleX, ballXpos all keep track of the x positions of the respective 
 * objects. Similarly the y variables such as yplayer, yCar etc. all keep track of the y positions of the objects. FRAME_HEIGHT-stores the height of the frame 
 * in the ball game and the robo power. FRAME_WIDTH-stores the width of the frame  in the ball game and the robo power. robocount-counts the number of robots 
 * killed. Speed-stores the speed at which the car moves right. Rounds-starts at 0 and increases by 1 when the car reaches the end of the road. Used to check
 * if the car has done 2 rounds. ballxDir and ballyDir stores the x and y direction of the of the ball in the ball game. 
 * 
 * ARRAYS: The array for netflix stores the questions. The netflix100 has questions with 100 points. The netflix 200 has questions with 200 points 
 * and the netflix300 array has questions with 300 points. The Netflix100ans, Netflix200ans and Netflix300ans strings store the answers for the questions in 
 * the netflix category based on the points. The arrays for the travel category are  similar and store questions based on the points. The travel answer array
 * works similarly to the netflix and array.The String[] buttons array stores the categories in the game(Netflix, Mini Games and Travel). It has a quit option.
 * It is used in the JOptionPane to display these categories as buttons. Similarly String [] points stores 100,200 and 300 points.
 * 
 * STRINGS: String dailydouble- this stores the value the user inputs for daily double and is later parsed into an integer.
 * String answer: this stores the user’s answer in the netflix and travel category.
 * 
 * TIMER: All the timers in the game are used to animate different objects or keep track of time. ansTimer is the 30 seconds for the netflix and travel 
 * categories.carMove is what moves the car horizontally automatically every 100 milliseconds. fireTimer is what moves the fire (in robot game) towards the 
 * right side of the screen every 100 milliseconds once the fire is shot. Jeopardy Timer is what keeps track of how many seconds have elapsed since the game
 * began and goes up till 300 seconds. BallTimer moves the ball across the screen every 50 milliseconds. BallgameTimer keeps track of the 20 seconds the user
 * has. Similarly robogameTimer keeps track of the 30 seconds the user has and RoboMoveTimer is what is responsible for the movement of the robots. 

 * OBJECTS: robogame, carGame and ballgame are all objects that point to the RoboPower, CarMiniGame and BouncingBallGame class respectively. 
 * JOptionPane pane = new JOptionPane(): creates an object pane and is used to create the answer JOptionPane that can be disposed of once 
 * the user is done answering that question.
 * 
 * IMAGEICONS: All the imageIcons in the game are used for storing the games. For example, carinstr stores the image displayed in the JOptionPane when the
 * instructions for the car game load.
 *  
 * BOOLEANS:Enterchecker: This is to make sure that pressing enter will take the user to selecting the categories only once so that in case the user presses 
 * enter by mistake during the game, he/she is not taken back to the categories option. It's initialized to false and under the Enter Key pressed, an if 
 * statement checks to see if it's false and if it is then the jeopardy timer is started and the category method is called implying that the user’s time of 5
 * minutes begins and the category window is displayed. Once the category method is completed, it's changed to being true so that the if statement under the 
 * enter key pressed doesn’t work any longer. Checkcarpane, checkrobopane and checkballpane make sure that the instructions for the car, robot and bouncing 
 * ball game respectively are only loaded once (when the user plays it for the first time). Postercheck- this variable is used to make sure that the poster is
 * being drawn only till the time the user does not press the enter key. It is initialized to true and under the paint method, an if statement checks to see if
 * it’s true before drawing it and once the enter key is pressed, it changes it to false under the key pressed event so that the poster doesn’t load every 
 * time the paint method runs. ddcheck-this is used to ensure that the user can only access  dailydouble once in a game and the second time the user plays the
 * travel 300 category, a random question is generated and the user is straight away asked for the answer. ddscore- this is used to keep track of if the player 
 * accessed the daily double. If they did, then their score is increased by dailydoublefinal, else it's increased simply by 300. isFired and inRoom are used 
 * to see if there is only 1 instance of the fire in the room so that the user cannot spam the space bar and keep shooting and allow for the fire’s successful
 * movement across the room. Instructionchecker- this works to make sure that the instructions can only be accessed once when the user presses the i key. It 
 * works very similar to the enterchecker and is important to avoid instructions coming up again and again if the user presses the i key by mistake.
 * 
 * MASKS: The Ellipse2D and Rectangle2D masks are created around objects in the room. For example the robots, the car, the obstacles, the player, the ball and
 * the paddle.
 * 
 * METHODS: level() - The level method is used to create the Jframe and is called once the user selects the number of points they want to play for.
 * Paint() method - this method is solely responsible for drawing the backgrounds and displaying objects such as time, player, questions, answer pane etc.
 * on the frame for us. It contains if-else statements that check which category and for how many points has been selected and draws the appropriate objects.
 * category() method -  It displays the category pane and the pane for selecting the number of points they want to play for. The two string arrays: buttons 
 * and points used in this method are for personalizing the buttons of the 2 panes. It starts with a do while so that prompts the user to choose a category.
 * A similar loop runs after, prompting for the user for points they would like to play for. Many if statements are used to check which category and number of points 
 * were selected and based on that, values are reset, timers are started etc. This method helps in calling the starting JOptionPane and resetting everything 
 * once the user is done playing whatever they chose. 
 * shoot() method- this method is called when the user presses the enter key. It sets isFired and inRoom to false confirming that the instance has 
 * been fired and making sure it can not be shot again and its position doesn’t change. The method moves the fireball by 80 pixels to the right.
 * It also checks if the fireball goes outside the room and sets isFired and inRoom to false so that the user can shoot again. It also
 * resets the xPosition of the Fireball to the xPosition of the user.
 * Move () method from the bouncing ball class: The method first adds 11 pixels to the x position of the ball and 13 to the y position using the 
 * variables ballxDir and ballyDir. If the ball touches the top of the room and if statements set the ballyDir to negative making the ball go in
 * the opposite way giving an effect of it bouncing. If the ball touches the left or the right side the ballxDir is set negative changing tits direction.
 * MoveCar() method from the CarMini game class: This method is vital as it is responsible for moving the car to right at the speed of 10pixels.
 * If the car goes outside the screen and moves it back to the front. The variable round is also increased by 1. An if statement is used to 
 * check if round==1 meaning the car has started the second round. Under the if statement the speed of the car is increased to 15.  
 * 
 * FOR LOOP: Used only once. It is a counted loop and replays code within its scope. For loop from line 407 to 428: This loop is present under the i pressed key 
 * pressed and is used to access instructions if the user presses i key on the intro page. The frame visibility is set to false so that we can only see the 
 * JOptionPanes. It only runs once and the user is prompted for their name and is then shown instructions for the game. After it ends, enterchecker is also
 * set to false so that the user can again press enter upon returning to the poster window to access the main game. It is dependent on the variable
 * instructionchecker being set to true and that is to avoid accessing the instructions if the user presses the i key by mistake during the program.
 * 
 * DO WHILE LOOP: Do while loops helps to repeat a certain piece of code which is in their scope till a certain condition is met (the one in the while bracket).
 * One such example starts in the category() method from line 790-815. The user is continuously asked the category they would like to choose until they choose either 
 * of following: Netflix, travel or mini games. If they choose quit then they are asked for confirmation before quitting. It loops back to 
 * selecting a category if they say NO. A similar do while loop runs after prompting the user to choose the number of points they would like to play for.
 * 
 * IF STATEMENTS: These are used throughout the program and help in making decisions. Below listed are some specific examples.
 * 1. If-else statement from line 859 to 909. This loop is responsible for checking if travel 300 category was selected. It resets the value of seconds to 30 
 * so that each time the user plays again, the value of seconds is reset to 30. There is another if statement inside which is responsible for the daily
 * double chance and checks if ddcheck is true which implies that its the first time the user has chosen travel for 300 points and that they can 
 * get a daily double. Inside the if statement is a while loop which runs till the time valid is true and has a try and catch statement which checks 
 * for if the points entered is a valid input (is an integer). If it isn’t, it shows an error message and asks for input again. The data is then parsed 
 * into an integer so that it can be used to be added to or subtracted from the score. Once a valid input is received, valid is set to false so that 
 * the while loop doesn’t run again and ddcheck to false so that the else statement runs next time the user selects it. It also sets ddscore to true 
 * which is later used to check what needs to be added/ subtracted from the score (daildydouble points or just 300) and starts the answer timer and 
 * calls upon the question method. The else statement simply starts the answer timer and calls upon the question method. Other if statements for 
 * netflix and travel are similar to the else statement of the travel 300 category wherein they reset the seconds, start the answer timer and 
 * call the question method.
 * 
 * 2. If statement from line 985-1005. This is responsible for if the user chose mini games for 200 points. It stops the answer Timer so that in case
 * its running in the background, it is stopped. It has another if statement which checks if robopane is true and if it is then displays the instructions
 * and sets it to false after so that the instructions are only shown once. It resets the value of roboseconds to 30 so that each time the player chooses
 * to play it again, the value of it is 30 and starts the robogame timer. The setup of other points under mini games is very similar to this one and
 * serve the same purpose of showing the instructions, resetting the values and starting the timers.
 * 
 * 3. Else if statement from line 1115 to 1129. This else if statement checks if the user chose travel for 200 points. It is responsible for drawing the 
 * background, and displaying the text on the frame which is divided into two lines with the help of the substring method from the string class. On the 
 * first line, characters from 0 to 45 are displayed and on the second line from character 46. This was needed to get a neat looking question. The question 
 * that needs to be displayed is based on the integer variable randomnum which generates a random number between 0 and 2 and based on the number generated, 
 * the corresponding question from the array index of travel points selected is shown. It sets the font and the color and displays the 30 second count down. 
 * The setup for the netflix and travel categories is very similar for all choice of points. For the mini games as well the if statements call upon the draw 
 * method from the respective classes which draws the background, time, and objects.
 *   
 * 4. If else statement from lines of code 1464 to 1555. The main purpose of this loop is to display the answer pane for the questions and compare 
 * the user’s answer to the correct answer stored in the array. This specific if-else statement is if the user chooses Travel for 300. It first displays 
 * the answer pane and checks to see what the input of the user was. Another if else statement checks if they enter null, and if they do it takes them back to
 * selecting a category and stops the answer timer. The else statement runs if the answer is not null and loops the part where answer inputed is compared to the
 * right answer. If the answer matches the correct answer, the answer timer is stopped and in this case, there’s another if-else statement that sees if 
 * ddscore equals true implying that they are on daily double. If this is true, the score is increased by the number of points they bet for, a congratulations
 * message is shown and ddscore is set to false so that this loop doesn’t run again. If ddscore is not true implying that they have already accessed daily 
 * double, then entire score increases by 300 and a congratulations message is shown. In either case, they are shown their current score and taken back to 
 * selecting a category. If the answer doesn’t match, then also the answer timer is stopped and ddscore is checked. If it's true, then the points that they 
 * bet for are decreased from their score and a losing message is shown and ddscore is set to false. If ddscore is not true, then their score remains
 * unchanged. In both cases, their current score is shown again and they are taken back to the category method. The rest of the if-else statements in the 
 * question method for other points under travel and netflix also work in the same way. The difference is that the if-else statement for ddscore is not 
 * present. Having all these in one method also helps us navigate our code easily and have everything related to each other at one place
 * 
 * KEY PERFORMED EVENT: This event checks which key has been pressed by the user and performs the task within each. For example if the up key is pressed, 
 * it first checks which game requires this key. This is done by checking the choice and the choicepoints that the user selected. If the user selected the 
 * Robot game then the Up() method from the roboPower class is called. If the user has chosen the car game then the up() method from the CarMiniGame class 
 * is called. The same is done for the rest of the keys. The methods associated with the keys are called when they are pressed. Repaint is used at the 
 * end of all of them so that the last images drawn are deleted and an animated effect is given of the objects moving.
 * 
 * CLASSES: Having more than one class is important as it helps us clean our code and for people to combine work at the end. We have 3 additional classes.
 * BOUNCING BALL CLASS: The main purpose of this class is to deal with the movement of the ball and the paddle. It is important as I don't have to worry about
 * it in my main class. The bouncing ball class also helps to check for boundary checking of the paddle and the ball and the intersection of the ball with the
 * paddle. It helps to determine whether the player lost or won. The draw method in the class is responsible for drawing the background of the game, the ball,
 * the paddle and the time on the JFrame. This way, all the code concerned with the ball game is at once place.
 * ROBO POWER CLASS: The main purpose of this class is also quite similar to the bouncing ball class. It is responsible for keeping track of moving the player
 * up and down and for helping it shoot the robots using the space bar. It also is responsible for the spawning of the robots across the room and the 
 * intersection of the robots with the fire. The robo Power class also keeps track of how much time is left and how many robots the player has killed which are
 * needed to determine whether the user won or not. Lastly, it also helps checks for boundary collision of the player.
 * CAR MINI GAME CLASS: This class keeps track of the car's movement. It moves the car horizontally automatically and the player can move it up/down. It checks 
 * for boundary checking of the car and draws the obstacles in both rounds. It checks for which round the person is on, the speed, the collision of the car with
 * the obstacles and determining if the person won or not using different methods. It is important to make sure the main class is only used to call upon the
 * methods from this class and that all the code concerning this mini game is at one place.
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
