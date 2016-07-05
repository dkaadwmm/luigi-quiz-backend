package unittest;

import static org.junit.Assert.*;

import model.QuizSet;
import org.json.JSONObject;
import org.junit.Test;

import model.Qwa;
import persistenz.DBManager;

import javax.xml.ws.Response;

public class QwaTestDB {

	@Test
	public void test() {
		Qwa qwa = DBManager.getQwaByID(1);
		Qwa qwa2 = DBManager.getQwaByID(2);
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