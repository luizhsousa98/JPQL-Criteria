package br.com.alura.jpa.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConexaoJPA {
	
	private static EntityManagerFactory emf;
	private static final String PERSISTENCE = "alura";
	private static ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();
	
	public ConexaoJPA() {
		
	}
	
	public static EntityManager getEntityManager() {
		
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE);
		}
		
		EntityManager em = threadLocal.get();
		
		if (em == null || em.isOpen()) {
			em = emf.createEntityManager();
			ConexaoJPA.threadLocal.set(em);
		}
		
		return em;
	}
	
	/**
	 * Fechando transa��o
	 */

	public static void closeEntityManager() {
		EntityManager em = threadLocal.get();

		if (em != null) {
			EntityTransaction transaction = em.getTransaction();
			// Abrindo transa��o
			if (transaction.isActive()) {
				transaction.begin();
			}

			// fechando transa��o
			em.close();

			threadLocal.set(null);
		}
	}

	/**
	 * Fechando comunica��o com persistence.xml
	 */
	public static void closeEntityManagerFactory() {
		closeEntityManager();
		emf.close();
	}
	

}
