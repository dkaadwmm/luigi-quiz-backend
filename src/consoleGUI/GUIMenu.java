package consoleGUI;

import java.util.Scanner;

/**
 * This class contains static methods for handeling the quiz menu.
 * Created by franziska on 06.07.2016.
 *
 */
class GUIMenu {
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
    }

    protected static int readIntfromConsole() {

        int integer;

        System.out.print("\nBitte Zahl eingeben: \n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            integer = Integer.parseInt(input);

            //System.out.print("\nEingegebene Zahl: " + input );

        } catch (NumberFormatException nfe) {
            System.err.println("Bitte nur Ganzzahlen eingeben!");
            integer = -1;
        }

        return integer;


    }

    protected static void printGoodbyeMessage() {

        System.out.println("\n**Auf Wiedersehen!**");

    }
}
