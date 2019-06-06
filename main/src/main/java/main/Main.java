/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import contract.IModel;
import contract.IView;
import controller.Controller;
import entity.ControllerOrder;
import model.Model;
import view.BoulderDashView;


/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     * 			throws something
     * @throws InterruptedException
     * 			throws something
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IModel model = new Model(3);
        final BoulderDashView bdv = new BoulderDashView(model.getMap(), model.getTheCharacter(), model.getMap().getMobileEntities());
        final Controller controller = new Controller(bdv, model);
        bdv.setOrderPerformer(controller);
        controller.play();
    }
}
