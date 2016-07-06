package consoleGUI;

public class ConsoleGUI {

    static boolean continueGame = true;


	public static void main(String[] args) {

        //Willkommen
        GUIMenu.printWelcomeMessage();

        do {

            GUIMenu.printMenu();
            int menuChoice = GUIMenu.readIntfromConsole();

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

}
