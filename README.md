# Attack-of-the-Aliens

## Program Description: 

This game is a space shooter, where the player controls a ship that shoots lasers and bombs at enemy aliens. The player is able to move up, down, left, and right, as well as diagonally. The ship movement is controlled by the arrow keys. Note that moving up is slower than moving down or to the side (this is to increase the difficulty when trying to avoid aliens). There is also a moving background, which speeds up as the game goes on. The ships speed will increase proportionally to the speed of the background. To shoot lasers, the 'E' key must be pressed. The laser will repeatedly shoot at a rate of one shot per 0.5 seconds, as long as the key is pressed. All aliens will die as soon as they are hit by a laser. The ship can also shoot bombs from the sides, by pressing the 'A' and 'D' keys. The 'A' key will shoot a bomb from the left side of the ship. The 'D' key will shoot a bomb from the right side of the ship. The bomb also moves with the background. Bomb can only be fired at a rate of one firing per 2.2 seconds.

There are walls that act as boundaries that the ship may pass through in order to continue in the game and move with the background. If the ship does not pass through the boundary then it will be pushed off the screen by the boundary, resulting in a loss of one life. There are three different types of boundaries - one that has an opening on the left, one that has an opening on the right, and one that has an opening on both sides. To pass a boundary, the ship must travel through the opening. Walls also act as boundaries that measure every 50m in-game.

Since the walls move with the moving background, this can increase the difficulty of the game, because the walls become harder to avoid the faster the speed of the background gets. Also, since the speed of the ship movement also increases with the moving background, it tends to make the ship faster but also harder to maneuver at higher speeds.

The player will have three lives in the beginning of the game, and can also lose a life if hit by an alien. There are three types of aliens - red, green, and ghost. Red aliens move by bouncing off the edge of the window after spawning. This ricocheting makes their movement unpredictable. Green aliens approach the x and y-coordinate of the ship, making them easier to avoid and shoot from a distance (it is difficult to hit them when they get close). Ghost aliens tend to follow the exact path of the ship, forcing the player to constantly move the ship to new positions to avoid getting hit. Lives can also be gained if enough aliens are killed.

Coins also spawn in the game. They spawn at random x and y-coordinates on the screen, and move with the background. Coins act as currency in the game to get upgrades. They can only be collected by colliding with them using the ship. By default, 6 aliens will spawn per every 50m, 2 coins will spawn per every 50m, and 1 life will be gained per every 7 aliens killed. During gameplay, the top-right side of the window will display the distance traveled, coins collected, and aliens killed. The total amount of coins collected (not just from the most recent game) will be displayed in the title screen.

The game begins with the title screen. The title screen will have a TextField that will allow the player to input their chosen name. This name will later appear in the leaderboard. If they do not choose a name, the name will be set to the default "SUSSY UNKNOWN". Players must click the play Button to play the game. To see the controls and upgrades, players must click the settings Button. This will change the window to a different Scene, that displays an Image of the controls, and three upgrade trees and corresponding Buttons. 

Upgrades will require coins to get upgrades that decrease the amount of aliens that spawn by one, increase the number of coins that spawn by one, and decrease the amount of aliens the player needs to kill to gain a new life. The amount of coins required increases per each upgrade. For example for the 1st upgrade of the coin spawn tree, the price would be 10 coins. For the second, it would be 20 coins, 30 coins for the third, and 40 for the final upgrade. This means that a total of 100 coins are required to fully upgrade a tree. To get all the upgrades, the player would need 300 coins.

To access the leaderboard from the title screen, the player must press the score Button. This will display all the scores in chronological order (the most recent score would be at the bottom of the leaderboard). There are three Buttons that will allow the player to sort the leaderboard by the distance traveled, coins collected, and aliens killed from highest to lowest.

## Program Details: 

### Images: 
There are images for the game background (imgBackground), title background (imgTitle), play button (imgPlayButton), settings button (imgSettings), score button (imgHighScore), the back button for the leaderboard (imgBackbtn), the button to sort scores by distance (imgSortDist), the button to sort scores by coins (imgSortCoins), the button to sort scores by kills (imgSortKills), the back button for the settings (imgControlBack), the background for the settings background (imgControl). There are also arrays of Images used for the upgrade trees, (imgRegen, imgCost, imgMoney, imgSpawn).

### ImageViews: 
There are corresponding ImageViews for each Image, however there is also ivRegen, ivMoney, and ivSpawn which display the current Images for the upgrade trees. imgCost actually displays the cost for each upgrade of the trees, so it also has three corresponding ImageView arrays for each upgrade tree.
 * Spaceship: There is one Spaceship object called ship, which the player will control. It will always spawn in the centre of the game screen.
 * Wall: There is one wall object that crosses and re-crosses the screen with the background. Each time it crosses, the Image and boundaries for the object are randomly reset.
 * Bomb: There is only one bomb object that relocates at the ship when A or D are pressed at a rate of one firing per 2.2 seconds. The Image displayed faces left or right depending on whether A or D are pressed.

### ArrayLists: 
There are 4 object ArrayLists that keep track of the multiple Bullet objects, Alien objects, Heart objects, and Coin objects spawned during gameplay. There are three Integer ArrayLists that read previous kills, coins, and distance scores from the "leaderboard.txt" file. There is also a String ArrayList that reads usernames from the "leaderboard.txt" file (bullet, alien, heart, coin, killsList, distanceList, coinsList, namesList).

### 2D Array: 
newOrderList is a 2D array that combines the killsList, distanceList, and coinsList ArrayLists for sorting in the leaderboard.

### TextField: 
nameField is a TextField that appears in the title screen, and allows players to input their username. This username is only added to the leaderboard if the game is played.

### TextArea: 
highScoreTxt is a TextArea used to display the leaderboard on the main screen (rather than open a new pane).

### Buttons: 
On the menu Pane, there is a play button (playBtn), settings button (settingsBtn), and score button (scoreBtn) There are 2 back buttons (backBtn1, and backBtn2) for returning to the menu from settings and the leaderboard. In the settings, there is the aforementioned back buttons, as well as an array of Buttons that display the cost of upgrading (using the ivCost ImageView array). In the leaderboard, there are three buttons that display using corresponding ImageViews (byCoinsBtn, byKillsBtn, and byDistBtn) that sort by aliens killed, coins collected, and distance traveled.

There is a FileReader, FileWriter, BufferedReader, and BufferedWriter for reading and writing to and from files.

### Files: 
The game uses boardFile ("leaderboard.txt") to store and retrieve the high scores of each attempt (name, distance traveled, aliens killed, coins collected). upgradeFile ("upgrades.txt") is used to keep track of upgrades and coin costs. Finally, songFile is used to access the background music for the Media and MediaPlayer objects to play on repeat throughout the game.

### AudioClip array: 
An AudioClip array is used to play all the other sounds apart from the background music. THese sounds include sounds for killing aliens, shooting lasers, losing a life, and game over.

### AnimationTimer: 
An AnimationTimer is used throughout the game to facilitate movement of the player, enemies, boundaries, and background. It also keeps track of collisions and gameplay logic. A Platform.runLater is used to reset the game before returning to the menu.

### Timelines and Polymorphism: 
3 Timeline objects are used including bulletTimer, bombTimer, and alienTimer to periodically spawn bullets, bombs, and aliens. What is especially important is that the alienTimer makes use of the Alien super class to randomly spawn the three different sub classes of aliens (POLYMORPHISM).

### Layouts used: 
VBoxes have been used to organize buttons such as the play button, settings button, and score button in the main menu, and the three cost buttons in the settings. The main menu (title screen) and game screen only uses a normal Pane, however, the settings use a GridPane. There are also multiple scene to facilitate switching between layout panes throughout the game.

### Classes: 
There are a total of 10 classes in this game (not including Main). Of these classes, 3 (GhostAlien, GreenAlien, and RedAlien) are actually sub classes that inherit their methods from the abstract Alien class. THere is also a Spaceship (player) class, as well as a Heart class (which is the method for keeping track of lives in the game), the Bullet class, the Bomb class, the Coin class, and the Wall class.

When one of the sorting buttons in the leaderboard are clicked, and insertion sort algorithm is run which sorts the scores by the kills, coins, or distance.
 
Most of the code for the leaderboard and upgrades are in the methods: readLeaderBoard(), addToLeaderBoard(), sortLeaderBoard(), getName(), getUpgradeStatus(), setUpgradeStatus(), onUpgradeClick().
