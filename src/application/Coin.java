package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin {
	
	//Global variables:
	private Image imgCoin;
	private ImageView ivCoin;
	private double xPos, yPos, width, height;
	private Random rand;
	
	//This constructor initializes the Image and ImageView, adjusts the size of the ImageView, sets the default x-position, y-position, initializes Random(), and sets the width and height.
	public Coin() {
		
		imgCoin = new Image("file:images\\Coin.png");
		ivCoin = new ImageView(imgCoin);
		ivCoin.setFitWidth(imgCoin.getWidth());
		ivCoin.setFitHeight(imgCoin.getHeight());
		
		width = ivCoin.getFitWidth();
		height = ivCoin.getFitHeight();
		
		xPos = 0;
		yPos = 0;
		
		rand = new Random();
	}
	
	//setX() and setY() take in a parameter to set as the new xPos or yPos, after which the ImageView's x-position or y-position is updated.
	public void setX(double x) {
		xPos = x;
		
		ivCoin.setX(xPos);
	}
	
	public void setY(double y) {
		yPos = y;
		
		ivCoin.setY(yPos);
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
	
	//getNode() returns the Coin's ImageView.
	public ImageView getNode() {
		return ivCoin;
	}
	
	//setLocation() uses the parameters sceneWidth and sceneHeight to set the Coin at a random xPos and yPos within the window bounds. THe ImageView is then updated to match that xPos and yPos.
	public void setLocation(double sceneWidth, double sceneHeight) {
		
		xPos = rand.nextInt((int) (sceneWidth - width));
		yPos = rand.nextInt((int) (sceneHeight - height));
		
		ivCoin.setX(xPos);
		ivCoin.setY(yPos);
	}
}
