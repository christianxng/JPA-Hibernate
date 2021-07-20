package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestaRelacionamentoMovimentacaoCategoria {
    public static void main (String [] args){

        Categoria categoria =  new Categoria("Viagem");
        Categoria categoria2 =  new Categoria("Negócios");

        Movimentacao movimentacao = new Movimentacao(
                TipoMovimentacao.SAIDA,
                LocalDateTime.now(),
                "Viagem para BH",
                new BigDecimal("1500.0")
        );
        Movimentacao movimentacao2 = new Movimentacao(
                TipoMovimentacao.SAIDA,
                LocalDateTime.now(),
                "Viagem para RP",
                new BigDecimal("2000.0")
        );
        movimentacao.setCategoria(Arrays.asList(categoria,categoria2));
        movimentacao2.setCategoria(Arrays.asList(categoria,categoria2));


        Conta conta =  new Conta("Shurek Pardal",3040,9988,new BigDecimal("25000.0"));
        movimentacao.setConta(conta);
        movimentacao2.setConta(conta);



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.persist(categoria);
        entityManager.persist(categoria2);
        entityManager.persist(movimentacao);
        entityManager.persist(movimentacao2);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
