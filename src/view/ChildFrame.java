/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.Settings;
import utils.Writer;

/**
 *
 * @author ahuskano
 */
public class ChildFrame extends Frame {

    public ChildFrame(Settings settings) {
        super(settings);
        show();
    }

    
    @Override
    protected void show() {
        showBorders();
    }

    @Override
    protected void clear() {

    }
    
    private void showBorders() {
        int x1 = getSettings().getX();
        int y1 = getSettings().getY();
        int x2 = x1 + getSettings().getWidth();
        int y2 = y1 + getSettings().getHeight();
        Writer.printHorizontalLine(y1, x1, x2);
        Writer.printHorizontalLine(y2, x1, x2);
        Writer.printVerticalLine(x1, y1, y2);
        Writer.printVerticalLine(x2, y1, y2);
    }
    
}
