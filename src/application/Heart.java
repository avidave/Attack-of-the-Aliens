package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Heart {
	
	//Global variables:
	private Image imgHeart;
	private ImageView ivHeart;
	private double xPos, yPos, width, height;
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, and y-position, and sets the width and height.
	public Heart() {
		
		imgHeart = new Image("file:images\\heart.png");
		ivHeart = new ImageView(imgHeart);
		
		xPos = 0;
		yPos = 0;
		
		ivHeart.setFitWidth(imgHeart.getWidth()/12);
		ivHeart.setFitHeight(imgHeart.getHeight()/12);
		
		width = ivHeart.getFitWidth();
		height = ivHeart.getFitHeight();
	}
	
	//setX() and setY() take in a parameter to set as the new xPos or yPos, after which the ImageView's x-position or y-position is updated.
	public void setX(double x) {
		xPos = x;
		
		ivHeart.setX(xPos);
	}
	
	//getX() and getY() return the x-position or y-position.
	public double getX() {
		return xPos;
	}
	
	public void setY(double y) {
		yPos = y;
		
		ivHeart.setY(yPos);
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
	
	//getNode() returns the Heart's ImageView.
	public ImageView getNode() {
		return ivHeart;
	}
}
