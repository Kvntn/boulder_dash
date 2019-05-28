package view;
import java.util.TimerTask;
public class Chronometre extends TimerTask{
	private int tempsPourLeNiveau = 200;
	public void run() {
		//action qui va etre effectuée
		System.out.println("time left : "+tempsPourLeNiveau);
		if(tempsPourLeNiveau==30) {
			//on peux faire passer le temps en rouge pour informer qu'il reste peu de temps.
			System.out.println("c'est presque fini");
		}
		if(tempsPourLeNiveau==0) {
			//le temps restant est nul donc le timer s'arrete et on a perdu
			cancel();
		}
		tempsPourLeNiveau--;
	}
}
//Dans le main on met ceci :
/*
 * Timer chrono = new Timer();
 * chrono.schedule(new Chronometre(),1000,1000);
*/
