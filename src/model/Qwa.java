package model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Qwa {
	private Question question;
	private List<Answer> answers;

	public Qwa(){

	}

	public Qwa(Question question, List<Answer> answers) {
		this.question = question;
		this.answers = answers;
	}

	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public void shuffleAnswers() {
		if (!answers.isEmpty()) {
			long seed = System.nanoTime();
			Collections.shuffle(answers, new Random(seed));
			Collections.shuffle(answers, new Random(seed));
		}
	}
}