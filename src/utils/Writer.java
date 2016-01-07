/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import view.Frame;
import view.Position;

/**
 *
 * @author ahuskano
 */
public class Writer {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "=";

    public static final String ANSI_ESC = "\033[";

    public static volatile Position writerNextPosition = new Position(0, 0);

    public static void position(int x, int y) {
        System.out.print(ANSI_ESC + y + ";" + x + "f");
    }

    public static void printVerticalLine(int x, int start, int end) {
        for (int i = start; i <= end; i++) {
            print(VERTICAL_LINE, x, i);
        }
    }

    public static void clear() {
        System.out.print(ANSI_ESC + "2J");
    }

    public static void printHorizontalLine(int y, int start, int end) {
        for (int i = start; i <= end; i++) {
            print(HORIZONTAL_LINE, i, y);
        }
    }

    public static void print(String text, int x, int y) {
        position(x, y);
        System.out.print(text);
    }

    public static void printInFrame(Frame frame, String content) {
        print(content, frame.getSettings().getX(), frame.getSettings().getY());
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

            if (startLine + 1 > frame.getSettings().getHeight()) {
                line = 0;
                clear(frame);
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
        for (int i = frame.getSettings().getY(); i < frame.getSettings().getY() + frame.getSettings().getHeight(); i++) {

            if (frame.getSettings().getX() > 1) {
                // Delete till end
                position(frame.getSettings().getX(), i);
                clearFromCursor();
            } else {
                // Delete to cursor
                position(frame.getSettings().getX() + frame.getSettings().getWidth(), i);
                clearToCursor();
            }

            frame.showBorders();
        }
    }

    public static void resetPosition() {
        position(
                writerNextPosition.getX(),
                writerNextPosition.getY()
        );
    }

}
