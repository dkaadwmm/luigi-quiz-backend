package unittest;

import model.Answer;
import model.Question;
import model.Qwa;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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