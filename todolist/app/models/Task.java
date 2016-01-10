package models;

import java.util.*;
import utils.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.GenericGenerator;

import play.data.validation.Constraints.Required;


@Entity
@Table(name = "Task")
public class Task {
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Required
	@Column(name = "label")
	public String label;

	public static List<Task> all() {
		/*EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("defaultPersistenceUnit");
		EntityManager entityManager = entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		String asd  = Task.class.getName();
		
        List<Task> result = entityManager.createQuery( "from task", Task.class ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
        */
		
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("defaultPersistenceUnit");
		EntityManager entityManager = entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Task> students = entityManager.createQuery("from Task").getResultList();
		entityManager.close(); 
		 
		 return students;
		
		/*for ( Task task : result ) {
			System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
		}*/
        
	}

	public static void create(Task task) {
		
		 //EntityManagerFactory entityManagerFactory = Persistence
		//		.createEntityManagerFactory("defaultPersistenceUnit");
		//EntityManager entityManager = entityManagerFactory
		//		.createEntityManager();
		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(task);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void delete(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("defaultPersistenceUnit");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
