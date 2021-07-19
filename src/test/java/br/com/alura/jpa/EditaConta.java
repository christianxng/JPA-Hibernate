package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EditaConta {
    public static void main (String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Conta conta = entityManager.find(Conta.class, 1L);
        conta.setSaldo(50000.00);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        System.out.println(conta.getTitular());
    }
}
