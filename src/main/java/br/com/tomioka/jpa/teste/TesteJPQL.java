package br.com.tomioka.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tomioka.jpa.modelo.Conta;
import br.com.tomioka.jpa.modelo.Movimentacao;

/* 
 * JPQL - Java Persistence Query Language 
 * Pode realizar queries a partir de objetos
 */

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tomioka");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor asc";
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pConta", conta); // Executa a query com um parametro (objeto conta)
		List<Movimentacao> rl = query.getResultList();
		
		for (Movimentacao movimentacao : rl) {
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("Valor: " + movimentacao.getValor());
		}
		
	}

}
