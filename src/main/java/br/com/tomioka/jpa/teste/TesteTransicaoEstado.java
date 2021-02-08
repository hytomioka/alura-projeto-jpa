package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Conta;

public class TesteTransicaoEstado {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tomioka");
		EntityManager em = emf.createEntityManager();
		
		// Transient (o objeto Conta ainda n�o est� sincronizado com o JPA)
		Conta conta = new Conta();
		conta.setAgencia(2145);
		conta.setConta(214522);
		conta.setTitular("Vinicius Fernando");
		conta.setSaldo(600.0);
		
		
		em.getTransaction().begin();
		// Transient -> Managed (o objeto Conta est� sincronizado com o JPA)
		em.persist(conta);
		
		
		// Managed -> Removed (o objeto Conta foi removido do JPA, e consequentemente do banco de dados)
		em.remove(conta);
		em.getTransaction().commit();
		/*
		 * Vale notar que os m�todos dispostos pela interface do EntityManager n�o est�o diretamente
		 * relacionadas com o uso m�todos SQL espec�fico (e.g. SELECT, INSERT, DELETE), e sim com
		 * a transi��o de estado.
		 */
		
		
	}

}
