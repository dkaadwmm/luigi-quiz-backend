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

        session.clear();
	    session.close();
	    return qwa;
	}

	private static int getQuestionCount(){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		int questionCount = ((Long)session.createQuery("select count(*) from Question").iterate().next()).intValue();

		session.close();
        //1session.clear();
		return questionCount;
	}

	public static List getQuestionsIDForQuizset(int questionAmountToGet){
		List questionIDsList;

		int questionsInDB = DBManager.getQuestionCount();
		String query;
        query = "SELECT questionID FROM Question ORDER BY RAND()";

        SessionFactory factory = HibernateUtil.getSessionFactory();

		if (questionAmountToGet < questionsInDB) {
            questionIDsList = factory.openSession().createQuery(query).setMaxResults(questionAmountToGet).list();
        }
		else {
			questionIDsList = factory.openSession().createQuery(query).setMaxResults(questionsInDB).list();
		}
		return questionIDsList;
		}

    public static void insertQwa(Qwa qwa){
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
        session.clear();
        session.close();
    }

    public static void updateQwa(Qwa qwa){
        Question question = qwa.getQuestion();
        List<Answer> answerList = qwa.getAnswers();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(question);

        for(Answer answer : answerList) {
            session.update(answer);
        }
        session.getTransaction().commit();
        //session.evict(question);
        session.clear();
        session.close();
    }

    public static void deleteQwa(Qwa qwa){
        Question question = qwa.getQuestion();
        List<Answer> answerList = qwa.getAnswers();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(question);

        for(Answer answer:answerList) {
            session.delete(answer);
        }

        session.getTransaction().commit();
        session.evict(question);
        session.clear();
        session.close();
    }

    }