package unittest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Answer;
import model.Question;
import model.QuizSet;
import model.Qwa;
import org.junit.Test;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuizSetToGSONTest {

    @Test
    public void test() {
        Question q1 = new Question();
        q1.setId(1);
        q1.setText("poasjdioasd");
        Question q2 = new Question();
        q2.setId(2);
        q2.setText("fsfadfdsfasdf");

        Answer a1 = new Answer();
        a1.setAnswerID(1);
        a1.setQuestionID(1);
        a1.setText("gasdf");

        Answer a2 = new Answer();
        a2.setAnswerID(2);
        a2.setQuestionID(1);
        a2.setText("fasfsadf");

        Answer a3 = new Answer();
        a3.setAnswerID(3);
        a3.setQuestionID(2);
        a3.setText("bsdfbsdfb");

        Answer a4 = new Answer();
        a4.setAnswerID(4);
        a4.setQuestionID(2);
        a4.setText("wcecwef");

        Qwa qwa1 = new Qwa();
        Qwa qwa2 = new Qwa();
        qwa1.setQuestion(q1);
        qwa2.setQuestion(q2);
        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(a1);
        answerList1.add(a2);
        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(a3);
        answerList2.add(a4);

        qwa1.setAnswers(answerList1);
        qwa2.setAnswers(answerList2);

        QuizSet quizSet = new QuizSet();
        quizSet.addQwa(qwa1);
        quizSet.addQwa(qwa2);

        String s = "";
        Gson gson = new GsonBuilder().create();
        StringWriter stringWriter = new StringWriter();
        gson.toJson(quizSet, stringWriter);
        System.out.println(stringWriter.toString());

        QuizSet set = gson.fromJson(stringWriter.toString(), QuizSet.class);

        assertEquals("poasjdioasd", set.getQwaList().get(0).getQuestion().getText());
    }
}
