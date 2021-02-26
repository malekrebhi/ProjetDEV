package App;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Domain.Util.HibernateUtil;

public class MyApp {

	public static void main(String[] args) {
		
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            transaction.commit();
            System.out.println("SUCCES !");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

	}

}
