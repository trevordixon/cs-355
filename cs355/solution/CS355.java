/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs355.solution;

import cs355.GUIFunctions;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trevor Dixon
 */
public class CS355 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    	// Fill in the parameters below with your controller, view, 
    	//   mouse listener, and mouse motion listener
        CS355Model model = new CS355Model();
        CS355Controller controller = new CS355Controller(model);
        ViewRefresher view = new ViewRefresher(model);

        GUIFunctions.createCS355Frame(
            controller,
            view,
            controller.mouseListener,
            controller.mouseMotionListener
        );
        
        GUIFunctions.refresh();        
    }
}