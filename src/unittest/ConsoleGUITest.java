package unittest;

import consoleGUI.GUIQuiz;
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

		/* Runtime.getRuntime().exec("cls");   -- should delete Console content, but currently doesn't work */


		GUIQuiz.printQuestionWithAnswers(createTestQwa(0,0));
        //GUIQuiz.getAndCheckAnswer(3, "Antwort3"); - Console Input doesn't work in JUNIT Test


	}


    public static Qwa createTestQwa(int offsetQuestion, int offsetAnswers){
        Question q = new Question(1 + offsetQuestion, "Dies ist die erste Frage?" );
        List<Answer> as = new ArrayList<model.Answer>();

        as.add(new model.Answer(1 + offsetAnswers, "Antwort1", 1 + offsetQuestion, true));
        as.add(new model.Answer(2  + offsetAnswers, "Antwort2", 1 + offsetQuestion, false));
        as.add(new model.Answer(3  + offsetAnswers, "Antwort3", 1 + offsetQuestion, false));
        as.add(new model.Answer(4  + offsetAnswers, "Antwort4", 1 + offsetQuestion, false));

        Qwa qwa = new Qwa(q, as);
        qwa.shuffleAnswers();

        return qwa;
    }
}