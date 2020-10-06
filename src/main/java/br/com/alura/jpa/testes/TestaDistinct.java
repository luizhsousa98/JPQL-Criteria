package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaDistinct {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		// Me retorna valores diferentes sem ser repetidos
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";

		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

		query.getResultList().forEach(conta -> {
			System.out.println("Titular => " + conta.getTitular() + ", agência => " + conta.getAgencia()
					+ ", número => " + conta.getNumero() + ", movimentações => " + conta.getMovimentacoes());
		});
	}
}
