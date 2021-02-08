package br.com.tomioka.jpa.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tomioka.jpa.modelo.Categoria;
import br.com.tomioka.jpa.modelo.Conta;
import br.com.tomioka.jpa.modelo.Movimentacao;
import br.com.tomioka.jpa.modelo.enums.TipoMovimentacao;

public class TesteMovimentacaoComCategoria {
	
	public static void main(String[] args) {
		
		Categoria cat1 = new Categoria("Comida");
		Categoria cat2 = new Categoria("Restaurante");
		
		Conta conta = new Conta();
		conta.setId(1L); // ou setId((long) 1)
		
		Movimentacao mov1 = new Movimentacao();
		mov1.setData(LocalDateTime.now());
		mov1.setDescricao("Compras mercado");
		mov1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov1.setValor(new BigDecimal(150.0));
		mov1.setConta(conta);
		mov1.setCategoria(Arrays.asList(cat1));
		
		Movimentacao mov2 = new Movimentacao();
		mov2.setData(LocalDateTime.now());
		mov2.setDescricao("KFC");
		mov2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		mov2.setValor(new BigDecimal(30.0));
		mov2.setConta(conta);
		mov2.setCategoria(Arrays.asList(cat1, cat2));
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tomioka");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cat1);
		em.persist(cat2);
		
		em.persist(mov1);
		em.persist(mov2);
		
		em.getTransaction().commit();
		em.close();
		
		
		
	}

}
