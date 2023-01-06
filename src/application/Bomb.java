package application;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Bomb {
	
	//Global variables:
	private Image imgBombLeft, imgBombRight;
	private ImageView ivBomb;
	private double xPos, yPos;
	private double width, height;
	private int dir;
	public static final int EAST = 0, WEST = 1;
	private boolean canMove = false;
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, y-position, direction, and sets the width and height.
	public Bomb() {
		
		imgBombLeft = new Image("file:images\\bombLeft.png");
		imgBombRight = new Image("file:images\\bombRight.png");
		
		ivBomb = new ImageView(imgBombRight);
		ivBomb.setFitHeight(imgBombRight.getHeight() / 3);
		ivBomb.setFitWidth(imgBombRight.getWidth() / 3);
		dir = EAST;
		
		width = imgBombRight.getWidth();
		height = imgBombRight.getHeight();
		
		
		xPos = -1000;
		yPos = 0;
		ivBomb.setX(xPos);
	}
	
	//setX() and setY() take in a parameter to set as the new xPos or yPos, after which the ImageView's x-position or y-position is updated.
	public void setX(double x) {
		xPos = x;
		
		ivBomb.setX(xPos);
	}
	
	//getX() and getY() return the x-position or y-position.
	public double getX() {
		return xPos;
	}
	
	//getDirection() returns the direction of the bomb.
	public int getDirection() {
		return dir;
	}
	
	public void setY(double d) {
		yPos = d;
		
		ivBomb.setY(yPos);
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
	
	//setDirection() sets the direction of the bomb to the passed in parameter.
	public void setDirection(int dir) {
		this.dir = dir;
	}
	
	//getNode() returns the Bomb's ImageView, depending on the direction its facing.
	public ImageView getNode() {
		if (dir == EAST) {
			ivBomb.setImage(imgBombRight);
		} else if (dir == WEST) {
			ivBomb.setImage(imgBombLeft);
		}
		
		return ivBomb;
	}
	
	//setLocation() sets the bomb somewhere around the ship depending on the direction, using the shipX, shipY, shipWidth, shipHeight and reset parameters, and updating the ImageView to match 
	//the new xPos and yPos. The reset parameter makes sure that the bomb can be reset before setting the new location.
	public void setLocation(double shipX, double shipY, double shipWidth, double shipHeight, boolean reset) {
		if (reset) {
			canMove = true;
			
			if (dir == EAST) {
				xPos = shipX + shipWidth - 50;
				yPos = shipY + shipHeight/4;
			} else if (dir == WEST) {
				xPos = shipX - 20;
				yPos = shipY + shipHeight/4;
			}
			
			ivBomb.setX(xPos);
			ivBomb.setY(yPos);
		}
	}
	
	//The move() method moves the bomb by a speed of 5 according to the direction it is set to, and updates the x-position of the ImageView to match.
	public void move() {
		if(canMove) {
			if (dir == EAST) {
				xPos += 5;
			} else if (dir == WEST) {
				xPos -= 5;
			}
			
			ivBomb.setX(xPos);
		}
	}
	
	//Returns the Bounds that allow for collision detections of the bomb.
	public Bounds getObjectBounds() {
		Rectangle rect = new Rectangle(xPos + 20, yPos + 15, width - 135, height - 60);
		
		return rect.getBoundsInParent();
	}
}
