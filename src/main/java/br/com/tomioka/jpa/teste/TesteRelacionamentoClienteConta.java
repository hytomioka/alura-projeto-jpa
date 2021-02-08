package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Cliente;
import br.com.tomioka.jpa.modelo.Conta;


/*
 * Cardinalidade: princípio fundamental sobre o relacionamento de um banco de dados 
 * relacional (Níveis de relacionamento: 1:1; 1:N; N:N).
 * Link para informações mais detalhadas:
 * https://pt.wikipedia.org/wiki/Cardinalidade_(modelagem_de_dados)
 */

public class TesteRelacionamentoClienteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cli = new Cliente();
		cli.setNome("José Roberto");
		cli.setEndereco("Rua das Flores, 22");
		cli.setProfissao("Professor");
		cli.setConta(conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tomioka");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cli);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
}
