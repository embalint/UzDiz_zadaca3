
import controller.Controller;
import java.util.Scanner;
import model.Model;
import utils.InputArgs;
import utils.Settings;
import view.ChildFrame;
import view.ParentFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ahuskano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        InputArgs arg = new InputArgs();
        arg.setRowNumber(args[0]);
        arg.setColumnNumber(args[1]);
        arg.setScreenView(args[2]);
        arg.setFilePath(args[3]);
        ParentFrame view = new ParentFrame(new Settings(1, 1, 25, 50), arg.getScreenView());
        Model model = new Model();
        Controller controller = new Controller(view, model);
        Scanner input = new Scanner(System.in);
        String choise = null;
        

        do {
            System.out.println("\nUpisite odgovarajuci broj za izbor\n"
                    + "\n1-ispis ukupnog broja direktorija i datoteka u strukturi (prikaz u 1. prozoru)"
                    + "\n2-ispis sadržaja strukture direktorija i datoteka uz prikaz naziva, vremena"
                    + " \n3-izvršavanje dretve"
                    + "\n4- prekid izvršavanja dretve"
                    + "\n5- ispis informacija o svim spremljenim stanjima"
                    + "\n6- postavljanje stanja strukture na promjenu s rednim brojem n čime ono postaje novo trenutno stanje strukture"
                    + "\n7- uspoređivanje trenutnog stanja strukture i promjene s rednim brojem m"
                    + "\n8- ponovno učitavanje strukture uz poništavanje svih spremljenih stanja strukture"
                    + "\n9- dodana vlastita funkcionalnost"
                    + "\nQ-prekid rada programa");
            choise = input.next();
            switch (choise) {
                case "1":
                    
                    break;
                    
                case "2":
                    break;

                case "3":
                    break;
                    
                case "4":
                    break;

                case "5":
                    break;

                case "6":
                    break;
                    
                case "7":
                    break;

                case "8":
                    break;
                    
                case "9":
                    break;

            }

        } while (!choise.equals("Q"));

    }

}
