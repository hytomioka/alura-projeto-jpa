package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;

public class TesteAtualizaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Atualizar dados na tabela
		Conta contaEscolhida = em.find(Conta.class, 1L);
		
		contaEscolhida.setSaldo(50.0);
		
		System.out.println("Conta atualizada: " + contaEscolhida.getTitular());
		
		em.getTransaction().begin();
		em.persist(contaEscolhida);
		em.getTransaction().commit();
		
		
	}

}
