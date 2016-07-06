package consoleGUI;

import model.Qwa;

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
                    Qwa testQwa = unittest.ConsoleGUITest.createTestQwa(0,0);
                    GUIAskQuestion aQ =  new GUIAskQuestion(testQwa);
                    aQ.startAskingQuestion();
                }

            }



        }while(continueGame);
		
		return;

	}

}
