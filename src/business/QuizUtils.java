package business;

import model.QuizSet;
import model.Qwa;
import persistenz.DBManager;
import java.util.List;

public class QuizUtils {
    
    public static QuizSet generateRandomQuizSet(int questionAmountToGet){
        QuizSet quizSet = new QuizSet();
        List<Integer> questionIDList = DBManager.getQuestionsIDForQuizset(questionAmountToGet);
        for (Integer questionID:questionIDList ){
            quizSet.addQwa(DBManager.getQwaByID(questionID));
        }
        return quizSet;
    }
    
	public static void createQwa(Qwa qwa) {
        DBManager.insertQwa(qwa);
	}
	
	public static void updateQwa(Qwa qwa) {
		DBManager.updateQwa(qwa);
	}
	
	public static void removeQwa(int questionID) {
        //from id delete Qwa object
        Qwa qwa = DBManager.getQwaByID(questionID);
        DBManager.deleteQwa(qwa);
	}
}
