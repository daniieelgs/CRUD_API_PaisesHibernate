package Model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class CountryDAO {

	public void savePais(Country country) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

        	transaction = session.beginTransaction();

            session.saveOrUpdate(country);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	public void deletePais(Country country) {
		
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

        	transaction = session.beginTransaction();

            session.delete(country);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		
	}
	
    public List<Country> getCountries() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Country", Country.class).list();
        }
    }
    public Country getCountry(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Country.class, id);
        }
    }
	
}
