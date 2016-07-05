package unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Qwa;
import persistenz.DBManager;

public class QwaTestDB {

	@Test
	public void test() {
		Qwa qwa = DBManager.getQwaByID(1);
		assertEquals("Was ist Spring?", qwa.getQuestion().getText());
		assertEquals("Java Webframework", qwa.getAnswers().get(0).getText());
		assertEquals("Party in München", qwa.getAnswers().get(1).getText());
	}
}