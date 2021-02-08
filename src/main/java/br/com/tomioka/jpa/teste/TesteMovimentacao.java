package br.com.tomioka.jpa.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;
import br.com.tomioka.jpa.modelo.Movimentacao;
import br.com.tomioka.jpa.modelo.enums.TipoMovimentacao;

public class TesteMovimentacao {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia(2134);
		conta.setConta(502391);
		conta.setTitular("Mateus");
		conta.setSaldo(1000.0);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(100.0));
		movimentacao.setDescricao("Rodizio japones");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tomioka");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(conta);
		em.persist(movimentacao);

		em.getTransaction().commit();

	}

}
