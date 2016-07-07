package unittest;

import model.Answer;
import model.Question;
import model.Qwa;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * A test class for Console GUI. Also contains a method for generating a test Qwa object
 *
 */

public class ConsoleGUITest {

	@Test
	public void test() {

        System.out.println("Test1");
        clearScreen();
        System.out.println("Test2");

    }

    private static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    /**
     * This method generates a test Qwa with 1 Question and 4 Answers
     *
     * Use it like this to create n Qwa objects:
     * for(int i = 0; i < n; i++){ createTestQwa(i, i+(i*4)); }
     *
     * @param offsetQuestion an offset for the question id
     * @param offsetAnswers an offset for the answer ids
     * @return the generated Qwa object
     */
    public static Qwa createTestQwa(int offsetQuestion, int offsetAnswers){
        Question q = new Question(1 + offsetQuestion, "Was ist die Antwort auf die " + Integer.toString(1 + offsetQuestion) +". Frage ?" );
        List<Answer> as = new ArrayList<>();

        as.add(new model.Answer(1 + offsetAnswers, "Antwort" + Integer.toString(1 + offsetQuestion), 1 + offsetQuestion, true));
        as.add(new model.Answer(2  + offsetAnswers, "Antwort" + Integer.toString(2 + offsetQuestion), 1 + offsetQuestion, false));
        as.add(new model.Answer(3  + offsetAnswers, "Antwort" + Integer.toString(3 + offsetQuestion), 1 + offsetQuestion, false));
        as.add(new model.Answer(4  + offsetAnswers, "Antwort" + Integer.toString(4 + offsetQuestion), 1 + offsetQuestion, true));

        Qwa qwa = new Qwa(q, as);
        qwa.shuffleAnswers();

        return qwa;
    }
}