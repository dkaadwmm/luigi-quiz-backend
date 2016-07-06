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
}
