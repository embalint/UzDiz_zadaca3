/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import view.Frame;
import view.Position;

/**
 *
 * @author ahuskano
 */
public class Settings {

    public static final int VODORAVNO = 1;
    public static final int OKOMITO = 2;

    private int x;
    private int y;
    private int height;
    private int width;
    private int inputFrameHeight = 3;
    private int mode;
    private int refreshInterval;

    public Settings(int x, int y, int height, int width, String mode, int refreshInterval) {
        this.x = x;
        this.y = y;
        this.height = height + 1;
        this.width = width + 1;
        this.mode = (mode == "O" ? this.OKOMITO : this.VODORAVNO);
        this.refreshInterval = refreshInterval;
    }

    public Settings(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getOutputFramesHeight() {
        return this.getHeight() - this.getInputFrameHeight() + 1;
    }

    public int getOutputFrameHeight() {
        switch (getMode()) {
            case VODORAVNO:
                return getOutputFramesHeight();
            case OKOMITO:
                return getOutputFramesHeight() / 2 - 1;
        }
        return 0;
    }

    public int getOutputFrameWidth() {
        switch (getMode()) {
            case VODORAVNO:
                return getWidth() / 2 - 1;
            case OKOMITO:
                return getWidth();
        }
        return 0;
    }

    public int getInputFrameHeight() {
        return this.inputFrameHeight - 1;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

}
