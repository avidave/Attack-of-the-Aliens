package application;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

public class Spaceship {
	
	//Global variables:
	private Image imgShip;
	private ImageView ivShip;
	private int xDir, yDir;
	private double xPos, yPos, width, height;
	public final static int NORTH = 0, SOUTH = 2, EAST = 1, WEST = 3;
	private double sceneWidth, sceneHeight;
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, y-position, x-direction, y-direction, and sets the width and height.
	public Spaceship() {
		
		imgShip = new Image("file:images\\spaceship.gif");
		ivShip = new ImageView(imgShip);
		ivShip.setFitWidth(imgShip.getWidth()/9);
		ivShip.setFitHeight(imgShip.getHeight()/9);
		
		xPos = 0;
		yPos = 0;
		
		xDir = EAST;
		yDir = NORTH;
		
		width = ivShip.getFitWidth();
		height  = ivShip.getFitHeight();
	}
	
	//setLocation() sets the ship at the centre of the window, using the frameWidth, and frameHeight parameters, and updating the ImageView to match the new xPos and yPos.
	public void setLocation(double frameWidth, double frameHeight) {
		sceneWidth = frameWidth;
		sceneHeight = frameHeight;
		
		xPos = sceneWidth / 2 - width / 2;
		yPos = sceneHeight / 2 - height / 2;
		
		ivShip.setX(xPos);
		ivShip.setY(yPos);
	}
	
	//setX() and setY() take in a parameter to set as the new xPos or yPos, after which the ImageView's x-position or y-position is updated.
	public void setX(double x) {
		xPos = x;
		
		ivShip.setX(xPos);
	}
	
	public void setY(double y) {
		yPos = y;
		
		ivShip.setY(yPos);
	}
	
	//getX() and getY() return the x-position or y-position.
	public double getX() {
		return xPos;
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
	
	//getNode() returns the Spaceship's ImageView.
	public ImageView getNode() {
		return ivShip;
	}
	
	//moveY() changes the yPos by yDir variable that is passed in as a parameter, and updates the ImageView y-position to match.
	public void moveY(int yDir) {
		
		this.yDir = yDir;
		
		yPos += this.yDir;
		
		ivShip.setY(yPos);
	}
	
	//moveX() changes the xPos by xDir variable that is passed in as a parameter, and updates the ImageView x-position to match.
	public void moveX(int xDir) {
		
		this.xDir = xDir;
		
		xPos += this.xDir;
		
		ivShip.setX(xPos);
	}
	
	//Returns the Bounds that allow for collision detections of the ship.
	public Bounds getObjectBounds() {
		Polygon triangle = new Polygon();
		triangle.getPoints().addAll(new Double[] {xPos + width/2, yPos, xPos + width, yPos + height, xPos, yPos + height});
		triangle.setVisible(true);
		
		return triangle.getBoundsInParent();
	}
}
