package entity;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	/** The image. */
	private Image image;

	/** The console image. */
	private char charImage;
	
	/**Image name*/
	private String imageName;

	/** The selected buffer. */
	private BufferedImage buffer;

	/** The part of buffer to keep. */
	private Rectangle bufferPart;

	/** The is image loaded. */
	private boolean imageLoaded;

	/** The buffer for the character images */
	public static BufferedImage spriteSheetCharacter = null;

	/** The buffer for the map images */
	public static BufferedImage mapSheet = null;


	public Sprite(char c, BufferedImage buff, Rectangle rectangle) {
		
		this.setCharImage(c);
		this.buffer = buff;
		bufferPart = rectangle;
	}

	public void loadImage() throws IOException {
		this.setImage(buffer.getSubimage(bufferPart.x, bufferPart.y, bufferPart.width, bufferPart.height));
	}
	
	public static void loadBuffers() {
		try {
			Sprite.spriteSheetCharacter = ImageIO.read(new File("C:\\Users\\Kventin\\git\\boulder_dash2\\entity\\Sprites\\charSheet.png"));
			Sprite.mapSheet = ImageIO.read(new File("C:\\Users\\Kventin\\git\\boulder_dash2\\entity\\Sprites\\mainSpriteSheetWorld1.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Working directory: " + System.getProperty("user.dir"));
		}
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
