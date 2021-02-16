package net.javaguides.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Categorie;

import net.javaguides.hibernate.util.HibernateUtil;



public class App {
	public static void main(String[] args) {
    	
		Categorie cat = new Categorie("Paris ville de la lumiére");
		Categorie cat1 = new Categorie("Les misérable");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student objects
			session.save(cat);
			session.save(cat1);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Categorie> students = session.createQuery("from Categorie", Categorie.class).list();
			students.forEach(s -> {
				System.out.println("Print Livre Langue id : " + s.getLibelle());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
