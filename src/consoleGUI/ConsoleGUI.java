package consoleGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleGUI {

    static boolean continueGame = true;


	public static void main(String[] args) {

        //Willkommen
        printWelcomeMessage();

        do {

            printMenu();
            int menuChoice = readIntfromConsole();

            switch (menuChoice){
                case 0: {
                    continueGame = false;
                    break;
                }
                case 1: {

                }

            }



        }while(continueGame);
		
		return;

	}

    private static void printWelcomeMessage(){

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

    private static void printMenu() {

        System.out.println("\nMenü:");
        System.out.println("1 - Quiz starten");
        System.out.println("0 - Programm beenden");
        //Runtime.getRuntime().exec("cls");   -- should delete Console content, but currently doesn't work
        return;
    }

    private static int readIntfromConsole() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;

        try {
            System.out.print("\nBitte Zahl eingeben: \n");
            i = Integer.parseInt(br.readLine());
            System.out.print("\nEingegebene Zahl: " + Integer.toString(i) );

        } catch (NumberFormatException nfe) {
            System.err.println("Bitte nur Ganzzahlen eingeben!");
        } catch (java.io.IOException ioe) {
            System.err.println("Ungültige Eingabe!");
        }
        finally{
            return i;
        }

    }
}
