/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs355;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Talonos
 */
class CS355Canvas extends Canvas
{
    @Override
    public void paint(Graphics graphics)
    {
        if (CS355Frame.isInitialized())
        {
            RedrawRoutine.inst().refreshView();
        }
    }
}
