package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;

public class TesteTransicaoEstado {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Transient (o objeto Conta ainda não está sincronizado com o JPA)
		Conta conta = new Conta();
		conta.setAgencia(1114);
		conta.setConta(111422);
		conta.setTitular("Mario Souza");
		conta.setSaldo(3000.0);
		
		
		em.getTransaction().begin();
		// Transient -> Managed (o objeto Conta está sincronizado com o JPA)
		em.persist(conta);
		em.getTransaction().commit();
		
		// Managed -> Removed (o objeto Conta foi removido do JPA, e consequentemente do banco de dados)
		em.remove(conta);
		
		/*
		 * Vale notar que os métodos dispostos pela interface do EntityManager não estão diretamente
		 * relacionadas com o uso métodos SQL específico (e.g. SELECT, INSERT, DELETE), e sim com
		 * a transição de estado.
		 */
		
		
	}

}
