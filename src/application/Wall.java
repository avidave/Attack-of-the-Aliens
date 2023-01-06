package application;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Wall {
	
	//Global variables:
	private Image imgWall, imgMiddle, imgLeft, imgRight;
	private ImageView ivWall;
	private double xPos, yPos, boundsX;
	private double width, height, boundsWidth;
	private Random rand;
	public static int nCostume;
	
	//This constructor initializes the 3 wall Images and one ImageView, adjusts the size of the ImageView, sets the default x-position, y-position, bounds x-position, bounds width, x-speed, and
	//y-speed, initializes Random(), and sets the width and height.
	public Wall() {
		imgWall = new Image("file:images\\GameWall.png");
		imgLeft = new Image("file:images\\\\WallLEFT.png");
		imgRight =  new Image("file:images\\\\WallRIGHT.png");
		imgMiddle =  new Image("file:images\\\\WallMIDDLE.png");
		
		
		ivWall = new ImageView(imgWall);
		ivWall.setFitHeight(imgWall.getHeight()/1.3);
		ivWall.setFitWidth(imgWall.getWidth()/1.3);
		
		height = ivWall.getFitHeight();
		width = ivWall.getFitWidth();
		
		xPos = 0;
		yPos = -height;
		
		boundsX = xPos;
		boundsWidth = width;
		
		rand = new Random();
	}
	
	//This method uses Random to randomly set the wall into one of three costumes - one with an opening on the left, one with an opening on the right, and one with an opening on both sides.
	public void setRandom() {
		nCostume = rand.nextInt(3);
		
		if (nCostume == 0) {
			ivWall.setImage(imgLeft);
		} else if (nCostume == 1) {
			ivWall.setImage(imgRight);
		} else if (nCostume == 2) {
			ivWall.setImage(imgMiddle);
		}
	}
	
	//setX() and setY() take in a parameter to set as the new xPos or yPos, after which the ImageView's x-position or y-position is updated.
	public void setY(double y) {
		yPos = y;
		
		ivWall.setY(yPos);
	}
	
	//getX() and getY() return the x-position or y-position.
	public double getY() {
		return yPos;
	}
	
	public void setX(double x) {
		xPos = x;
		
		ivWall.setX(xPos);
	}
	
	public double getX() {
		return xPos;
	}
	
	//getNode() returns the Heart's ImageView.
	public ImageView getNode() {
		return ivWall;
	}
	
	//getWidth() and getHeight() return the width or height.
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	//Returns the Bounds that allow for collision detections of the ship. This also the boundaries by to allow passage through openings by adjusting the boundsX and boundsWidth according to the
	//costume of the wall.
	public Bounds getObjectBounds() {
		Rectangle rect;
		
		if (nCostume == 1) {
			boundsX = xPos + 204;
			boundsWidth = width;
			rect = new Rectangle(boundsX, yPos, boundsWidth, height);
			return rect.getBoundsInParent();
		}
		
		if (nCostume == 0) {
			boundsX = xPos;
			boundsWidth = width - 205;
			rect = new Rectangle(boundsX, yPos, boundsWidth, height);
			return rect.getBoundsInParent();
		}
		
		if (nCostume == 2) {
			boundsX = xPos + 203;
			boundsWidth = width - 407;
			rect = new Rectangle(boundsX, yPos, boundsWidth, height);
			return rect.getBoundsInParent();
		}
		
		return ivWall.getBoundsInParent();
	}
	
	//Returns the boundsX.
	public double getBoundsX() {
		return boundsX;
	}
	
	//Returns the boundsWidth.
	public double getBoundsWidth() {
		return boundsWidth;
	}
}
