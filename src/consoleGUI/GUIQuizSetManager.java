package consoleGUI;

import business.QuizUtils;
import model.QuizSet;
import model.Qwa;

/**
 * This class fetches a QuizSet from the Database and iterates through the questions.
 * Uses GUIAskQuestions for asking the individual question.
 *
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

    /**
     * gets a new Quiz set from QuizUtils.generateRandomQuizSet(int amountAnswers)
     *
     * If you want to check without using DB connection or if you want to get the questions from another source
     * modify this method
     *
     * @param amountAnswers how many answers should be created
     */
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
