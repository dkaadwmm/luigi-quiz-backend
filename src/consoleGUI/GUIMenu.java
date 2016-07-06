package consoleGUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by franziska on 06.07.2016.
 */
public  class GUIMenu {
    protected static void printWelcomeMessage(){

        System.out.println("**Willkommen zu Luigi's Quiz!**");
        System.out.println();
        System.out.println("░█████░░░░░█████░\n" +
                "█░░░░░█░░░█░░░░░█\n" +
                "░░███░░░░░░░███░░█\n" +
                "░█░░░█░░░░░█░░░██\n" +
                "█░░░███░░░█░░░███\n" +
                "█░░████░░░█░░████\n" +
                "█░░░███░░░█░░░███\n" +
                "░█░░░█░░░░░█████\n" +
                "░░███░░░░░█░░░░░██\n" +
                "░░░░░░░░░░░░░░░░░█ █\n" +
                "░░██░░░░██░░░░░░░░███\n" +
                "░░░████████░░░░░░░███\n" +
                "░░░░████████░░░░░███\n" +
                "░░░░░░████████████\n" +
                "░░░░░░░░░░░░░░░█\n" +
                "░░░░░░░░░░░░░░█\n" +
                "██░░░░░░░░░░███\n" +
                "█░░░░░░░░░░█\n" +
                "█░░░░░░░░█\n" +
                "█░░░░░░█");
    }

    protected static void printMenu() {

        System.out.println("\nMenü:");
        System.out.println("1 - Quiz starten");
        System.out.println("0 - Programm beenden");

        return;
    }

    protected static int readIntfromConsole() {

        int i = 0;

        System.out.print("\nBitte Zahl eingeben: \n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            i = Integer.parseInt(input);

            //System.out.print("\nEingegebene Zahl: " + input );

        } catch (NumberFormatException nfe) {
            System.err.println("Bitte nur Ganzzahlen eingeben!");
        }
        finally{
            return i;
        }

    }

    public static void printGoodbyeMessage() {

        System.out.println("\n**Auf Wiedersehen!**");

    }
}
