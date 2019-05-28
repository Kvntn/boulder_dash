package contract;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * The Enum ControllerOrder.
 *
 * @author Jean-Aymeric Diet.
 */
public enum ControllerOrder implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()== KeyEvent.VK_UP) {
			theCharacter.moveUP;
		}	
		else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
			theCharacter.MoveDown;
		}
		else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			theCharacter.MoveLeft;
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			thecharacter.MoveRight;
		}
	}

}
