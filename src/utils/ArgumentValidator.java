package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nikolina
 */
public class ArgumentValidator {

    private String[] arguments;

    public ArgumentValidator(String[] arguments) {
        this.arguments = arguments;
        // Validation();
    }

    public boolean Validation() {
        boolean validation = true;

        if (arguments.length != 5) {
            System.err.println("Invalid number of argument!");
            validation = false;
            return validation;
        }

        //row validation
        try {
            int rowNumber = Integer.parseInt(arguments[0]);
            if (rowNumber < 24 || rowNumber > 40) {
                System.err.println("Invalid range of the number of rows (24 - 40)");
                validation = false;
            }
        } catch (Exception e) {
            System.err.println("Number of row must be digit (24 - 40)");
            validation = false;
        }

        //column validation
        try {
            int columnNumber = Integer.parseInt(arguments[1]);
            if (columnNumber < 80 || columnNumber > 160) {
                System.err.println("Invalid range of the number of columns (80 - 160)");
                validation = false;
            }
        } catch (Exception e) {
            System.err.println("Number of column must be digit! (80 - 160)");
            validation = false;
        }

        try {
            String screen = arguments[2];
            if (!screen.equals("V")) {
                if (!screen.equals("O")) {
                    System.err.println("Invalid input for screen orientation ");
                    validation = false;
                }
            }
        } catch (Exception e) {
            System.err.println("U can only enter V or O for screen oritentation");
            validation = false;
        }

        //seconds validation
        try {
            int secondsNumber = Integer.parseInt(arguments[4]);
            if (secondsNumber < 1 || secondsNumber > 120) {
                System.err.println("Invalid range of the number of seconds (1 - 120)");
                validation = false;
            }
        } catch (Exception e) {
            System.err.println("Number of seconds must be digit! (1 - 120)");
            validation = false;
        }

        return validation;
    }
}
