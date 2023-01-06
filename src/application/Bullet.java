package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet {
	
	//Global variables:
	private Image imgBullet;
	private ImageView ivBullet;
	private double xPos, yPos;
	private double width, height;
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, and y-position, and sets the width and height.
	public Bullet() {
		
		imgBullet = new Image("file:images\\laser.png");
		ivBullet = new ImageView(imgBullet);
		
		ivBullet.setFitWidth(imgBullet.getWidth()/23);
		ivBullet.setFitHeight(imgBullet.getHeight()/23);
		
		xPos = -1000;
		yPos = 0;
		
		width = ivBullet.getFitWidth();
		height = ivBullet.getFitHeight();
	}
	
	//setX() and setY() take in a parameter to set as the new xPos or yPos, after which the ImageView's x-position or y-position is updated.
	public void setX(int x) {
		xPos = x;
		
		ivBullet.setX(xPos);
	}
	
	//getX() and getY() return the x-position or y-position.
	public double getX() {
		return xPos;
	}
	
	public void setY(int y) {
		yPos = y;
		
		ivBullet.setY(yPos);
	}
	
	public double getY() {
		return yPos;
	}
	
	//getWidth() and getHeight() return the width or height.
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	//getImage() returns the Bullet's ImageView.
	public ImageView getImage() {
		return ivBullet;
	}
	
	//setLocation() sets the bullet a little above the ship depending on the direction, using the shipX, shipY, and shipWidth parameters, and updating the ImageView to match 
	//the new xPos and yPos.
	public void setLocation(double shipX, double shipY, double shipWidth) {
		xPos = shipX + shipWidth/2 - width/2;
		yPos = shipY - 30;
		
		ivBullet.setX(xPos);
		ivBullet.setY(yPos);
	}
	
	//The Bullet moves upwards at a speed of 7 and the ImageView's y-position is updated to match.
	public void move() {
		yPos -= 7;
		
		ivBullet.setY(yPos);
	}
}
