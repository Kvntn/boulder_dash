package entity;

import java.awt.Image;

public class Sprite {

	private Image image;
	private String imageName;
	private char charImage;
	private boolean imageLoaded;
	
	public Sprite(char character, String imageName) {
		
	}
	
	public Image loadImage() {
		return image;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public char getCharImage() {
		return charImage;
	}

	public void setCharImage(char charImage) {
		this.charImage = charImage;
	}

	public boolean isImageLoaded() {
		return imageLoaded;
	}

	public void setImageLoaded(boolean imageLoaded) {
		this.imageLoaded = imageLoaded;
	}
}
