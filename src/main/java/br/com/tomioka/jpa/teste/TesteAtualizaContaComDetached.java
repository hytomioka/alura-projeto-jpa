package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;

public class TesteAtualizaContaComDetached {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tomioka");
		EntityManager em = emf.createEntityManager();
		
		Conta novaConta = new Conta();
		novaConta.setAgencia(1234);
		novaConta.setConta(432154);
		novaConta.setTitular("José Roberto");
		novaConta.setSaldo(2000.0);
		
		em.getTransaction().begin();
		em.persist(novaConta);
		em.getTransaction().commit();
		// Detaching do EntityManager (o objeto deixa de ser Managed)
		em.close();
		
		// Criando novo EntityManager, já que a primeira foi "detached"
		EntityManager em2 = emf.createEntityManager();
		novaConta.setSaldo(2500.0);
		
		em2.getTransaction().begin();
		// O método merge() transforma o objeto em "Managed" novamente
		em2.merge(novaConta);
		em2.getTransaction().commit();
	}

}
