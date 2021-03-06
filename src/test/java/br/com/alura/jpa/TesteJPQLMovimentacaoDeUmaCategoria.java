package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQLMovimentacaoDeUmaCategoria {

    public static void main (String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String sql =  "select m from Movimentacao m join m.categoria c where c = :pCategoria";
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        TypedQuery<Movimentacao> query = entityManager.createQuery(sql,Movimentacao.class);
        query.setParameter("pCategoria", categoria);
        List<Movimentacao> movimentacoes = query.getResultList();
        for(Movimentacao movimentacao : movimentacoes){
            System.out.println("Categoria: " + movimentacao.getCategoria() +
                    "\t --  Tipo: " + movimentacao.getTipoMovimentacao() +
                    "\t --  Valor: " + movimentacao.getValor() +
                    "\t --  Descrição: " + movimentacao.getDescricao()
            );
        }
    }
}
