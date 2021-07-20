package br.com.alura.jpa;

import br.com.alura.jpa.modelo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TestaRelacionamentoClienteConta {
    public static void main (String [] args){

        Conta conta =  new Conta("Mario R ",3040,9989,new BigDecimal("5000.0"));
        Cliente cliente = new Cliente("Mario R","Developer","Avenida Mario Werneck, 1000");
        cliente.setConta(conta);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
