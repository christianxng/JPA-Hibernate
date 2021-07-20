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
        // editando saldo
        conta.setSaldo(50000.00);
        entityManager.getTransaction().commit();
        entityManager.close();

        // realizando outra edição.
        // gerar outro entity manager, pois o primeiro já foi fechado e não pode ser reaberto.
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        entityManager2.getTransaction().begin();
        //editando o Nome do titular
        conta.setTitular("Mario");
        // o método get realiza a busca primeiro(não tem mais o obejto salvo em memória)
        // depois realiza a operação de mudança.
        entityManager2.merge(conta);
        entityManager2.getTransaction().commit();
        entityManager2.close();
        entityManagerFactory.close();

    }
}
