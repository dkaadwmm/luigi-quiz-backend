package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Question {
	@Id
	@GeneratedValue
	private int questionID;
	private String text;
	
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