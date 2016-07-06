package business;


import model.QuizSet;

import persistenz.DBManager;


import java.util.List;

public class QuizUtils {
    public static QuizSet createRandomQuizSet(int questionAmountToGet){
        QuizSet quizSet = new QuizSet();
        List<Integer> questionIDList = DBManager.getQuestionsIDForQuizset(questionAmountToGet);
        for (Integer questionID:questionIDList ){
            quizSet.addQwa(DBManager.getQwaByID(questionID));
        }
        return quizSet;
    }
}
