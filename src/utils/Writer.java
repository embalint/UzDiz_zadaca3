/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
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
        for (String s : content) {
            print(s, frame.getSettings().getX() + 1, frame.getSettings().getY() + 1);
        }
    }

    public static void clear(int x, int y) {
        if (x > 2) {
            // Delete till end  

        } else {
            // Delete to cursor

        }
    }

    public static void resetPosition() {
        position(
                writerNextPosition.getX(),
                writerNextPosition.getY()
        );
    }

}
