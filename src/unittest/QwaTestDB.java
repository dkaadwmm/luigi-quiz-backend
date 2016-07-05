package unittest;

import static org.junit.Assert.*;

import model.Answer;
import model.Question;
import model.QuizSet;
import org.json.JSONObject;
import org.junit.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Qwa;
import persistenz.DBManager;

import javax.xml.ws.Response;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class QwaTestDB {

	@Test
	public void test() {

		Qwa qwa = DBManager.getQwaByID(1);
		assertEquals("Was ist Spring?", qwa.getQuestion().getText());
		assertEquals("Java Webframework", qwa.getAnswers().get(0).getText());
		assertEquals("Party in München", qwa.getAnswers().get(1).getText());
	}
}