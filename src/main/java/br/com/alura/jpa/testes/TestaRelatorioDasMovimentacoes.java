package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		// Colocar os atributos e o nome da classe
		//join fetch inner join, left join tudo que est� na esquerda independente de relacionamento ou n�o
		String jpql = "select c from Conta c left join fetch c.movimentacoes";

		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

		query.getResultList().forEach(conta -> {

			System.out.println("Titular => " + conta.getTitular() + ", ag�ncia => " + conta.getAgencia()
					+ ", n�mero => " + conta.getNumero() + ", movimenta��es => " + conta.getMovimentacoes());
		});

	}

}
