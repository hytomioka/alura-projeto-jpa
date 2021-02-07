package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;

public class TesteInsereDadosComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta novaConta = new Conta();
		novaConta.setAgencia(1100);
		novaConta.setConta(114422);
		novaConta.setTitular("Antonio Silva");
		novaConta.setSaldo(1000.0);
		
		em.getTransaction().begin();
		
		em.persist(novaConta);
		
		em.getTransaction().commit();
		
	}

}
