package persistenz;

import model.Answer;
import model.Question;
import model.Qwa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DBManager {
	
	public static Qwa getQwaByID(int id) {
		Qwa qwa = new Qwa();

	    SessionFactory factory = HibernateUtil.getSessionFactory();
	    Session session = factory.openSession();

	    Question q = (Question) session.get(Question.class, id);
	    qwa.setQuestion(q);
	    
	    List<Answer> a = (List<Answer>) session.createQuery("from Answer where questionID =" + id).list();
	    qwa.setAnswers(a);

	    session.close();
	    return qwa;
	}
	public static int getQuestionCount(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		int questionCount = ((Long)session.createQuery("select count(*) from Question").iterate().next()).intValue();

		session.close();
		return questionCount;
	}

	public static List<Integer> getQuestionsIDForQuizset(int questionAmountToGet){
		List<Integer> questionIDsList;

		int questionsInDB = DBManager.getQuestionCount();
		String query = "SELECT questionID FROM Question ORDER BY RAND()";

		SessionFactory factory = HibernateUtil.getSessionFactory();

		if (questionAmountToGet < questionsInDB) {
			questionIDsList = factory.openSession().createQuery(query).setMaxResults(questionAmountToGet).list();
		}
		else {
			questionIDsList = factory.openSession().createQuery(query).setMaxResults(questionsInDB).list();
		}
		return questionIDsList;
		}
    public static void insertQwaInDB(Qwa qwa){
        Question question = qwa.getQuestion();
        List<Answer> answerList = qwa.getAnswers();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(question);
        int questionID = question.getId();

        for (Answer answer:answerList){
            answer.setQuestionID(questionID);
            session.save(answer);
        }
        session.getTransaction().commit();
        session.close();

    }
	}
