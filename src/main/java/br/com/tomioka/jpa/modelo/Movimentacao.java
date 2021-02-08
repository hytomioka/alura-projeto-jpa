package br.com.tomioka.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.tomioka.jpa.modelo.enums.TipoMovimentacao;

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	private LocalDateTime data;
	private String descricao;

	// BigDecimal � um tipo Double com maior precis�o e exatid�o
	private BigDecimal valor;

	/*
	 * Mapeamento autom�tico de chave estrangeira (Muitos para Um). A coluna de
	 * chave estrangeira � utilizada nos relacionamento @*ToMany.
	 */
	@ManyToOne
	private Conta conta;
	
	
	/* 
	 * ManyToMany cria uma tabela de relacionamento entre as entidades relacionadas.
	 * Neste caso, entre Movimentacao e Categoria. H� um padr�o, a tabela de relacionamento
	 * criada ter� o nome de movimentacao_categoria. 
	 */
	@ManyToMany
	private List<Categoria> categoria;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
