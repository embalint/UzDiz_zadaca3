/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import utils.Settings;

public class FrameFactory {

    private Settings settings;

    private Position defaultCursorPosition = new Position(0, 0);

    public FrameFactory(Settings settings) {
        this.settings = settings;
    }

    public Frame makeOutputFrame1() {
        return new Frame(new Settings(
                settings.getX(),
                settings.getY(),
                settings.getOutputFrameHeight(),
                settings.getOutputFrameWidth()
        ));
    }

    public Frame makeOutputFrame2() {
        Frame frame = makeOutputFrame1();
        Settings frameSettings = frame.getSettings();

        switch (settings.getMode()) {
            case Settings.VODORAVNO:
                frameSettings.setX(settings.getX() + settings.getOutputFrameWidth() + 1);
                break;
            case Settings.OKOMITO:
                frameSettings.setY(settings.getY() + settings.getOutputFrameHeight() + 1);
        }

        frame.setSettings(frameSettings);

        return frame;
    }

    public Frame makeInputFrame() {
        return new Frame(new Settings(
                1,
                settings.getX() + settings.getOutputFramesHeight() + 1,
                settings.getInputFrameHeight(),
                settings.getWidth() - 2
        ));
    }

    public Frame makeFrame(int id, Observable obs) {
        Frame f = null;
        switch (id) {
            case 1:
                f = this.makeOutputFrame1();
                break;
            case 2:
                f = this.makeOutputFrame2();
                break;
            case 3:
                f = this.makeInputFrame();
                break;
        }

        if (f == null) {
            return null;
        }

        if (obs != null) {
            obs.addObserver(f);
        }

        return f;
    }
}
