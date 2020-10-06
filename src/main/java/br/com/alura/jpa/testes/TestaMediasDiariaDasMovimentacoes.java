package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.*;

import br.com.alura.jpa.dto.MovimentacaoDTO;

public class TestaMediasDiariaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");

		EntityManager em = emf.createEntityManager();
		// trazendo media, data
		String jpql = "select new br.com.alura.jpa.dto.MovimentacaoDTO(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<MovimentacaoDTO> query = em.createQuery(jpql, MovimentacaoDTO.class);
		// Essa não é uma forma muito boa de se fazer embora funcione
		/**
		 * List<Object[]> mediaDasMovimentacoes = query.getResultList();
		 * 
		 * mediaDasMovimentacoes.forEach(media -> System.out.println("A média das
		 * movimentações: " + media[0] + media[1] + media[2]));
		 **/

		List<MovimentacaoDTO> dto = query.getResultList();

		dto.forEach(media -> System.out.println(
				"A média das movimentações: " + media.getValor() + ", dia " + media.getDia() + "/" + media.getMes()));

	}

}
