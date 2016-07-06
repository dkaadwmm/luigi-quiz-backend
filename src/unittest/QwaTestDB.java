package unittest;

import business.QuizUtils;
import model.Answer;
import model.Question;
import model.Qwa;
import org.junit.Test;
import persistenz.DBManager;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QwaTestDB {

	@Test
	public void test() {
		Qwa qwa = DBManager.getQwaByID(1);
		Qwa qwa2 = DBManager.getQwaByID(2);
		Qwa insertQwa1 = DBManager.getQwaByID(12);


		int count = 2;
		Qwa insertQwa = new Qwa();
		Question question = new Question();
		List<Answer> answerList = new LinkedList<>();

		question.setText("This is a Question");
		question.setId(17);

		Answer answer = new Answer();
		answer.setText("Answers 1update222");
		answer.setCorrect(false);
		answer.setQuestionID(17);
		answer.setAnswerID(33);

		Answer answer2 = new Answer();
		answer2.setText("Answers 2update222");
		answer2.setCorrect(true);
		answer2.setQuestionID(17);
		answer2.setAnswerID(34);
		answerList.add(answer);
		answerList.add(answer2);
		insertQwa.setQuestion(question);
		insertQwa.setAnswers(answerList);
		DBManager.updateQwa(insertQwa);

		assertEquals("This is a Question, update", qwa.getQuestion().getText());

		//assertEquals(count, DBManager.getQuestionsIDForQuizset(10).size());
		//assertEquals(count, DBManager.getQuestionCount());
		assertEquals("Was ist Spring?", qwa.getQuestion().getText());
		assertEquals("Java Webframework", qwa.getAnswers().get(0).getText());
		assertEquals("Party in München", qwa.getAnswers().get(1).getText());
/*
		JSONObject jsonObject = new JSONObject();
		QuizSet qs = new QuizSet();
		qs.addQwa(DBManager.getQwaByID(1));

		jsonObject.put("QuizSet", qs);

		System.out.println(jsonObject);*/
	}
}