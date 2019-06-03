package entity;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private Image image;
	private String imageName;
	
	/**Character in the String in our DB*/
	private char charImage;
	
	/** Boolean if the image is loaded*/
	private boolean imageLoaded;

	public Sprite(char character, String imageName) {
		this.setCharImage(character);
		this.setImageName(imageName);
	}
	
	public void loadImage() throws IOException {
		//this.setImage(buffer.getSubimage(bufferPart.x, bufferPart.y, bufferPart.width, bufferPart.height));
		this.setImage(ImageIO.read(new File(/*"C:\\Users\\Kventin\\git\\boulder_dash\\entity\\sprites/" +*/ this.getImageName())).getScaledInstance(48, 48, Image.SCALE_DEFAULT));

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
