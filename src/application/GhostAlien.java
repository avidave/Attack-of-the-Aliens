package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GhostAlien extends Alien {
	
	//Used to hold a list of the ship's x and and y-positions.
	private ArrayList<Double> shipX, shipY;
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, y-position, x-direction, y-direction, x-speed, and y-speed, 
	//initializes Random() and the 2 ArrayLists shipX and shipY, and sets the width and height.
	public GhostAlien() {
		imgAlien = new Image("file:images\\ghost_alien.png");
		ivAlien = new ImageView(imgAlien);
		
		shipX = new ArrayList<Double>();
		shipY = new ArrayList<Double>();
		
		xPos = 0;
		yPos = 0;
		xSpeed = 0;
		ySpeed = 0;
		
		xDir = EAST;
		yDir = NORTH;
		
		ivAlien.setFitHeight(imgAlien.getHeight()/100);
		ivAlien.setFitWidth(imgAlien.getWidth()/100);
		
		width = ivAlien.getFitWidth();
		height = ivAlien.getFitHeight();
		
		rand = new Random();
	}
	
	//Takes parameters that give it the ship's x and y-position, and set it to this.shipX and this.shipY.
	public void getShipPos(double shipX, double shipY) {
		this.shipX.add(shipX);
		this.shipY.add(shipY);
	}
	
	//The move() method is used by the Ghost Alien to approach the first shipX xPos and first shipY yPos by a speed of xSpeed and ySpeed. Once reached, that xPos and yPos are removed from the
	//corresponding ArrayLists, and the ship continues to follow the next (or new first) xPos and yPos.
	public void move() {
		
		if (ivAlien.getX() < shipX.get(0)) {
			xPos += xSpeed;
		} else if (ivAlien.getX() > shipX.get(0)) {
			xPos -= xSpeed;
		}
		
		if (ivAlien.getY() < shipY.get(0)) {
			yPos += ySpeed;
		} else if (ivAlien.getY() > shipY.get(0)) {
			yPos -= ySpeed;
		}
		
		//The ImageView's x and y-position are updated to match xPos and yPos.
		ivAlien.setX(xPos);
		ivAlien.setY(yPos);
		
		if (ivAlien.getX() >= shipX.get(0) - xSpeed && ivAlien.getX() <= shipX.get(0) + xSpeed && ivAlien.getY() >= shipY.get(0) - ySpeed && ivAlien.getY() <= shipY.get(0) + ySpeed) {
			shipX.remove(0);
			shipY.remove(0);
		}
	}
	
	//Sets the xSpeed and ySpeed to a random speed between 4-5.
	public void setSpeed() {
		
		xSpeed = rand.nextInt(2) + 4;
		ySpeed = rand.nextInt(2) + 4;
	}
	
	//Sets the xSpeed and ySpeed to a random speed between 2-4.
	public int getType() {
		return Alien.GHOST;
	}
}
