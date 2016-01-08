/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import registry.Registry;
import view.Frame;
import view.Position;

/**
 *
 * @author ahuskano
 */
public class Writer {

    public volatile static Stack<String> colorStack = new Stack<>();

    public static final String COLOR_GREEN = "32";
    public static final String COLOR_YELLOW = "33";
    public static final String COLOR_BLACK = "30";
    public static final String COLOR_WHITE = "37";

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "=";

    public static final String ANSI_ESC = "\033[";

    public static volatile Position writerNextPosition = new Position(0, 0);

    public static void position(int x, int y) {
        System.out.print(ANSI_ESC + y + ";" + x + "f");
    }

    public static void position(Position p) {
        position(p.getX(), p.getY());
    }

    public static void printVerticalLine(int x, int start, int end) {
        for (int i = start; i <= end; i++) {
            print(VERTICAL_LINE, x, i);
        }
    }

    public static void clear() {
        System.out.print(ANSI_ESC + "2J");
    }

    public static void savePosition() {
        System.out.print("\0337");
    }

    public static void restorePosition() {
        System.out.print("\0338");
    }

    public static void printHorizontalLine(int y, int start, int end) {
        for (int i = start; i <= end; i++) {
            print(HORIZONTAL_LINE, i, y);
        }
    }

    private static void print(String text, int x, int y) {
        position(x, y);
        System.out.print(ANSI_ESC + getActiveColor() + "m");
        System.out.print(text);
    }

    public static void printInFrame(Frame frame, ArrayList<String> content) {
        int line = 0;

        ArrayList<String> splitContent = new ArrayList<>();

        for (String s : content) {
            String[] arr = s.split("(?<=\\G.{" + (frame.getSettings().getWidth() - 1) + "})");
            for (int i = 0; i < arr.length; i++) {
                splitContent.add(arr[i]);
            }

        }

        for (String s : splitContent) {
            int startLine = frame.getSettings().getY() + 1 + line;
            print(s, frame.getSettings().getX() + 1, startLine);

            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (startLine + 1 >= frame.getSettings().getY() + frame.getSettings().getHeight()) {
                line = 0;
                clear(frame);
                frame.showBorders();

            } else {
                line++;
            }

        }
    }

    public static void clearToCursor() {
        System.out.print(ANSI_ESC + "1K");
    }

    public static void clearFromCursor() {
        System.out.print(ANSI_ESC + "K");
    }

    public static void clear(Frame frame) {
        for (int i = frame.getSettings().getY() + 1; i < frame.getSettings().getY() + frame.getSettings().getHeight(); i++) {

            if (frame.getSettings().getX() > 1) {
                // Delete till end
                position(frame.getSettings().getX(), i);
                clearFromCursor();
            } else {
                // Delete to cursor
                position(frame.getSettings().getX() + frame.getSettings().getWidth(), i);
                clearToCursor();
            }
        }
    }

    public static void printColorCode(String color) {
        System.out.print(ANSI_ESC + color + "m");
    }

    public static String getActiveColor() {
        if (colorStack.empty()) {
            return Writer.COLOR_WHITE;
        } else {
            return colorStack.lastElement();
        }
    }
}
