/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import model.Model;
import utils.Settings;
import utils.Writer;

/**
 *
 * @author ahuskano
 */
public class Frame implements Observer {

    private Settings settings;

    public Frame(Settings settings) {
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void showBorders() {
        int x1 = getSettings().getX();
        int y1 = getSettings().getY();
        int x2 = x1 + getSettings().getWidth();
        int y2 = y1 + getSettings().getHeight();

        Writer.printHorizontalLine(y1, x1, x2);
        Writer.printHorizontalLine(y2, x1, x2);
        Writer.printVerticalLine(x1, y1, y2);
        Writer.printVerticalLine(x2, y1, y2);
    }

    private void save() {
        Writer.savePosition();
        Writer.colorStack.add(Writer.COLOR_WHITE);
    }

    private void restore() {
        Writer.restorePosition();
        Writer.colorStack.pop();
        Writer.printColorCode(Writer.getActiveColor());
    }

    public void clear() {
        save();
        Writer.clear(this);
        restore();
    }

    public void clearAndShowBorders() {
        save();
        Writer.clear(this);
        showBorders();
        restore();
    }

    public void render() {
        save();
        showBorders();
        restore();
    }

    public void render(Model model) {
        save();
        Writer.clear(this);
        showBorders();
        Writer.printInFrame(this, model.getBuffer());
        restore();

    }

    public void update(Observable obs, Object obj) {
        clear();
        render((Model) obs);
    }

    public Position getWriterStartPosition() {
        return new Position(settings.getX() + 1, settings.getY() + 1);
    }

}
