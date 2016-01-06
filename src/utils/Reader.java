/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author zoka123
 */
public class Reader {

    public static String read(String prompt) {

        System.out.print(prompt);

        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;

        //  read the username from the command-line; need to use try/catch with the
        //  readLine() method
        try {
            input = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read");
            System.exit(1);
        }

        return input;

    }

}
