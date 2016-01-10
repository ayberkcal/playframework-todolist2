package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static EntityManagerFactory entityManagerFactory;

	// private static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null)
			entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager;
	}
}
