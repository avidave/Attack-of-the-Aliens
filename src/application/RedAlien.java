package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedAlien extends Alien {
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, y-position, x-direction, y-direction, x-speed, and y-speed, 
	//initializes Random(), and sets the width and height.
	public RedAlien() {
		imgAlien = new Image("file:images\\red_alien.png");
		ivAlien = new ImageView(imgAlien);
		
		xPos = 0;
		yPos = 0;
		xSpeed = 0;
		ySpeed = 0;
		
		xDir = EAST;
		yDir = NORTH;
		
		ivAlien.setFitHeight(imgAlien.getHeight()/35);
		ivAlien.setFitWidth(imgAlien.getWidth()/35);
		
		width = ivAlien.getFitWidth();
		height = ivAlien.getFitHeight();
		
		rand = new Random();
	}
	
	//RedAlien does not use getShipPos().
	public void getShipPos(double shipX, double shipY) {}
	
	//move() checks the direction of the Alien, and uses that to change the xSpeed and ySpeed in the opposite direction (to create a bounce).
	public void move() {
		
		if (xDir == EAST) {
			xPos += xSpeed;
		} else if (xDir == WEST) {
			xPos -= xSpeed;
		}
		
		if (yDir == NORTH) {
			yPos -= ySpeed;
		} else if (yDir == SOUTH) {
			yPos += ySpeed;
		}
		
		//The ImageView's x and y-position are updated to match xPos and yPos.
		ivAlien.setX(xPos);
		ivAlien.setY(yPos);
	}
	
	//Sets the xSpeed and ySpeed to a random speed between 2-4.
	public void setSpeed() {
		
		xSpeed = rand.nextInt(3) + 2;
		ySpeed = rand.nextInt(3) + 2;
	}
	
	//Returns the type of Alien.
	public int getType() {
		return Alien.RED;
	}
}
