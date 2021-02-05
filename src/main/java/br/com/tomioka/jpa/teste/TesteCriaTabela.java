package br.com.tomioka.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabela {

	public static void main(String[] args) {
		// Persistence acessa o arquivo persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}

}
