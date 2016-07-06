package business;


import model.Answer;
import model.Question;
import model.QuizSet;

import model.Qwa;
import persistenz.DBManager;


import java.util.List;

public class QuizUtils {
	
    public static void insertQwa(Qwa qwa){
        Question question = qwa.getQuestion();
        List<Answer> answerList = qwa.getAnswers();

    }
    
    public static QuizSet generateRandomQuizSet(int questionAmountToGet){
        QuizSet quizSet = new QuizSet();
        List<Integer> questionIDList = DBManager.getQuestionsIDForQuizset(questionAmountToGet);
        for (Integer questionID:questionIDList ){
            quizSet.addQwa(DBManager.getQwaByID(questionID));
        }
        return quizSet;
    }
    
	public static QuizSet create(QuizSet quizSet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static QuizSet update(QuizSet quizSet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void remove(int id) {
		// TODO Auto-generated method stub
		
	}
}
