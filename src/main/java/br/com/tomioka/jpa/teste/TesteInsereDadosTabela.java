package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;

public class TesteInsereDadosTabela {
	
	public static void main(String[] args) {
		
		Conta novaConta = new Conta();
		novaConta.setAgencia(2233);
		novaConta.setConta(553322);
		novaConta.setTitular("Jo�o Cardoso");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// O objeto ser� persistido somente atrav�s de uma transa��o.
		
		em.getTransaction().begin();
		
		em.persist(novaConta);
		
		em.getTransaction().commit();
		
		
		
	}

}
