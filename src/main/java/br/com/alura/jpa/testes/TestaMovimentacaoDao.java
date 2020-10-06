package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.dto.MovimentacaoDTO;

public class TestaMovimentacaoDao {

	public static void main(String[] args) {
		
		List<MovimentacaoDTO> dto = new MovimentacaoDAO().getMediaDiariaDasMovimentacoes();
		
		dto.forEach(media -> System.out.println(
				"A média das movimentações: " + media.getValor() + ", dia " + media.getDia() + "/" + media.getMes()));
		
		BigDecimal bg = new MovimentacaoDAO().getSomaDasMovimentacoes();
		
		System.out.println("Soma das movimentações: " + bg);
	}

}
