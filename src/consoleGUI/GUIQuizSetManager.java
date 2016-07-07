package consoleGUI;

import business.QuizUtils;
import model.QuizSet;
import model.Qwa;

/**
 * Created by franziska on 06.07.2016.
 */
class GUIQuizSetManager {

    private static QuizSet qs;


    static void iterateThroughQuizSet() throws UserWantsToQuitException {

        System.out.println("\nHinweis: Mit der Eingabe 0 können Sie das Quiz jederzeit abbrechen!");

        for(Qwa qwa : qs.getQwaList()) {

            GUIAskQuestion aQ = new GUIAskQuestion(qwa);
            aQ.askAQuestion();

        }

    }

    static void getNewQuizSet(int amountAnswers) {

        /*//Testing
        qs = new QuizSet();
        for(int i = 0; i < 10; i++)
        {
            qs.addQwa(unittest.ConsoleGUITest.createTestQwa(i, i+(i*4)));
        }*/

        qs = QuizUtils.generateRandomQuizSet(amountAnswers);
    }
}
