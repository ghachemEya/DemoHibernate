package net.javaguides.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Auteur;
import net.javaguides.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Auteur auteur = new Auteur("Ramesh", "Fadatare", "Tunisien");
		Auteur auteur1 = new Auteur("John", "Cena", "Parisien");
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student objects
			session.save(auteur);
			session.save(auteur1);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
			List<Auteur> auteurs = session.createQuery("from auteur", Auteur.class).list();
			auteurs.forEach(s -> {
				System.out.println("Print auteur nationalite id : " + s.getLastName());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
