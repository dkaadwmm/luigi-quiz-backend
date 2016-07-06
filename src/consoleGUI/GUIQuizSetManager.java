package consoleGUI;

import business.QuizUtils;
import model.QuizSet;
import model.Qwa;

/**
 * Created by franziska on 06.07.2016.
 */
public class GUIQuizSetManager {

    private static QuizSet qs;


    protected static void iterateThroughQuizSet() throws UserWantsToQuitException {

        for(Qwa qwa : qs.getQwaList()) {
            //Qwa testQwa = unittest.ConsoleGUITest.createTestQwa(0, 0);
            GUIAskQuestion aQ = new GUIAskQuestion(qwa);

            aQ.startAskingQuestion();
        }

    }

    protected static void getNewQuizSet(int amountAnswers) {

        qs = QuizUtils.generateRandomQuizSet(amountAnswers);
    }
}
