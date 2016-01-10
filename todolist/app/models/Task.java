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
		EntityManager entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
		List<Task> tasks = entityManager.createQuery("from Task").getResultList();
		entityManager.close(); 
		 
		 return tasks;
		
        
	}

	public static void create(Task task) {
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
