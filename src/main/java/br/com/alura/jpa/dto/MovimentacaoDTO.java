package br.com.alura.jpa.dto;

/**
 * 
 * @author lhsousa Uma projeção que me ajuda a efetuar o a consulta quando
 *         utilizo avg do tipo Double e Integer do tipo dia e mes
 */
public class MovimentacaoDTO {

	private Double valor;
	private Integer dia;
	private Integer mes;

	public MovimentacaoDTO(final Double valor, final Integer dia, final Integer mes) {
		this.valor = valor;
		this.dia = dia;
		this.mes = mes;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getDia() {
		return dia;
	}

	public Integer getMes() {
		return mes;
	}

}
