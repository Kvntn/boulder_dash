/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import controller.Controller;
import entity.ControllerOrder;
import model.model;
import entity.Map;
import model.Model;
import view.View;

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
     */
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        
        Map map = new Map();
        map = downloadMap(1);
        
        view.setController(controller);
        controller.control();
        controller.orderPerform(ControllerOrder.NONE);
    }

}
