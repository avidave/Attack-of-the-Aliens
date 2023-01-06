package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//This is an abstract (super) class.
public abstract class Alien {
	
	//Global variables:
	Image imgAlien;
	ImageView ivAlien;
	Random rand;
	double xPos, yPos, width, height;
	int xSpeed, ySpeed, xDir, yDir;
	static final int EAST = 0, WEST = 1, NORTH = 2, SOUTH = 3;
	//This is used to identify the type fo Alien.
	static final int RED = 0, GREEN = 1, GHOST = 2;
	
	//setX() and setY() take in a parameter to set as the new xPos or yPos, after which the ImageView's x-position or y-position is updated.
	public void setX(double x) {
		xPos = x;
		
		ivAlien.setX(xPos);
	}
	
	//getX() and getY() return the x-position or y-position.
	public double getX() {
		return xPos;
	}
	
	public void setY(double y) {
		yPos = y;
		
		ivAlien.setY(yPos);
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
	
	//getNode() returns the Alien's ImageView.
	public ImageView getNode() {
		return ivAlien;
	}
	
	//setXDir() and setYDir() set the xDir() or yDir() to the corresponding parameter.
	public void setXDir(int xDir) {
		this.xDir = xDir;
	}
	
	public void setYDir(int yDir) {
		this.yDir = yDir;
	}
	
	//getXDir() and getYDir() return the xDir or yDir.
	public double getXDir() {
		return xDir;
	}
	
	public double getYDir() {
		return yDir;
	}
	
	//move() is defined in the sub-classes of Alien.
	public abstract void move();
	
	//setLocation takes the scene width and height and uses it to randomly set the Alien's x-position and y-position.
	public void setLocation(double sceneWidth, double sceneHeight) {
		xPos = rand.nextInt((int) (sceneWidth - width - 100)) + 50;
		yPos = rand.nextInt(150);
		
		ivAlien.setX(xPos);
		ivAlien.setY(yPos);
	};
	
	//setSpeed(), getType(), and getShipPos() are defined in the sub-classes of Alien.
	public abstract void setSpeed();
	public abstract int getType();
	public abstract void getShipPos(double shipX, double shipY);
}
