package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GreenAlien extends Alien {
	
	//Used to hold the ship's xPos and yPos.
	private double shipX, shipY;
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, y-position, x-direction, y-direction, shipX, shipY, x-speed, and 
	//y-speed, initializes Random(), and sets the width and height.
	public GreenAlien() {
		imgAlien = new Image("file:images\\green_alien.png");
		ivAlien = new ImageView(imgAlien);
		
		shipX = 0;
		shipY = 0;
		
		xPos = 0;
		yPos = 0;
		xSpeed = 0;
		ySpeed = 0;
		
		xDir = EAST;
		yDir = NORTH;
		
		ivAlien.setFitHeight(imgAlien.getHeight()/9);
		ivAlien.setFitWidth(imgAlien.getWidth()/9);
		
		width = ivAlien.getFitWidth();
		height = ivAlien.getFitHeight();
		
		rand = new Random();
	}
	
	//Takes parameters that give it the ship's x and y-position, and set it to this.shipX and this.shipY.
	public void getShipPos(double shipX, double shipY) {
		this.shipX = shipX;
		this.shipY = shipY;
	}
	
	//The move() method is used by the Green Alien to approach the shipX and shipY by a speed of xSpeed and ySpeed.
	public void move() {
		
		if (shipX > xPos) {
			xPos += xSpeed;
		} else if (shipX < xPos) {
			xPos -= xSpeed;
		}
		
		if (shipY > yPos) {
			yPos += ySpeed;
		} else if (shipY < yPos) {
			yPos -= ySpeed;
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
		return Alien.GREEN;
	}
}
