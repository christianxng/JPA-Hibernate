package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaRelacionamentoContaMovimentacao {
    public static void main (String [] args){

        Movimentacao movimentacao = new Movimentacao(
                TipoMovimentacao.ENTRADA,
                LocalDateTime.now(),
                "Venda de telefone",
                new BigDecimal("6000.0")
        );
        Conta conta =  new Conta("Christian Roddrigues Moura",3636,5000,2.500);
        movimentacao.setConta(conta);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        // devemos persistir primeiro a conta para gerar o ID. Em seguida a movimentação.
        entityManager.persist(conta);
        entityManager.persist(movimentacao);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
