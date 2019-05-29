package entity;

import java.awt.Image;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	private Sprite sprite;
	private Permeability permeability;
	
	public Entity (Sprite sprite, Permeability perm){
		this.sprite = sprite;
		this.permeability = perm;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Permeability getPermeability() {
		return permeability;
	}
	
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	
	public Image getImage() {
		return this.getSprite().getImage();
	}
	
	
}
