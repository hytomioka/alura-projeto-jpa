package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;

public class TesteAtualizaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tomioka");
		EntityManager em = emf.createEntityManager();
		
		// Atualizar dados na tabela
		Conta contaEscolhida = em.find(Conta.class, 1L);
		
		System.out.println("Conta atualizada: " + contaEscolhida.getTitular());
		
		/*
		 * O método find, ou persist do EntityManager, retornam um objeto gerado que foi buscado no 
		 * banco de dados. Posteriormente, o JPA e o Hibernate ainda mantêm uma referência a este
		 * objeto gerado, ou seja, em estado MANAGED.
		 * Isso permite que uma mudança no objeto, acarreta uma mudança no banco de dados.
		 * 
		 */
		
		em.getTransaction().begin();
		contaEscolhida.setSaldo(100.0); // alteração do estado do modelo
		em.getTransaction().commit();
		
		
	}

}
