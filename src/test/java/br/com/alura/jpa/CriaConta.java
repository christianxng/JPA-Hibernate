package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CriaConta {
    public static void main (String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Conta conta = new Conta("Christian Roddrigues Moura",3636,5000,new BigDecimal("2500.0"));
        Conta conta2 = new Conta("João",3636,5001,new BigDecimal("3000.0"));
        Conta conta3 = new Conta("Maria",3636,5002,new BigDecimal("1500.0"));
        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.persist(conta2);
        entityManager.persist(conta3);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
