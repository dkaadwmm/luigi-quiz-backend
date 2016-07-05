package persistenz;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Answer;
import model.Question;
import model.Qwa;

public class DBManager {
	
	public static Qwa getQwaByID(int id) {
		Qwa qwa = new Qwa();
		
	    SessionFactory factory = HibernateUtil.getSessionFactory();
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    Question q = (Question) session.get(Question.class, id);
	    qwa.setQuestion(q);
	    
	    List<Answer> a = (List<Answer>) session.createQuery("from Answer where questionID =" + id).list();
	    qwa.setAnswers(a);
	    
	    session.close();
	    factory.close();
	    
	    return qwa;
	}
}