package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Answer {
	@Id
	@GeneratedValue
	private int answerID;
	private String text;
	private int questionID;
	private boolean isCorrect;
	
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}