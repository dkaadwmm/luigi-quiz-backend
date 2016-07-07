package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the model for a question. Equals the columns of Table "question" in the Database.
 */

@Entity
@Table
public class Question {
	@Id
	@GeneratedValue
	private int questionID;
	private String text;

	public Question(){

	}

	public Question(int questionID, String text) {
		this.questionID = questionID;
		this.text = text;
	}

	public int getId() {
		return questionID;
	}
	
	public void setId(int id) {
		this.questionID = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}