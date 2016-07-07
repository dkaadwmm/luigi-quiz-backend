package consoleGUI;

class ConsoleGUIMain {

    private static boolean continueGame = true;


	public static void main(String[] args) {
        //org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);

        //Willkommen
        GUIMenu.printWelcomeMessage();


        do {
            GUIMenu.printMenu();
            int menuChoice = GUIMenu.readIntfromConsole();

            switch (menuChoice) {
                case -1:
                    //invalid input
                    break;
                case 0: {
                    continueGame = false;
                    break;
                }
                case 1: {
                    try {

                        GUIQuizSetManager.getNewQuizSet(10);
                        GUIQuizSetManager.iterateThroughQuizSet();

                    } catch (UserWantsToQuitException e) {
                        continueGame = false;
                        break;
                    }
                }

            }
        } while (continueGame) ;

		GUIMenu.printGoodbyeMessage();


	}


}
