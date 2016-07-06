package unittest;

import consoleGUI.GUIAskQuestion;
import model.Answer;
import model.Question;
import model.Qwa;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsoleGUITest {


	@Test
	public void test() {

        List<Integer> integers = GUIAskQuestion.splitUserInput("3, 6,2,1 ");

        List<Integer> compare = new ArrayList<Integer>();
        compare.add(3);
        compare.add(6);
        compare.add(2);
        compare.add(1);

        assertEquals(integers, compare);

        //GUIQuiz.getAndCheckAnswer(3, "Antwort3"); - Console Input doesn't work in JUNIT Test


	}


    public static Qwa createTestQwa(int offsetQuestion, int offsetAnswers){
        Question q = new Question(1 + offsetQuestion, "Was ist die Antwort auf die " + Integer.toString(1 + offsetQuestion) +". Frage ?" );
        List<Answer> as = new ArrayList<model.Answer>();

        as.add(new model.Answer(1 + offsetAnswers, "Antwort" + Integer.toString(1 + offsetQuestion), 1 + offsetQuestion, true));
        as.add(new model.Answer(2  + offsetAnswers, "Antwort" + Integer.toString(2 + offsetQuestion), 1 + offsetQuestion, false));
        as.add(new model.Answer(3  + offsetAnswers, "Antwort" + Integer.toString(3 + offsetQuestion), 1 + offsetQuestion, false));
        as.add(new model.Answer(4  + offsetAnswers, "Antwort" + Integer.toString(4 + offsetQuestion), 1 + offsetQuestion, false));

        Qwa qwa = new Qwa(q, as);
        qwa.shuffleAnswers();

        return qwa;
    }
}