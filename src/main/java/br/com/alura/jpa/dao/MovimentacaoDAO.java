package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.conexao.ConexaoJPA;
import br.com.alura.jpa.dto.MovimentacaoDTO;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDAO {

	private static EntityManager em;
	
	public EntityManager getEntityManager() {
		
		if (em == null) {
			em = ConexaoJPA.getEntityManager();
		}
		
		return em;
	}
	
	/*
	 * public List<MovimentacaoDTO> getNamedQuery() {
	 * 
	 * TypedQuery<MovimentacaoDTO> dto =
	 * getEntityManager().createNamedQuery("mediaDiariaMovimentacoes",
	 * MovimentacaoDTO.class);
	 * 
	 * return dto.getResultList(); }
	 */

	public List<MovimentacaoDTO> getMediaDiariaDasMovimentacoes() {
		String jpql = "select new br.com.alura.jpa.dto.MovimentacaoDTO(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<MovimentacaoDTO> dto = getEntityManager().createQuery(jpql, MovimentacaoDTO.class);

		return dto.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {

		String jpql = "select sum(m.valor) from Movimentacao m";

		TypedQuery<BigDecimal> query = getEntityManager().createQuery(jpql, BigDecimal.class);

		return query.getSingleResult();

	}

}
