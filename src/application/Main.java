/*
 * ICS4U1 CPT: Attack of the Sussy Aliens (alt name Alien Attack).
 * 
 * By: Avi Dave.
 * 
 * Teacher: Kevin Conway
 * 
 * Program Description: 
 * 
 * 	This game is a space shooter, where the player controls a ship that shoots lasers and bombs at enemy aliens. The player is able to move up, down, left, and right, as well as diagonally.
 * 	The ship movement is controlled by the arrow keys. Note that moving up is slower than moving down or to the side (this is to increase the difficulty when trying to avoid aliens). There is
 * 	also a moving background, which speeds up as the game goes on. The ships speed will increase proportionally to the speed of the background. To shoot lasers, the 'E' key must be pressed. The
 * 	laser will repeatedly shoot at a rate of one shot per 0.5 seconds, as long as the key is pressed. All aliens will die as soon as they are hit by a laser. The ship can also shoot bombs from
 * 	the sides, by pressing the 'A' and 'D' keys. The 'A' key will shoot a bomb from the left side of the ship. The 'D' key will shoot a bomb from the right side of the ship. The bomb also moves
 * 	with the background. Bomb can only be fired at a rate of one firing per 2.2 seconds.
 * 
 * 	There are walls that act as boundaries that the ship may pass through in order to continue in the game and move with the background. If the ship does not pass through the boundary then it 
 * 	will be pushed off the screen by the boundary, resulting in a loss of one life. There are three different types of boundaries - one that has an opening on the left, one that has an opening
 * 	on the right, and one that has an opening on both sides. To pass a boundary, the ship must travel through the opening. Walls also act as boundaries that measure every 50m in-game.
 * 
 * 	Since the walls move with the moving background, this can increase the difficulty of the game, because the walls become harder to avoid the faster the speed of the background gets. Also,
 * 	since the speed of the ship movement also increases with the moving background, it tends to make the ship faster but also harder to maneuver at higher speeds.
 * 
 * 	The player will have three lives in the beginning of the game, and can also lose a life if hit by an alien. There are three types of aliens - red, green, and ghost. Red aliens move by
 * 	bouncing off the edge of the window after spawning. This ricocheting makes their movement unpredictable. Green aliens approach the x and y-coordinate of the ship, making them easier to
 * 	avoid and shoot from a distance (it is difficult to hit them when they get close). Ghost aliens tend to follow the exact path of the ship, forcing the player to constantly move the ship
 * 	to new positions to avoid getting hit. Lives can also be gained if enough aliens are killed.
 * 
 * 	Coins also spawn in the game. They spawn at random x and y-coordinates on the screen, and move with the background. Coins act as currency in the game to get upgrades. They can only be
 * 	collected by colliding with them using the ship.
 * 
 * 	By default, 6 aliens will spawn per every 50m, 2 coins will spawn per every 50m, and 1 life will be gained per every 7 aliens killed. During gameplay, the top-right side of the window will
 * 	display the distance traveled, coins collected, and aliens killed. The total amount of coins collected (not just from the most recent game) will be displayed in the title screen.
 * 
 * 	The game begins with the title screen. The title screen will have a TextField that will allow the player to input their chosen name. This name will later appear in the leaderboard. If they
 * 	do not choose a name, the name will be set to the default "SUSSY UNKNOWN". Players must click the play Button to play the game. To see the controls and upgrades, players must click the 
 * 	settings Button. This will change the window to a different Scene, that displays an Image of the controls, and three upgrade trees and corresponding Buttons. 
 * 
 * 	Upgrades will require coins to get upgrades that decrease the amount of aliens that spawn by one, increase the number of coins that spawn by one, and decrease the amount of aliens 
 * 	the player needs to kill to gain a new life. The amount of coins required increases per each upgrade. For example for the 1st upgrade of the coin spawn tree, the price would be 10 coins.
 * 	For the second, it would be 20 coins, 30 coins for the third, and 40 for the final upgrade. This means that a total of 100 coins are required to fully upgrade a tree. To get all the
 * 	the upgrades, the player would need 300 coins.
 * 
 * 	To access the leaderboard from the title screen, the player must press the score Button. This will display all the scores in chronological order (the most recent score would be at the 
 * 	bottom of the leaderboard). There are three Buttons that will allow the player to sort the leaderboard by the distance traveled, coins collected, and aliens killed from highest to lowest.
 * 
 * Program Details: 
 * 
 * Images: There are images for the game background (imgBackground), title background (imgTitle), play button (imgPlayButton), settings button (imgSettings), score button (imgHighScore),
 * 	the back button for the leaderboard (imgBackbtn), the button to sort scores by distance (imgSortDist), the button to sort scores by coins (imgSortCoins), the button to sort scores by
 * 	kills (imgSortKills), the back button for the settings (imgControlBack), the background for the settings background (imgControl). There are also arrays of Images used for the upgrade trees,
 * 	(imgRegen, imgCost, imgMoney, imgSpawn).
 * 
 * 	ImageViews: There are corresponding ImageViews for each Image, however there is also ivRegen, ivMoney, and ivSpawn which display the current Images for the upgrade trees. imgCost actually
 * 		displays the cost for each upgrade of the trees, so it also has three corresponding ImageView arrays for each upgrade tree.
 * 
 * Spaceship: There is one Spaceship object called ship, which the player will control. It will always spawn in the centre of the game screen.
 * 
 * Wall: There is one wall object that crosses and re-crosses the screen with the background. Each time it crosses, the Image and boundaries for the object are randomly reset.
 * 
 * Bomb: There is only one bomb object that relocates at the ship when A or D are pressed at a rate of one firing per 2.2 seconds. The Image displayed faces left or right depending on whether A
 * 	or D are pressed.
 * 
 * ArrayLists: There are 4 object ArrayLists that keep track of the multiple Bullet objects, Alien objects, Heart objects, and Coin objects spawned during gameplay. There are three Integer
 * 	ArrayLists that read previous kills, coins, and distance scores from the "leaderboard.txt" file. There is also a String ArrayList that reads usernames from the "leaderboard.txt" file.
 * 	(bullet, alien, heart, coin, killsList, distanceList, coinsList, namesList).
 * 
 * 2D Array: newOrderList is a 2D array that combines the killsList, distanceList, and coinsList ArrayLists for sorting in the leaderboard.
 * 
 * TextField: nameField is a TextField that appears in the title screen, and allows players to input their username. This username is only added to the leaderboard if the game is played.
 * 
 * TextArea: highScoreTxt is a TextArea used to display the leaderboard on the main screen (rather than open a new pane).
 * 
 * Buttons: On the menu Pane, there is a play button (playBtn), settings button (settingsBtn), and score button (scoreBtn) There are 2 back buttons (backBtn1, and backBtn2) for returning to 
 * 	the menu from settings and the leaderboard. In the settings, there is the aforementioned back buttons, as well as an array of Buttons that display the cost of upgrading (using the ivCost
 * 	ImageView array). In the leaderboard, there are three buttons that display using corresponding ImageViews (byCoinsBtn, byKillsBtn, and byDistBtn) that sort by aliens killed, coins collected,
 * 	and distance traveled.
 * 
 * There is a FileReader, FileWriter, BufferedReader, and BufferedWriter for reading and writing to and from files.
 * 
 * Files: The game uses boardFile ("leaderboard.txt") to store and retrieve the high scores of each attempt (name, distance traveled, aliens killed, coins collected). upgradeFile 
 * 	("upgrades.txt") is used to keep track of upgrades and coin costs. Finally, songFile is used to access the background music for the Media and MediaPlayer objects to play on repeat throughout
 * 	the game.
 * 
 * AudioClip array: An AudioClip array is used to play all the other sounds apart from the background music. THese sounds include sounds for killing aliens, shooting lasers, losing a life,
 * 	and game over.
 * 
 * AnimationTimer: An AnimationTimer is used throughout the game to facilitate movement of the player, enemies, boundaries, and background. It also keeps track of collisions and gameplay logic.
 * 	A Platform.runLater is used to reset the game before returning to the menu.
 * 
 * Timelines and Polymorphism: 3 Timeline objects are used including bulletTimer, bombTimer, and alienTimer to periodically spawn bullets, bombs, and aliens. What is especially important is that the alienTimer
 * 	makes use of the Alien super class to randomly spawn the three different sub classes of aliens (POLYMORPHISM).
 * 
 * Layouts used: VBoxes have been used to organize buttons such as the play button, settings button, and score button in the main menu, and the three cost buttons in the settings. The main menu (title screen)
 * 	and game screen only uses a normal Pane, however, the settings use a GridPane. There are also multiple scene to facilitate switching between layout panes throughout the game.
 * 
 * Classes: There are a total of 10 classes in this game (not including Main). Of these classes, 3 (GhostAlien, GreenAlien, and RedAlien) are actually sub classes that inherit their methods
 * 	from the abstract Alien class. THere is also a Spaceship (player) class, as well as a Heart class (which is the method for keeping track of lives in the game), the Bullet class, the Bomb
 * 	class, the Coin class, and the Wall class.
 * 
 * When one of the sorting buttons in the leaderboard are clicked, and insertion sort algorithm is run which sorts the scores by the kills, coins, or distance.
 * 
 * Most of the code for the leaderboard and upgrades are in the methods: readLeaderBoard(), addToLeaderBoard(), sortLeaderBoard(), getName(), getUpgradeStatus(), setUpgradeStatus(), 
 * 	onUpgradeClick().
 */

package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	
	//All the global variables
	private Image imgBackground, imgTitle, imgPlayButton, imgSettings, imgHighScore, imgBackBtn, imgSortDist, imgSortCoins, imgSortKills, imgControlBack, imgControl;
	private ImageView ivBackground1, ivBackground2, ivTitle, ivPlayButton, ivSettings, ivHighScore, ivBackBtn1, ivBackBtn2, ivSortDist, ivSortCoins, ivSortKills, ivControl;
	private Image[] imgRegen, imgCost, imgMoney, imgSpawn;
	private ImageView ivRegen, ivMoney, ivSpawn;
	private ImageView[] ivCost;
	private AnimationTimer animation;
	
	//int variable uses:
	//backSpeed - background speed, bulletCount, alienCount, coinCount, heartCount keep track of corresponding objects, maxAliens - the maximum aliens that can spawn, maxCoins - the maximum
	//coins that can spawn, maxRegenPerKill - the number of aliens that must be killed before a life is gained, killed - used to decide when to regen  a life, shipSpeed - the speed of the ship, 
	//kills - the total aliens killed, totalDistance - the total distance, distance - used to keep track of when 50m pass and update the distance label in-game, coins - the coins gained in-game,
	//totalCoins - the total amount of coins.
	
	private int backSpeed = 1, bulletCount = -1, alienCount = -1, maxAliens = 6, alienType = 0, heartCount = -1, coinCount = -1, maxCoins = 2, maxRegenPerKill = 7, killed = 0, shipSpeed = 0;
	private int kills = 0, totalDistance = 0, distance = 0, coins = 0, totalCoins = 0;
	private Spaceship ship;
	private Wall wall;
	private Bomb bomb = new Bomb();
	private ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	private ArrayList<Alien> alien = new ArrayList<Alien>();
	private ArrayList<Heart> heart = new ArrayList<Heart>();
	private ArrayList<Coin> coin = new ArrayList<Coin>();
	private Timeline bombTimer, bulletTimer, alienTimer;
	
	//boolean variable uses:
	//isUp, isDown, isLeft, and isRight - are used for smooth movement during the game, shoot - is used to decide when to shoot a laser, containInBounds - is used to decide when the ship
	//remains in bounds. coinIntersects - is used to make sure that no two coins' x-positions are intersecting, hasBomb - check whether a bomb has been spawned, resetBomb - is used to reset
	//the bomb to its starting position.
	
	private boolean isUp = false, isDown = false, isLeft = false, isRight = false, shoot = false, containInBounds = true, coinIntersects = false, hasBomb = false, resetBomb = false;
	private Random rand = new Random();
	private Label killsLbl, distanceLbl, titleLbl, scoreLbl, coinsLbl, controlLbl, regenLbl, moneyLbl, spawnLbl;
	private Pane menu, game;
	private GridPane control;
	private Scene titleScene, gameScene, controlScene;
	private Button playBtn, settingsBtn, scoreBtn, backBtn1, backBtn2, byCoinsBtn, byKillsBtn, byDistBtn;
	private Button[] costBtn;
	private TextArea highScoreTxt;
	private File boardFile, upgradeFile, songFile;
	private FileReader in;
	private FileWriter out;
	private BufferedReader reader;
	private BufferedWriter writer;
	private ArrayList<Integer> killsList = new ArrayList<Integer>();
	private ArrayList<Integer> distanceList = new ArrayList<Integer>();
	private ArrayList<Integer> coinsList = new ArrayList<Integer>();
	private int[][] newOrderList;
	private ArrayList<String> namesList = new ArrayList<String>();
	private String[] newNamesList;
	private String name;
	private TextField nameField;
	
	//KILLS, DIST, and COINS are used in the sorting algorithm to set what the insertion sort code will sort by.
	
	private static final int KILLS = 0, DIST = 1, COINS = 2;
	private Media media;
	private MediaPlayer mPlayer;
	private AudioClip[] clips;
	
	//The method for all the gameplay and GUI.
	public void start(Stage primaryStage) {
		try {
			
			//Initializing the songFile and media objects.
			songFile = new File("lancer.mp3");
			media = new Media(songFile.toURI().toASCIIString());
			
			//Initializing mPlayer, setting it so that it plays the background music automatically, and repeats the music when it ends.
			mPlayer = new MediaPlayer(media);
			mPlayer.setAutoPlay(true);
			mPlayer.setOnEndOfMedia(new Runnable() {
				public void run() {
					mPlayer.seek(Duration.ZERO);
				}
			});
			
			//Initializing the AudioClip array, and adding AudioClip objects for the various sound effects.
			clips = new AudioClip[] {new AudioClip("file:Splat.wav"), new AudioClip("file:Laser.wav"), new AudioClip("file:Death.wav"), new AudioClip("file:damage.wav")};
			
			//Initializing the boardFile (for the leaderboard) and upgradeFile (for the upgrades).
			boardFile = new File("leaderboard.txt");
			upgradeFile = new File("upgrades.txt");
			
			//Calling the method that will read all the scores into an ArrayList to use to display on the leaderboard and sorting.
			readLeaderBoard();
			
			//These two font variables hold downloaded fonts for the game from .ttf files.
			Font titleFont = Font.loadFont("file:Game Of Squids.ttf", 50);
			Font headerFont = Font.loadFont("file:MHOSOQ-Regular.ttf", 36);
			
			/*
			 * From here on is menu (title screen) code:
			 */
			
			//Initializing the menu Pane.
			menu = new Pane();
			
			//Initializes the title screen background Image and ImageView, and adjusts the size of the ImageView.
			imgTitle = new Image("file:images\\title_screen.gif");
			ivTitle = new ImageView(imgTitle);
			ivTitle.setFitWidth(imgTitle.getWidth() * 1.3);
			ivTitle.setFitHeight(imgTitle.getHeight() * 1.3);
			
			//Initializes the titleScene object and sets it to the size of the background ImageView
			titleScene = new Scene(menu, ivTitle.getFitWidth(), ivTitle.getFitHeight());
			
			//Initializes titleLbl (which displays the game title), sets the text, sets the font to titleFont, sets the alignment, colour and position of the Label.
			titleLbl = new Label("Attack Of\nThe Sussy Aliens");
			titleLbl.setFont(titleFont);
			titleLbl.setTextAlignment(TextAlignment.CENTER);
			titleLbl.setTextFill(Color.RED);
			titleLbl.setLayoutX(0);
			titleLbl.setLayoutY(20);
			
			//Initializes coinsLbl (which displays the total coins), sets the text, sets the font, alignment, colour and position of the Label.
			coinsLbl = new Label("TOTAL COINS: " + totalCoins);
			coinsLbl.setFont(Font.font("MS Gothic", FontWeight.EXTRA_BOLD, 36));
			coinsLbl.setTextFill(Color.GOLD);
			coinsLbl.setLayoutX(200);
			coinsLbl.setLayoutY(170);
			
			//Initializes nameField (which will hold the player's username), sets the prompt text, font, position and width of the TextField.
			nameField = new TextField();
			nameField.setPromptText("Enter your name here:");
			nameField.setFont(headerFont);
			nameField.setPrefWidth(540);
			nameField.setLayoutY(titleScene.getHeight() - 85);
			nameField.setLayoutX(90);
			
			//Initializes playBtn.
			playBtn = new Button();
			
			//Initializes the Image and ImageView for playBtn, and adjusts the ImageView size.
			imgPlayButton = new Image("file:images\\play_button.png");
			ivPlayButton = new ImageView(imgPlayButton);
			ivPlayButton.setFitWidth(imgPlayButton.getWidth() / 1.5);
			ivPlayButton.setFitHeight(imgPlayButton.getHeight() / 1.5);
			
			//Sets the ImageView as the graphic for the Button, and makes the Button background transparent so it looks like the ImageView is the Button.
			playBtn.setGraphic(ivPlayButton);
			playBtn.setBackground(Background.EMPTY);
			
			//This code prepares sets up the code before the game begins.
			playBtn.setOnAction(new EventHandler<ActionEvent> () {
				public void handle(ActionEvent e) {
					
					//Three hearts are initializes in the heart ArrayList and added to the game Pane (which is later on in the code).
					for (int i = 0; i < 3; i++) {
						heart.add(i, new Heart());
						heart.get(i).setY(10);
						heart.get(i).setX(i * 20 + 10);
						game.getChildren().add(heart.get(i).getNode());
					}
					
					//This sets the heartCount to what it should be with three heart objects in the ArrayList.
					heartCount = heart.size() - 1;
					
					//This sets the x and y-positions for the ImageViews of the game background.
					ivBackground1.setY(0);
					ivBackground2.setY(-ivBackground1.getFitHeight());
					
					//This is to reset the ship movement code.
					ship.moveX(0);
					ship.moveY(0);
					
					//setLocation takes the gameScene's width and height and uses it to centre the ship on the screen.
					ship.setLocation(gameScene.getWidth(), gameScene.getHeight());
					
					//This sets the wall object's y-position to above the gameScene, sets the wall's ImageView to a random Image (out of three variants), and sets the wall's x-position.
					wall.setY(-wall.getHeight());
					wall.setRandom();
					wall.setX(gameScene.getWidth()/2 - wall.getWidth()/2);
					
					//This code sets the Stage object - primaryStage - to view the game Pane.
					primaryStage.setScene(gameScene);
					
					//This method checks the nameField TextField for a name to add to the namesList for when this attempt is added to the leaderboard (after game over).
					getName();
					
					//Removing any aliens in the gamePane and alien ArrayList.
					for (int i = alien.size() - 1; i > -1; i--) {
						alienCount--;
						game.getChildren().remove(alien.get(i).getNode());
						alien.remove(alien.get(i));
					}
					
					//Removing any coins in the gamePane and coin ArrayList.
					for (int i = coin.size() - 1; i > -1; i--) {
						coinCount--;
						game.getChildren().remove(coin.get(i).getNode());
						coin.remove(coin.get(i));
					}
					
					//Removing any bullets in the gamePane and bullet ArrayList.
					for (int i = 0; i < bullet.size(); i++) {
						bulletCount--;
						game.getChildren().remove(bullet.get(0).getImage());
						bullet.remove(bullet.get(0));
					}
					
					//The gameScene.setOnKeyPressed method must be reset so each time the play button is clicked so that the ship does not continue to move when the player plays again despite
					//no keys being pressed. This contains the code for what happens when a key is pressed.
					gameScene.setOnKeyPressed(new EventHandler<KeyEvent> () {
						public void handle(KeyEvent e) {
							
							//isUp is set to true is the UP ARROW key is pressed.
							if (e.getCode() == KeyCode.UP) {
								isUp = true;
							}
							
							//isDown is set to true is the DOWN ARROW key is pressed.
							if (e.getCode() == KeyCode.DOWN) {
								isDown = true;
							}
							
							//isLeft is set to true is the LEFT ARROW key is pressed.
							if (e.getCode() == KeyCode.LEFT) {
								isLeft = true;
							}
							
							//isRight is set to true is the RIGHT ARROW key is pressed.
							if (e.getCode() == KeyCode.RIGHT) {
								isRight = true;
							}
							
							//If the player has not already shot a bomb (hasBomb), and the bomb can be reset (resetBomb):
							if (hasBomb && resetBomb) {
								
								//If the A key is pressed, set the bomb's direction to west and set the bomb's location, before setting hasBomb to false.
								if (e.getCode() == KeyCode.A) {
									bomb.setDirection(Bomb.WEST);
									bomb.setLocation(ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight(), resetBomb);
									hasBomb = false;
									
								//If the D key is pressed, set the bomb's direction to east and set the bomb's location, before setting hasBomb to false.
								} else if (e.getCode() == KeyCode.D) {
									bomb.setDirection(Bomb.EAST);
									bomb.setLocation(ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight(), resetBomb);
									hasBomb = false;
								}
								
								//If the ship has released the bomb, the bomb cannot be reset to shoot again before the bomb leaves the screen or collides with an alien.
								if (!hasBomb) {
									resetBomb = false;
								}
							}
							
							//If the E key is pressed, make it so that the ship shoots a laser (shoot is true).
							if (e.getCode() == KeyCode.E) {
								
								shoot = true;
							}
						}
					});
					
					//Starts the AnimationTimer, and alienTimer and bombTimer Timelines.
					animation.start();
					alienTimer.playFromStart();
					bombTimer.playFromStart();
				}
			});
			
			//Initializes settingsBtn.
			settingsBtn = new Button();
			
			//Initializes the settingsBtn Image and ImageView, and adjusts the ImageView size.
			imgSettings = new Image("file:images\\settings.png");
			ivSettings = new ImageView(imgSettings);
			ivSettings.setFitWidth(imgSettings.getWidth() / 1.5);
			ivSettings.setFitHeight(imgSettings.getHeight() / 1.5);
			
			//Sets the settingsBtn graphic to the ImageView, and makes the Button background transparent so it looks like the ImageView is the Button.
			settingsBtn.setGraphic(ivSettings);
			settingsBtn.setBackground(Background.EMPTY);
			
			/*
			 * The main menu code is continued below, but since the score button does not open a new Pane, its code is located here.
			 */
			
			//Initializes scoreBtn.
			scoreBtn = new Button();
			
			//Initializes the scoreBtn Image and ImageView, and adjusts the ImageView size.
			imgHighScore = new Image("file:images\\high_score.png");
			ivHighScore = new ImageView(imgHighScore);
			ivHighScore.setFitWidth(imgHighScore.getWidth() / 1.5);
			ivHighScore.setFitHeight(imgHighScore.getHeight() / 1.5);
			
			//Sets the scoreBtn graphic to the ImageView, and makes the Button background transparent so it looks like the ImageView is the Button.
			scoreBtn.setGraphic(ivHighScore);
			scoreBtn.setBackground(Background.EMPTY);
			
			//Initializes the TextArea that will serve as the leaderboard, sets the font, initial text displayed, the size, the position, and sets the TextArea background to black.
			highScoreTxt = new TextArea();
			highScoreTxt.setFont(headerFont);
			highScoreTxt.setText("LEADERBOARD\n\n");
			highScoreTxt.setPrefSize(610, 610);
			highScoreTxt.setLayoutX(titleScene.getWidth()/2 - highScoreTxt.getPrefWidth()/2);
			highScoreTxt.setLayoutY(titleScene.getHeight()/2 - highScoreTxt.getPrefHeight()/2);
			highScoreTxt.setStyle("-fx-control-inner-background: black");
			
			//Makes it so that the text automatically goes to a new line once it begins to leave the bounds of the TextArea.
			highScoreTxt.setWrapText(true);
			
			//Initializes byCoinsBtn and sets the size.
			byCoinsBtn = new Button();
			byCoinsBtn.setPrefSize(150, 30);
			
			//Initializes the Image and ImageView for byCoinsBtn.
			imgSortCoins = new Image("file:images\\sort_coin.png");
			ivSortCoins = new ImageView(imgSortCoins);
			
			//Sets the graphic to the ImageView and makes the background transparent so that the Button looks like the ImageView.
			byCoinsBtn.setBackground(Background.EMPTY);
			byCoinsBtn.setGraphic(ivSortCoins);
			
			//When clicked, the sortLeaderBoard method is told to sort the leaderboard by the most coins collected.
			byCoinsBtn.setOnAction(e -> sortLeaderBoard(COINS));
			
			//Initializes byKillsBtn and sets the size.
			byKillsBtn = new Button("Sort By Kills");
			byKillsBtn.setPrefSize(150, 30);
			
			//Initializes the Image and ImageView for byKillsBtn.
			imgSortKills = new Image("file:images\\sort_kill.png");
			ivSortKills = new ImageView(imgSortKills);
			
			//Sets the graphic to the ImageView and makes the background transparent so that the Button looks like the ImageView.
			byKillsBtn.setBackground(Background.EMPTY);
			byKillsBtn.setGraphic(ivSortKills);
			
			//When clicked, the sortLeaderBoard method is told to sort the leaderboard by the most aliens killed.
			byKillsBtn.setOnAction(e -> sortLeaderBoard(KILLS));
			
			//Initializes byDistBtn and sets the size.
			byDistBtn = new Button("Sort By Distance");
			byDistBtn.setPrefSize(150, 30);
			
			//Initializes the Image and ImageView for byDistBtn.
			imgSortDist = new Image("file:images\\sort_dist.png");
			ivSortDist = new ImageView(imgSortDist);
			
			//Sets the graphic to the ImageView and makes the background transparent so that the Button looks like the ImageView.
			byDistBtn.setBackground(Background.EMPTY);
			byDistBtn.setGraphic(ivSortDist);
			
			//When clicked, the sortLeaderBoard method is told to sort the leaderboard by the most distance traveled.
			byDistBtn.setOnAction(e -> sortLeaderBoard(DIST));
			
			//Initializes backBtn1, and sets the background to empty in order to display an ImageView.
			backBtn1 = new Button();
			backBtn1.setBackground(Background.EMPTY);
			
			//Initializes the Image and ImageView for backBtn1.
			imgBackBtn = new Image("file:images\\back.png");
			ivBackBtn1 = new ImageView(imgBackBtn);
			
			//Adjusts the size of the ImageView and sets the Button's graphic to the ImageView.
			ivBackBtn1.setFitWidth(imgBackBtn.getWidth() / 1.5);
			ivBackBtn1.setFitHeight(imgBackBtn.getHeight() / 1.5);
			backBtn1.setGraphic(ivBackBtn1);
			
			//Sets the position for backBtn1.
			backBtn1.setLayoutX(highScoreTxt.getPrefWidth() - 180);
			backBtn1.setLayoutY(540);
			
			//This VBox is used to hold the three Buttons: byDistBtn, byCoinsBtn, and byKillsBtn.
			VBox sortBox = new VBox(30, byDistBtn, byCoinsBtn, byKillsBtn);
			
			//This code sets the position of the VBox.
			sortBox.setLayoutX(highScoreTxt.getPrefWidth() - 240);
			sortBox.setLayoutY(60);
			
			//When backBtn1 is clicked, it removes the VBox, itself, and the leaderboard TextArea.
			backBtn1.setOnAction(new EventHandler<ActionEvent> () {
				public void handle(ActionEvent e) {
					menu.getChildren().removeAll(highScoreTxt, sortBox, backBtn1);
				}
			});
			
			//When scoreBtn is clicked, it adds the VBox sortBox, backBtn1, and highScoreText (the TextArea).
			scoreBtn.setOnAction(new EventHandler<ActionEvent> () {
				public void handle(ActionEvent e) {
					menu.getChildren().addAll(highScoreTxt, sortBox, backBtn1);
					
					//The TextArea is reset each time to display a newly updated list of scores (in order to include the most recent attempts that may be newly added to the ArrayLists for the scores.
					highScoreTxt.clear();
					
					//Appending the text to display the scores which include the names, distances, kills, and coins for each attempt.
					for (int i = 0; i < namesList.size(); i++) {
						highScoreTxt.appendText("\n" + namesList.get(i) + "\nDistance..." + 
					distanceList.get(i) + "\nKills..." + killsList.get(i) + "\nCoins..." + coinsList.get(i) + "\n");
					}
				}
			});
			
			//Another VBox, buttonBox, is made which holds the play button, settings button, and score button for the main menu. 
			VBox buttonBox = new VBox(30, playBtn, settingsBtn, scoreBtn);
			
			//This code is used to position the VBox.
			buttonBox.setLayoutX(titleScene.getWidth()/2 - ivPlayButton.getFitWidth()/2);
			buttonBox.setLayoutY(230);
			
			//The main menu background ImageView, the title Label, the VBox holding the Buttons, the TextField that holds the player username, and the Label that displays the total coins
			//are added to the menu Pane.
			menu.getChildren().addAll(ivTitle, titleLbl, buttonBox, nameField, coinsLbl);
			
			/*
			 * The code for the settings Button and control Pane is here:
			 */
			
			//This Pane is initialized as a GridPane, and the border padding, and gap between objects displayed in the Pane is set.
			control = new GridPane();
			control.setPadding(new Insets(10, 10, 10, 10));
			control.setHgap(10);
			control.setVgap(10);
			
			//The settings/control centre background Image is initialized.
			imgControlBack = new Image("file:images\\gears.gif");
			
			//The controlScene object is initialized.
			controlScene = new Scene(control, 915, 500);
			
			//The controlLbl is set to display the title of the Pane.
			controlLbl = new Label("Control Centre");
			
			//The font for the controlLbl is set, and the Label is set to the colour Black.
			controlLbl.setFont(headerFont);
			controlLbl.setTextFill(Color.BLACK);
			
			//The Images for the 3 upgrade trees and the corresponding cost buttons are added to 4 Image arrays.
			imgRegen = new Image[] {new Image("file:images\\regen_0.png"), new Image("file:images\\regen_1.png"), new Image("file:images\\regen_2.png"),
					new Image("file:images\\regen_3.png"), new Image("file:images\\regen_4.png")};
			imgCost = new Image[] {new Image("file:images\\cost_10.png"), new Image("file:images\\cost_20.png"), new Image("file:images\\cost_30.png"),
					new Image("file:images\\cost_40.png")};
			imgMoney = new Image[] {new Image("file:images\\coin_0.png"), new Image("file:images\\coin_1.png"), new Image("file:images\\coin_2.png"),
					new Image("file:images\\coin_3.png"), new Image("file:images\\coin_4.png")};
			imgSpawn = new Image[] {new Image("file:images\\alien_0.png"), new Image("file:images\\alien_1.png"), new Image("file:images\\alien_2.png"),
					new Image("file:images\\alien_3.png"), new Image("file:images\\alien_4.png")};
			
			//This method reads the upgrade status from the upgradeFile, and sets the corresponding ImageViews accordingly.
			getUpgradeStatus();
			
			//Labels to display the effects of each type of upgrade are initialized.
			regenLbl = new Label();
			moneyLbl = new Label();
			spawnLbl = new Label();
			
			//The fonts and colours of the Labels are set.
			regenLbl.setFont(Font.font("Trebuchet MS", FontWeight.EXTRA_BOLD, 20));
			regenLbl.setTextFill(Color.RED);
			moneyLbl.setFont(Font.font("Trebuchet MS", FontWeight.EXTRA_BOLD, 20));
			moneyLbl.setTextFill(Color.RED);
			spawnLbl.setFont(Font.font("Trebuchet MS", FontWeight.EXTRA_BOLD, 20));
			spawnLbl.setTextFill(Color.RED);
			
			//The Labels and ImageViews for the upgrade trees are added to a VBox.
			VBox upgradeBox = new VBox(18, ivRegen, regenLbl, ivMoney, moneyLbl, ivSpawn, spawnLbl);
			
			//The Button array for the corresponding cost buttons are initialized.
			costBtn = new Button[] {new Button(), new Button(), new Button()};
			
			//The costBtns' background are set to empty, and their graphics are set to the corresponding ImageViews, in order to make the Button look like the ImageViews.
			costBtn[0].setBackground(Background.EMPTY);
			costBtn[1].setBackground(Background.EMPTY);
			costBtn[2].setBackground(Background.EMPTY);
			costBtn[0].setGraphic(ivCost[0]);
			costBtn[1].setGraphic(ivCost[1]);
			costBtn[2].setGraphic(ivCost[2]);
			
			//When clicked, a method is called which will upgrade if there are enough coins, depending on which button is clicked.
			costBtn[0].setOnAction(e -> onUpgradeClick(0));
			costBtn[1].setOnAction(e -> onUpgradeClick(1));
			costBtn[2].setOnAction(e -> onUpgradeClick(2));
			
			//All three buttons are added to a VBox.
			VBox costBox = new VBox(73, costBtn[0], costBtn[1], costBtn[2]);
			
			//backBtn2 is initialized. It is used to return to the menu Pane.
			backBtn2 = new Button();
			
			//The ImageView for backBtn2 is initialized, and set to the Button.
			ivBackBtn2 = new ImageView(imgBackBtn);
			backBtn2.setBackground(Background.EMPTY);
			backBtn2.setGraphic(ivBackBtn2);
			
			//The Image and ImageView that display the controls for the game is initialized.
			imgControl = new Image("file:images\\Controls.png.png");
			ivControl = new ImageView(imgControl);
			
			//All these objects are formatted to the GridPane.
			GridPane.setColumnSpan(controlLbl, 3);
			GridPane.setHalignment(controlLbl, HPos.CENTER);
			control.add(controlLbl, 0, 0);
			GridPane.setValignment(upgradeBox, VPos.CENTER);
			control.add(upgradeBox, 1, 1);
			GridPane.setValignment(costBox, VPos.CENTER);
			control.add(costBox, 2, 1);
			control.add(backBtn2, 2, 2);
			control.add(ivControl, 0, 1);
			
			//Link for this line of code: https://stackoverflow.com/questions/9738146/javafx-how-to-set-scene-background-image
			//This line of code allows an image to be set to the background of a GridPane as a BackgroundImage.
			control.setBackground(new Background(new BackgroundImage(imgControlBack, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
			
			//When the settingsBtn is clicked, the scene displayed is changed to controlScene.
			settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(controlScene);
					
					//The text displayed in the Labels for each upgrade are set.
					regenLbl.setText("1 heart regenerates for every\n" + maxRegenPerKill + " aliens killed.");
					moneyLbl.setText(maxCoins + " coins appear per every 50m.");
					spawnLbl.setText(maxAliens + " aliens spawn per every 50m.");
					
					//The ImageView sizes are adjusted for all the Buttons and the upgrade tree.
					ivRegen.setFitWidth(imgRegen[0].getWidth()/2);
					ivRegen.setFitHeight(imgRegen[0].getHeight()/2);
					ivMoney.setFitWidth(imgMoney[0].getWidth()/2);
					ivMoney.setFitHeight(imgMoney[0].getHeight()/2);
					ivSpawn.setFitWidth(imgSpawn[0].getWidth()/2);
					ivSpawn.setFitHeight(imgSpawn[0].getHeight()/2);
					
					ivCost[0].setFitWidth(imgCost[0].getWidth()/1.5);
					ivCost[1].setFitWidth(imgCost[1].getWidth()/1.5);
					ivCost[2].setFitWidth(imgCost[2].getWidth()/1.5);
					ivCost[0].setFitHeight(imgCost[0].getHeight()/1.5);
					ivCost[1].setFitHeight(imgCost[1].getHeight()/1.5);
					ivCost[2].setFitHeight(imgCost[2].getHeight()/1.5);
					ivBackBtn2.setFitWidth(imgBackBtn.getWidth()/1.5);
					ivBackBtn2.setFitHeight(imgBackBtn.getHeight()/1.5);
					
					//If the maximum upgrades have been reached, the Buttons are disabled (for all three if-statements).
					if (maxRegenPerKill == 3) {
						costBtn[0].setDisable(true);
					}
					
					if (maxCoins == 6) {
						costBtn[1].setDisable(true);
					}
					
					if (maxAliens == 2) {
						costBtn[2].setDisable(true);
					}
					
					//Depending on the cost of the upgrade, for each cost button, if there is not enough coins, the buttons are disabled.
					for (int i = 0; i < costBtn.length; i++) {
						if (ivCost[i].getImage().equals(imgCost[0])) {
							
							if (totalCoins < 10) {

								costBtn[i].setDisable(true);
							}
						} else if (ivCost[i].getImage().equals(imgCost[1])) {
							
							if (totalCoins < 20) {
								
								costBtn[i].setDisable(true);
							}
						} else if (ivCost[i].getImage().equals(imgCost[2])) {
							
							if (totalCoins < 30) {

								costBtn[i].setDisable(true);
							}
						} else if (ivCost[i].getImage().equals(imgCost[3]) && totalCoins >= 40) {
							
							if (totalCoins < 40) {

								costBtn[i].setDisable(true);
							}
						}
					}
				}
			});
			
			//If the back button is pressed, return to the menu (switch the scene displayed by primaryStage), and update the coinsLbl with the updated amount of coins.
			backBtn2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					primaryStage.setScene(titleScene);
					coinsLbl.setText("TOTAL COINS: " + totalCoins);
				}
			});
			
			/*
			 * The code for the game Pane is here:
			 */
			
			//Initializes the game Pane and sets the background to a specific colour.
			game = new Pane();
			game.setStyle("-fx-background-color: #000020");
			
			//Initializes the backgorund Image and both ImageViews, adjusts the size for both ImageViews, and sets the y-positions for both ImageViews.
			imgBackground = new Image("file:images\\Background.gif");
			ivBackground1 = new ImageView(imgBackground);
			ivBackground1.setFitHeight(imgBackground.getHeight() * 1.8);
			ivBackground1.setFitWidth(imgBackground.getWidth() * 1.8);
			ivBackground1.setY(0);
			ivBackground2 = new ImageView(imgBackground);
			ivBackground2.setFitHeight(imgBackground.getHeight() * 1.9);
			ivBackground2.setFitWidth(imgBackground.getWidth() * 1.8);
			ivBackground2.setY(-ivBackground1.getFitHeight());
			
			//Initializes gameScene and sets it to the size of the ivBackground1 ImageView.
			gameScene = new Scene(game, ivBackground1.getFitWidth(), ivBackground1.getFitHeight());
			
			//Initializes killsLbl, sets the text, sets the font, sets the colour to white, and sets the position of the Label.
			killsLbl = new Label("KILLS: " + kills);
			killsLbl.setFont(Font.font("MS Gothic", 36));
			killsLbl.setTextFill(Color.WHITE);
			killsLbl.setLayoutX(gameScene.getWidth() - 240);
			killsLbl.setLayoutY(10);
			
			//Initializes distanceLbl, sets the text, sets the font, sets the colour to white, and sets the position of the Label.
			distanceLbl = new Label("DISTANCE: " + totalDistance + "M");
			distanceLbl.setFont(Font.font("MS Gothic", 36));
			distanceLbl.setTextFill(Color.WHITE);
			distanceLbl.setLayoutX(gameScene.getWidth() - 295);
			distanceLbl.setLayoutY(50);
			
			//Initializes scoreLbl, sets the text, sets the font, sets the colour to white, and sets the position of the Label.
			scoreLbl = new Label("COINS: " + coins);
			scoreLbl.setFont(Font.font("MS Gothic", 36));
			scoreLbl.setTextFill(Color.WHITE);
			scoreLbl.setLayoutX(gameScene.getWidth() - 240);
			scoreLbl.setLayoutY(90);
			
			//Initializes the Spaceship object ship, and sets its location to the centre of the game Pane.
			ship = new Spaceship();
			ship.setLocation(gameScene.getWidth(), gameScene.getHeight());
			
			//Initializes the Wall object wall and sets it to a random ImageView, as well as sets its x-position (its y-position is automatically set in its constructor).
			wall = new Wall();
			wall.setRandom();
			wall.setX(gameScene.getWidth()/2 - wall.getWidth()/2);
			
			//Initializes the Bomb object bomb.
			bomb = new Bomb();
			
			//Adds all the game components to the game Pane, including the background ImageViews, the Labels, and the ImageViews for the ship, wall, and bomb.
			game.getChildren().addAll(ivBackground1, ivBackground2, ship.getNode(), wall.getNode(), bomb.getNode(), killsLbl, distanceLbl, scoreLbl);
			
			gameScene.setOnKeyReleased(new EventHandler<KeyEvent> () {
				public void handle(KeyEvent e) {
					
					//isUp is set to false is the UP ARROW key is released.
					if (e.getCode() == KeyCode.UP) {
						isUp = false;
					}
					
					//isDown is set to false is the DOWN ARROW key is released.
					if (e.getCode() == KeyCode.DOWN) {
						isDown = false;
					}
					
					//isLeft is set to false is the LEFT ARROW key is released.
					if (e.getCode() == KeyCode.LEFT) {
						isLeft = false;
					}
					
					//isRight is set to false is the RIGHT ARROW key is released.
					if (e.getCode() == KeyCode.RIGHT) {
						isRight = false;
					}
					
					//shoot is set to false to stop the ship from shooting when the E key is released.
					if (e.getCode() == KeyCode.E) {
						shoot = false;
					}
				}
			});
			
			/*
			 * The AnimationTimer code is here:
			 */
			
			animation = new AnimationTimer() {
				public void handle(long val) {
					
					//If shoot is true, the bulletTimer code (which spawns the bullets) begins. Otherwise it stops.
					if (shoot) {
						bulletTimer.play();
					} else {
						bulletTimer.stop();
					}
					
					//If there are coins spawned in the game, for each coin:
					if (coin.size() > 0) {
						for (int i = 0; i < coin.size(); i++) {
							
							//The coin moves at the same speed downward as the background.
							coin.get(i).setY(coin.get(i).getY() + backSpeed);
							
							//If the coin collides with the ship, both coins and totalCoins are incremented by one, and the coinsLbl (total coins) and scoreLbl (coins per game) are updated.
							if (coin.get(i).getNode().getBoundsInParent().intersects(ship.getObjectBounds())) {
								coins += 1;
								totalCoins+= 1;
								
								coinsLbl.setText("TOTAL COINS: " + totalCoins);
								
								scoreLbl.setText("COINS: " + coins);
								
								//The coin is removed from the gamePane and the coin ArrayList.
								coinCount--;
								game.getChildren().remove(coin.get(i).getNode());
								coin.remove(i);
							}
						}
					}
					
					//If there are aliens spawned in the game, for each alien:
					if (alien.size() > 0) {
						for (int i = 0; i < alien.size(); i++) {
							
							//Only get the ships position if the alien is a GreenAlien or GhostAlien.
							if (alien.get(i).getType() == Alien.GREEN || alien.get(i).getType() == Alien.GHOST) {
								alien.get(i).getShipPos(ship.getX(), ship.getY());
							}
							
							//If the alien is a GhostAlien, then they will move with the background (in order to perfectly follow the ship's path).
							if (alien.get(i).getType() == Alien.GHOST) {
								alien.get(i).setY(alien.get(i).getY() + backSpeed);
							}
							
							//Makes the alien move.
							alien.get(i).move();
							
							//The two if-statements below only effect the RedAliens, and essentially help the aliens bounce by switching their direction depending on how they collide with the window edges.
							if (alien.get(i).getX() < 0) {
								alien.get(i).setXDir(Alien.EAST);
							} else if (alien.get(i).getX() + alien.get(i).getWidth() > gameScene.getWidth()) {
								alien.get(i).setXDir(Alien.WEST);
							}
							
							if (alien.get(i).getY() < 0) {
								alien.get(i).setYDir(Alien.SOUTH);
							} else if (alien.get(i).getY() + alien.get(i).getHeight() > gameScene.getHeight()) {
								alien.get(i).setYDir(Alien.NORTH);
							}
							
							//If an alien is hit with a bomb, the number of aliens killed is incremented by 1, and the alien is removed from the game Pane and alien ArrayList.
							if (alien.get(i).getNode().getBoundsInParent().intersects(bomb.getObjectBounds())) {
								
								//The alien killing "Splat" sound will play.
								clips[0].play();
								
								killed++;
								
								alienCount--;
								game.getChildren().remove(alien.get(i).getNode());
								alien.remove(i);
								
								//The bomb can now be reset to launch again.
								resetBomb = true;
								
							//If an alien hits the ship, the alien is removed from the game Pane and alien ArrayList. A life is also removed.
							} else if (alien.get(i).getNode().getBoundsInParent().intersects(ship.getObjectBounds())) {
								
								//The alien killing "damage" sound will play.
								clips[3].play();
								
								alienCount--;
								game.getChildren().remove(alien.get(i).getNode());
								alien.remove(i);
								
								//A heart is remvoed from the game Pane and heart ArrayList.
								game.getChildren().remove(heart.get(heartCount).getNode());
								heart.remove(heartCount);
								heartCount--;
							
							//If the alien somehow ends up underneath the gameScene (height-wise), the alien will be removed so a new one can spawn in within the window bounds.
							} else if (alien.get(i).getY() >= gameScene.getHeight()) {
								alienCount--;
								game.getChildren().remove(alien.get(i).getNode());
								alien.remove(i);
							}
						}
					}
					
					//If there are bullets spawned in the game, for each bullet:
					if (bullet.size() > 0) {
						for (int i = 0; i < bullet.size(); i++) {
							
							//This code makes the bullet move.
							bullet.get(i).move();
							
							//If the bullet intersects with a wall, remove it.
							if (bullet.get(i).getImage().getBoundsInParent().intersects(wall.getObjectBounds())) {
								bulletCount--;
								game.getChildren().remove(bullet.get(i).getImage());
								bullet.remove(i);
								
							//If there are aliens spawned in the game, for each alien.
							} else if (alien.size() > 0) {
								for (int v = 0; v < alien.size(); v++) {
									
									//If the bullet collides with the alien, increment killed and kills, and update the killsLbl.
									if (bullet.get(i).getImage().getBoundsInParent().intersects(alien.get(v).getNode().getBoundsInParent())) {
										
										//This plays the "Splat" sound effect.
										clips[0].play();
										
										killed++;
										
										//Both the bullet and alien are removed from the game Pane and the bullet and alien ArrayLists respectively.
										bulletCount--;
										game.getChildren().remove(bullet.get(i).getImage());
										bullet.remove(i);
										
										alienCount--;
										game.getChildren().remove(alien.get(v).getNode());
										alien.remove(v);
										
										kills++;
										
										killsLbl.setText("KILLS: " + kills);
										
										//Since the bullet has hit, no more iterations of the loop are needed.
										break;
									}
								}
							}
							
						}
					}
					
					//If the aliens killed is greater than or equal to the number needed to gain a life, add one more life (in the form of a heart object) to the game Pane and heart ArrayList.
					if (killed >= maxRegenPerKill) {
						heartCount++;
						heart.add(heartCount, new Heart());
						heart.get(heartCount).setY(10);
						heart.get(heartCount).setX(heartCount * 20 + 10);
						game.getChildren().add(heart.get(heartCount).getNode());
						
						//Reset killed to 0.
						killed = 0;
					}
					
					//Sets the movement for the bomb and updates the bomb ImageView's position.
					bomb.move();
					bomb.getNode();
					
					//If the bomb is being reset, then the bomb is removed form the game Pane.
					if (resetBomb) {
						game.getChildren().remove(bomb.getNode());
					//If the bomb ImageView is not contained in the game Pane and the bomb is not reset, add the bomb to the game Pane.
					} else if (!game.getChildren().contains(bomb.getNode()) && !resetBomb) {
						game.getChildren().add(bomb.getNode());
					}
					
					//This code makes it so the bomb, wall, and two backgrounds move according to the background speed.
					bomb.setY(bomb.getY() + backSpeed);
					ivBackground1.setY(ivBackground1.getY() + backSpeed);
					ivBackground2.setY(ivBackground2.getY() + backSpeed);
					wall.setY(wall.getY() + backSpeed);
					
					if (ivBackground1.getY() >= gameScene.getHeight()) {
						ivBackground1.setY(-ivBackground1.getFitHeight());
					} else if (ivBackground2.getY() >= gameScene.getHeight()) {
						ivBackground2.setY(-ivBackground2.getFitHeight());
					}
					
					//This resets the wall to the top of the window, once it has crossed the bottom of the window, and sets it to a random ImageView.
					if (wall.getY() >= gameScene.getHeight()) {
						wall.setY(-wall.getHeight());
						wall.setRandom();
						
						//Both totalDistance and distance are incremented by 50, and the distanceLbl is updated to match.
						totalDistance += 50;
						distance += 50;
						
						distanceLbl.setText("DISTANCE: " + totalDistance + "M");
					}
					
					//If distance is equal to 50 and the background speed is less than or equal to 12:
					if(distance == 50 && backSpeed <= 12) {
						
						//Add the number of coins according to maxCoins (it will increase according to the upgrades).
						for (int i = 0; i < maxCoins; i++) {
							coinCount++;
							coin.add(coinCount, new Coin());
							
							//Sets coinIntersects to false.
							coinIntersects = false;
							
							//The while loop will continue to set the coin object to a new location until it is not intersecting with a wall or another coin.
							while (true) {
								
								coin.get(coinCount).setLocation(gameScene.getWidth(), gameScene.getHeight());
								
								if (!coin.get(coinCount).getNode().getBoundsInParent().intersects(wall.getObjectBounds())) {
									coinIntersects = false;
								} else if (i > 0) {
									
									//This for-loop runs through each coin other than itself to see if they are intersecting.
									for (int c = i; c > -1; c--) {
										if (coin.get(c).getNode().getBoundsInParent().intersects(coin.get(i).getNode().getBoundsInParent())) {
											coinIntersects = true;
											break;
										} else {
											coinIntersects = false;
										}
									}
								}
								
								coin.get(coinCount).setY(coin.get(coinCount).getY() - gameScene.getHeight());
								
								if (!coinIntersects) {
									break;
								}
							}
							
							//If none of the coins intersect, they are added to the game Pane.
							game.getChildren().add(coin.get(coinCount).getNode());
							
						}
						
						//For each 50m, the background speed and ship speed are increased, and distance is reset.
						backSpeed += 0.3;
						shipSpeed += 0.2;
						distance = 0;
					}
					
					//If the bomb leaves the window bounds, restBomb is set to true.
					if (bomb.getX() + bomb.getWidth() < 0 || bomb.getX() > gameScene.getWidth()) {
						resetBomb = true;
					}
					
					//If the bomb intersects with the wall:
					if (bomb.getObjectBounds().intersects(wall.getObjectBounds())) {
						
						//If the bomb moves east and hits the left side of the wall, then the bomb is reset.
						if (bomb.getDirection() == Bomb.EAST) {
							if (ship.getX() < wall.getBoundsX()) {
								resetBomb = true;
							}
						}
						
						//If the bomb moves west and hits the right side of the wall, then the bomb is reset.
						if (bomb.getDirection() == Bomb.WEST) {
							if (ship.getX() > wall.getBoundsX()) {
								resetBomb = true;
							}
						}
					}
					
					//This is the code for if the ship collides with a wall. It is written so that same code works for any variant of the wall ImageView.
					if (ship.getObjectBounds().intersects(wall.getObjectBounds())) {
						
						//The ship can be dragged out of the window if blocked by a wall, thereby losing a heart.
						containInBounds = false;
						
						//If the ship is moving left, and hits the right edge of the wall.
						if (isLeft) {
							if (ship.getX() > wall.getBoundsX()) {
								
								//If the ship is above or below the wall, there is no obstruction to stop it from moving left.
								//The y-positions are adjusted by backSpeed so that the ship doesn't end up going through the wall due to it moving downwards while the ship does not.
								if (ship.getY() >= wall.getY()) {
									ship.moveY(backSpeed);
								} else if ((ship.getY() + ship.getHeight()) <= (wall.getY() + wall.getHeight())) {
									ship.moveY(-backSpeed);
								//Otherwise, the moveX method is called to move the ship in the opposite direction by the same speed, thereby canceling the movement out.
								} else {
									ship.moveX(7 + shipSpeed);
								}
								
							}
						}
						
						//If the ship is moving right, and hits the left edge of the wall.
						if (isRight) {
							if (ship.getX() < wall.getBoundsX()) {
								
								//If the ship is above or below the wall, there is no obstruction to stop it from moving right.
								//The y-positions are adjusted by backSpeed so that the ship doesn't end up going through the wall due to it moving downwards while the ship does not.
								if (ship.getY() >= wall.getY()) {
									ship.moveY(backSpeed);
								} else if ((ship.getY() + ship.getHeight()) <= (wall.getY() + wall.getHeight())) {
									ship.moveY(-backSpeed);
								//Otherwise, the moveX method is called to move the ship in the opposite direction by the same speed, thereby canceling the movement out.
								} else {
									ship.moveX(-7 - shipSpeed);
								}
								
							}
						}
						
						//Calls the moveY method to move the ship in the opposite direction by the same speed to cancel the movement out (if it is below the wall and moving upwards).
						if ((ship.getY() > wall.getY()) && isUp) {
							ship.setY(ship.getY() + 4 + shipSpeed);
						}
						
						//Calls the moveY method to move the ship in the opposite direction by the same speed to cancel the movement out (if it is above the wall and moving downwards).
						if ((ship.getY() < wall.getY()) && isDown) {
							ship.setY(ship.getY() - 7 - shipSpeed);
						}
						
						ship.setY(ship.getY() + backSpeed);
						
					} else {
					//If the ship and wall have not collided, the ship cannot leave the window bounds.
						containInBounds = true;
					}
					
					//Below is the movement code for the ship in each direction. If any of the booleans are true from the gameScene.setOnKeyPressed, they will move by according to the corresponding
					//speed by the moveY or moveX method. The isUp speed is less than the other directions to make the game harder.
					if (isUp) {
						ship.moveY(-4 - shipSpeed);
					}
					
					if (isDown) {
						ship.moveY(7 + shipSpeed);
					}
					
					if(isLeft) {
						ship.moveX(-7 - shipSpeed);
					}
					
					if (isRight) {
						ship.moveX(7 + shipSpeed);
					}
					
					//This code keeps the ship within the bounds of the screen (by x-position).
					if (ship.getX() <= 0) {
						ship.setX(0);
					} else if (ship.getX() + ship.getWidth() >= gameScene.getWidth()) {
						ship.setX(gameScene.getWidth() - ship.getWidth());
					}
						
					//This code keeps the ship within the bounds of the screen (by y-position, but only if containInBounds is true).
					if (containInBounds) {
						if (ship.getY() <= 0) {
							ship.setY(0);
						} else if (ship.getY() + ship.getHeight() >= gameScene.getHeight()) {
							ship.setY(gameScene.getHeight() - ship.getHeight());
						}
						
					//If containInBounds is false, that mostly means the shipis being dragged out of the window by the wall, so a heart is removed, and the ship position is set back into the window bounds.
					} else {
						
						if (ship.getY() >= gameScene.getHeight()) {
							
							//The "damage" sound is played.
							clips[3].play();
							
							ship.setY(gameScene.getHeight() - ship.getHeight());
							game.getChildren().remove(heart.get(heartCount).getNode());
							heart.remove(heartCount);
							heartCount--;
						}
					}
					
					Platform.runLater(new Runnable() {
						public void run() {
							
							//Since lives are measured by hearts, if the heartCount is -1, it is game over.
							if (heartCount == -1) {
								
								//The "Death" sound plays.
								clips[2].play();
								
								//The AnimationTimer, and alienTimer, bulletTimer, and bombTimer Timelines are stopped.
								bulletTimer.stop();
								alienTimer.stop();
								bombTimer.stop();
								animation.stop();
								
								//isUp, isDown, isLeft, isRight, and shoot are all set back to false.
								isUp = false;
								isDown = false;
								isLeft = false;
								isRight = false;
								
								shoot = false;
								
								//The new score is added to the leaderboard (the name has already been added with getName() in the playBtn.setOnAction().
								addToLeaderBoard(totalDistance, kills, coins);
								
								//totalDistance, coins, and kills are reset.
								totalDistance = 0;
								coins = 0;
								kills = 0;
								
								//Their Labels are also reset for the next time the player plays clicks playBtn.
								distanceLbl.setText("DISTANCE: " + totalDistance + "M");
								scoreLbl.setText("COINS: " + coins);
								killsLbl.setText("KILLS: " + kills);
								
								//primaryStage is set back to the titleScene (main menu).
								primaryStage.setScene(titleScene);
								
								
							}
						}
					});
				}
			};
			
			//All the bomb timer does is set hasBomb back to true to signal whether the bomb can be fired, every 2.2 seconds.
			KeyFrame bombKf = new KeyFrame(Duration.millis(2200), new EventHandler<ActionEvent> () {
				public void handle(ActionEvent e) {
					
					hasBomb = true;
				}
			});
			
			//Sets up the bombTimer Timeline to the bombKf KeyFrame, and sets it to run indefinitely.
			bombTimer = new Timeline(bombKf);
			bombTimer.setCycleCount(Timeline.INDEFINITE);
			
			//The "Laser" sound is played and a Bullet is added to the game Pane and bullet ArrayList, every 0.5 seconds.
			KeyFrame bulletKf = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent> () {
				public void handle(ActionEvent e) {
					
					clips[1].play();
					bulletCount++;
					bullet.add(bulletCount, new Bullet());
					bullet.get(bulletCount).setLocation(ship.getX(), ship.getY(), ship.getWidth());
					game.getChildren().add(bullet.get(bulletCount).getImage());
				}
			});
			
			//Sets up the bulletTimer Timeline to the bombKf KeyFrame, and sets it to run indefinitely.
			bulletTimer = new Timeline(bulletKf);
			bulletTimer.setCycleCount(Timeline.INDEFINITE);
			
			//Every 3 seconds, an Alien is spawned.
			KeyFrame alienKf = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent> () {
				public void handle(ActionEvent e) {
					
					//If there are less Aliens than maxAliens specifies, spawn more aliens. As maxAliens decreases due to upgrades, so will the Aliens spawned.
					if (alienCount < maxAliens - 1) {
						
						alienCount++;
						
						//The type of Alien is randomly chosen and then initialized into the ArrayList.
						alienType = rand.nextInt(3);
						
						if (alienType == 0) {
							alien.add(alienCount, new RedAlien());
						} else if (alienType == 1) {
							alien.add(alienCount, new GreenAlien());
						} else if (alienType == 2) {
							alien.add(alienCount, new GhostAlien());
						}
						
						//If the Alien is a RedAlien or GreenAlien, repeatedly set the location until it is not intersecting with the wall. Ghost Aliens just follow the layer form the initial
						//position of xPos = 0, yPos = 0.
						while(alienType != 2) {
							alien.get(alienCount).setLocation(gameScene.getWidth(), gameScene.getHeight());
							
							if (!alien.get(alienCount).getNode().intersects(wall.getObjectBounds())) {
								break;
							}
						}
						
						//Sets the speed of the Alien randomly and adds it into the game Pane.
						alien.get(alienCount).setSpeed();
						game.getChildren().add(alien.get(alienCount).getNode());
					}
				}
			});
			
			//Sets up the alienTimer Timeline to the bombKf KeyFrame, and sets it to run indefinitely.
			alienTimer = new Timeline(alienKf);
			alienTimer.setCycleCount(Timeline.INDEFINITE);
			
			//Makes the window non-resizable and sets the window title to "Alien Attack".
			primaryStage.setResizable(false);
			primaryStage.setTitle("Alien Attack");
			
			//Adds the Spaceship ImageView as the Icon for the window.
			primaryStage.getIcons().add(ship.getNode().getImage());
			
			//Centres the window on the screen.
			primaryStage.centerOnScreen();
			
			//Sets the scene for primaryStage to the titleScene (main menu) by default, and makes it visible.
			primaryStage.setScene(titleScene);
			primaryStage.show();
			
			//Before the window is closed, a for-loop is used to rewrite leaderboard.txt with the newly updated list of scores.
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent e) {
					try {
						out = new FileWriter(boardFile);
						writer = new BufferedWriter(out);
						
						for (int i = 0; i < namesList.size(); i++) {
							
							writer.write(namesList.get(i) + " " + distanceList.get(i) + " " + killsList.get(i) + " " + coinsList.get(i) + "\n");
						}
						
						writer.write(" COINS: " + totalCoins);
						
						writer.close();
						out.close();
						
						System.out.print(totalCoins);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					//Sets upgrade status sets "upgrades.txt" to the new upgrade status.
					setUpgradeStatus();
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//This method reads "leaderboard.txt" line by line and adds the names, distances, coins, and kills for each score into the corresponding list: namesList, distanceList, killsList, coinsList.
	public void readLeaderBoard() throws Exception {
		//Initializes the FileReader and BufferedReader.
		in = new FileReader(boardFile);
		reader = new BufferedReader(in);
		
		String line;
		String[] pieces;
		
		while((line = reader.readLine()) != null) {
			
			//If the line contains "COINS", it is used to update totalCoins to match that of a previous running of the game.
			if (line.contains("COINS:")) {
				totalCoins = Integer.parseInt(line.substring(8));
				
				
			} else {
				
				pieces = line.split(" ");
				
				//Adding the individual pieces (pun intended) to the ArrayLists.
				namesList.add(pieces[0]);
				distanceList.add(Integer.parseInt(pieces[1]));
				killsList.add(Integer.parseInt(pieces[2]));
				coinsList.add(Integer.parseInt(pieces[3]));
			}
		}
		
		//Closes the FileReader and BufferedReader.
		in.close();
		reader.close();
	}
	
	//This method updates the boardFile and ArrayLists with a new score.
	public void addToLeaderBoard(int dist, int killNum, int coinNum) {
		try {
			
			String newName = name;
			
			//This helps remove errors when reading the boardFile, but removing blank spaces in the name, and replacing them with underscores.
			if (name.contains(" ")) {
				String[] pieces = name.split(" ");
				
				newName = "";
				
				for (String piece : pieces) {
					
					if (newName.equals("")) {
						newName = newName + piece;
					} else {
						newName = newName + "_" + piece;
					}
				}
			}
			
			//Initializing FileWriter and BufferedWriter.
			out = new FileWriter(boardFile, true);
			writer = new BufferedWriter(out);
			
			//Writing to the boardFile.
			writer.write("\n" + newName + " " + dist + " " + killNum + " " + coinNum);
			
			//Adding to the ArrayLists.
			namesList.add(newName);
			distanceList.add(dist);
			killsList.add(killNum);
			coinsList.add(coinNum);
			
			//Closes the FileWriter and BufferedWriter.
			writer.close();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//This method uses insertion sort to sort the leaderboard.
	public void sortLeaderBoard(int sortBy) {
		try {
			
			//Initializes 2D array and ArrayList for sorting.
			newOrderList = new int[distanceList.size()][3];
			newNamesList = new String[distanceList.size()];
			
			//Fills up the 2D array and ArrayList with the contents of the original ArrayLists.
			for (int r = 0; r < newOrderList.length; r++) {
				for (int c = 0; c < newOrderList[r].length; c++) {
					if (c == 0) {
						newOrderList[r][c] = distanceList.get(r);
					} else if (c == 1) {
						newOrderList[r][c] = killsList.get(r);
					} else if (c == 2) {
						newOrderList[r][c] = coinsList.get(r);
					}
				}
				
				newNamesList[r] = namesList.get(r);
			}
			
			//This part is just simple insertion sort code.
			for (int end = 1; end < newOrderList.length; end++) {
				
				int dist = newOrderList[end][0];
				int killNum = newOrderList[end][1];
				int coinNum = newOrderList[end][2];
				String player = newNamesList[end];
				
				int i = end;
				
				
				//These if and else-if statements use the while loops to control which to sort by: coins, kills, or distance.
				//Since we are using a 2D array, it becomes easier to sort everything by one of these options.
				if (sortBy == DIST) {
					
					while (i > 0 && dist < newOrderList[i - 1][0]) {
						
						newOrderList[i][0] = newOrderList[i - 1][0];
						newOrderList[i][1] = newOrderList[i - 1][1];
						newOrderList[i][2] = newOrderList[i - 1][2];
						newNamesList[i] = newNamesList[i - 1];
						
						i--;
					}
				} else if (sortBy == KILLS) {
					
					while (i > 0 && killNum < newOrderList[i - 1][1]) {
						
						newOrderList[i][0] = newOrderList[i - 1][0];
						newOrderList[i][1] = newOrderList[i - 1][1];
						newOrderList[i][2] = newOrderList[i - 1][2];
						newNamesList[i] = newNamesList[i - 1];
						
						i--;
					}
				} else if (sortBy == COINS) {
					
					while (i > 0 && coinNum < newOrderList[i - 1][2]) {
						
						newOrderList[i][0] = newOrderList[i - 1][0];
						newOrderList[i][1] = newOrderList[i - 1][1];
						newOrderList[i][2] = newOrderList[i - 1][2];
						newNamesList[i] = newNamesList[i - 1];
						
						i--;
					}
				}
				
				newOrderList[i][0] = dist;
				newOrderList[i][1] = killNum;
				newOrderList[i][2] = coinNum;
				newNamesList[i] = player;
				
			}
			
			//Stops the code form bugging out, by disabling a sort button if leaderboard is already displaying its sorted form.
			if (sortBy == DIST) {
				
				byDistBtn.setDisable(true);
				byKillsBtn.setDisable(false);
				byCoinsBtn.setDisable(false);
				
			} else if (sortBy == KILLS) {
				
				byKillsBtn.setDisable(true);
				byCoinsBtn.setDisable(false);
				byDistBtn.setDisable(false);
				
			} else if (sortBy == COINS) {
				
				byCoinsBtn.setDisable(true);
				byDistBtn.setDisable(false);
				byKillsBtn.setDisable(false);
			}
			
			//The leaderboard TextArea is cleared and then updated with the new sort list of scores.
			highScoreTxt.clear();
			highScoreTxt.setText("LEADERBOARD\n\n");
			
			for (int i = newOrderList.length - 1; i >= 0; i--) {
				highScoreTxt.appendText("\n" + newNamesList[i] + "\nDistance..." + 
			newOrderList[i][0] + "\nKills..." + newOrderList[i][1] + "\nCoins..." + newOrderList[i][2] + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//This is used to update the namesList ArrayList for the leaderboard.
	public void getName() {
		
		//If TextField is not empty, the username will be set by the player's input in the TextField. Otherwise, the name will be set to "SUSSY UNKNOWN".
		if (!nameField.getText().isEmpty()) {
			name = nameField.getText();
		} else {
			name = "SUSSY UNKNOWN";
		}
	}
	
	//This method reads the upgrade status from upgradeFile and sets the upgrades up.
	public void getUpgradeStatus() {
		try {
			
			//Initializing FileReader and BufferedReader.
			in = new FileReader(upgradeFile);
			reader = new BufferedReader(in);
			
			String line = reader.readLine();
			
			String[] pieces = line.split(" ");
			
			//Initializing the ImageView array for costBtns.
			ivCost = new ImageView[3];
			
			//The Images displayed by the ImageViews are set by the number taken from the pieces array.
			ivRegen = new ImageView(imgRegen[Integer.parseInt(pieces[0])]);
			ivCost[0] = new ImageView(imgCost[Integer.parseInt(pieces[1])]);
			ivMoney = new ImageView(imgMoney[Integer.parseInt(pieces[2])]);
			ivCost[1] = new ImageView(imgCost[Integer.parseInt(pieces[3])]);
			ivSpawn = new ImageView(imgSpawn[Integer.parseInt(pieces[4])]);
			ivCost[2] = new ImageView(imgCost[Integer.parseInt(pieces[5])]);
			
			//Using the Image in the ImageView, we can check which Image it corresponds to in the imgRegen array to set the maxRegenPerKill.
			if (ivRegen.getImage().equals(imgRegen[0])) {
				
				maxRegenPerKill = 7;
			} else if (ivRegen.getImage().equals(imgRegen[1])) {
				
				maxRegenPerKill = 6;
			} else if (ivRegen.getImage().equals(imgRegen[2])) {
				
				maxRegenPerKill = 5;
			} else if (ivRegen.getImage().equals(imgRegen[3])) {
				
				maxRegenPerKill = 4;
			} else if (ivRegen.getImage().equals(imgRegen[4])) {
				
				maxRegenPerKill = 3;
			}
			
			//Using the Image in the ImageView, we can check which Image it corresponds to in the imgMoney array to set the maxCoins.
			if (ivMoney.getImage().equals(imgMoney[0])) {
				
				maxCoins = 2;
			} else if (ivMoney.getImage().equals(imgMoney[1])) {
				
				maxCoins = 3;
			} else if (ivMoney.getImage().equals(imgMoney[2])) {
				
				maxCoins = 4;
			} else if (ivMoney.getImage().equals(imgMoney[3])) {
				
				maxCoins = 5;
			} else if (ivMoney.getImage().equals(imgMoney[4])) {
				
				maxCoins = 6;
			}
			
			//Using the Image in the ImageView, we can check which Image it corresponds to in the imgSpawn array to set the maxAliens.
			if (ivSpawn.getImage().equals(imgSpawn[0])) {
				
				maxAliens = 6;
			} else if (ivSpawn.getImage().equals(imgSpawn[1])) {
				
				maxAliens = 5;
			} else if (ivSpawn.getImage().equals(imgSpawn[2])) {
				
				maxAliens = 4;
			} else if (ivSpawn.getImage().equals(imgSpawn[3])) {
				
				maxAliens = 3;
			} else if (ivSpawn.getImage().equals(imgSpawn[4])) {
				
				maxAliens = 2;
			}
			
			//Closes the FileReader and BufferedReader.
			in.close();
			reader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//This method sets the updated upgrade status by writing it into the upgradeFile.
	public void setUpgradeStatus() {
		try {
			
			//Initial values of regNum, moneyNum, and spawnNum.
			int regNum = -1, moneyNum = -1, spawnNum = -1;
			
			//Initializing the cost array.
			int cost[] = new int[3];
			
			//Using the Image in the ImageView, we can check which Image it corresponds to in the imgRegen array to set the regNum.
			if (ivRegen.getImage().equals(imgRegen[0])) {
				regNum = 0;
				maxRegenPerKill = 7;
			} else if (ivRegen.getImage().equals(imgRegen[1])) {
				regNum = 1;
				maxRegenPerKill = 6;
			} else if (ivRegen.getImage().equals(imgRegen[2])) {
				regNum = 2;
				maxRegenPerKill = 5;
			} else if (ivRegen.getImage().equals(imgRegen[3])) {
				regNum = 3;
				maxRegenPerKill = 4;
			} else if (ivRegen.getImage().equals(imgRegen[4])) {
				regNum = 4;
				maxRegenPerKill = 3;
			}
			
			//Using the Image in the ImageView, we can check which Image it corresponds to in the imgMoney array to set the moneyNum.
			if (ivMoney.getImage().equals(imgMoney[0])) {
				moneyNum = 0;
				maxCoins = 2;
			} else if (ivMoney.getImage().equals(imgMoney[1])) {
				moneyNum = 1;
				maxCoins = 3;
			} else if (ivMoney.getImage().equals(imgMoney[2])) {
				moneyNum = 2;
				maxCoins = 4;
			} else if (ivMoney.getImage().equals(imgMoney[3])) {
				moneyNum = 3;
				maxCoins = 5;
			} else if (ivMoney.getImage().equals(imgMoney[4])) {
				moneyNum = 4;
				maxCoins = 5;
			}
			
			//Using the Image in the ImageView, we can check which Image it corresponds to in the imgSpawn array to set the spawnNum.
			if (ivSpawn.getImage().equals(imgSpawn[0])) {
				spawnNum = 0;
				maxAliens = 6;
			} else if (ivSpawn.getImage().equals(imgSpawn[1])) {
				spawnNum = 1;
				maxAliens = 5;
			} else if (ivSpawn.getImage().equals(imgSpawn[2])) {
				spawnNum = 2;
				maxAliens = 4;
			} else if (ivSpawn.getImage().equals(imgSpawn[3])) {
				spawnNum = 3;
				maxAliens = 3;
			} else if (ivSpawn.getImage().equals(imgSpawn[4])) {
				spawnNum = 4;
				maxAliens = 2;
			}
			
			//For each Image in the ImageView in ivCost, we can check which Image it corresponds to in the imgCost array to set the the corresponding cost int value.
			for (int i = 0; i < 3; i++) {
				if (ivCost[i].getImage().equals(imgCost[0]))
					cost[i] = 0;
				else if (ivCost[i].getImage().equals(imgCost[1]))
					cost[i] = 1;
				else if (ivCost[i].getImage().equals(imgCost[2]))
					cost[i] = 2;
				else if (ivCost[i].getImage().equals(imgCost[3]))
					cost[i] = 3;
			}
			
			//Initializing the FileWriter and BufferedWriter.
			out = new FileWriter(upgradeFile);
			writer = new BufferedWriter(out);
			
			//Writing the new updated upgrade status.
			writer.write(regNum + " " + cost[0] + " " + moneyNum + " " + cost[1] + " " + spawnNum + " " + cost[2]);
			
			//Closes the FileWriter and BufferedWriter.
			writer.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//This method updates the corresponding upgrade tree and cost button.
	public void onUpgradeClick(int nButton) {
		
		//These if-statements check if the the totalCoins is greater than the cost (10, 20, 30, or 40), in which case they set the ImageView for the corresponding upgrade tree to the button
		//to the next Image in the list. setDisable() is set to false (except for 40 where no more upgrades are available) in case it is set to true beforehand. If the upgrade can be purchased,
		//the cost is deducted from the totalCoins.
		if (ivCost[nButton].getImage().getUrl().contains("10")) {
			
			if (totalCoins >= 10) {
				
				costBtn[nButton].setDisable(false);
				ivCost[nButton].setImage(imgCost[1]);
				totalCoins = totalCoins - 10;
			}
		} else if (ivCost[nButton].getImage().getUrl().contains("20")) {
			
			if (totalCoins >= 20) {
				
				costBtn[nButton].setDisable(false);
				ivCost[nButton].setImage(imgCost[2]);
				totalCoins = totalCoins - 20;
			}
		} else if (ivCost[nButton].getImage().getUrl().contains("30")) {
			
			if (totalCoins >= 30) {
				
				costBtn[nButton].setDisable(false);
				ivCost[nButton].setImage(imgCost[3]);
				totalCoins = totalCoins - 30;
			}
		} else if (ivCost[nButton].getImage().getUrl().contains("40")) {
			
			if (totalCoins >= 40) {
				
				costBtn[nButton].setDisable(true);
				totalCoins = totalCoins - 40;
			}
		}
		
		//After deducting the coins, a for-loop checks if the player still has enough coins to make a purchase for all 3 cost buttons. If they do not, the button is disabled.
		for (int i = 0; i < 3; i++) {
			if (ivCost[i].getImage().getUrl().contains("10") && totalCoins < 10) {
				costBtn[i].setDisable(true);
			} else if (ivCost[i].getImage().getUrl().contains("20") && totalCoins < 20) {
				costBtn[i].setDisable(true);
			} else if (ivCost[i].getImage().getUrl().contains("30") && totalCoins < 30) {
				costBtn[i].setDisable(true);
			} else if (ivCost[i].getImage().getUrl().contains("40") && totalCoins < 40) {
				costBtn[i].setDisable(true);
			}
		}
		
		//If the cost button corresponds to the ivRegen upgrade tree, then the ImageView is updated, and so is the maxRegenPerKill.
		if (nButton == 0) {
			if (ivRegen.getImage().equals(imgRegen[0])) {
				ivRegen.setImage(imgRegen[1]);
				maxRegenPerKill = 6;
			} else if (ivRegen.getImage().equals(imgRegen[1])) {
				ivRegen.setImage(imgRegen[2]);
				maxRegenPerKill = 5;
			} else if (ivRegen.getImage().equals(imgRegen[2])) {
				ivRegen.setImage(imgRegen[3]);
				maxRegenPerKill = 4;
			} else if (ivRegen.getImage().equals(imgRegen[3])) {
				ivRegen.setImage(imgRegen[4]);
				maxRegenPerKill = 3;
			}
			
		//If the cost button corresponds to the ivMoney upgrade tree, then the ImageView is updated, and so is the maxCoins.
		} else if (nButton == 1) {
			if (ivMoney.getImage().equals(imgMoney[0])) {
				ivMoney.setImage(imgMoney[1]);
				maxCoins = 3;
			} else if (ivMoney.getImage().equals(imgMoney[1])) {
				ivMoney.setImage(imgMoney[2]);
				maxCoins = 4;
			} else if (ivMoney.getImage().equals(imgMoney[2])) {
				ivMoney.setImage(imgMoney[3]);
				maxCoins = 5;
			} else if (ivMoney.getImage().equals(imgMoney[3])) {
				ivMoney.setImage(imgMoney[4]);
				maxCoins = 6;
			}
			
		//If the cost button corresponds to the ivSpawn upgrade tree, then the ImageView is updated, and so is the maxAliens.
		} else if (nButton == 2) {
			if (ivSpawn.getImage().equals(imgSpawn[0])) {
				ivSpawn.setImage(imgSpawn[1]);
				maxAliens = 5;
			} else if (ivSpawn.getImage().equals(imgSpawn[1])) {
				ivSpawn.setImage(imgSpawn[2]);
				maxAliens = 4;
			} else if (ivSpawn.getImage().equals(imgSpawn[2])) {
				ivSpawn.setImage(imgSpawn[3]);
				maxAliens = 3;
			} else if (ivSpawn.getImage().equals(imgSpawn[3])) {
				ivSpawn.setImage(imgSpawn[4]);
				maxAliens = 2;
			}
		}
		
		//The Labels are then updated to display the result of the upgrades.
		regenLbl.setText("1 heart regenerates for every\n" + maxRegenPerKill + " aliens killed.");
		moneyLbl.setText(maxCoins + " coins appear per every 50m.");
		spawnLbl.setText(maxAliens + " aliens spawn per every 50m.");
	}
}
