package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import com.sun.tools.jconsole.JConsoleContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQL {
    public static void main (String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connection");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String sql =  "select m from Movimentacao m where m.conta = :pConta order by m.valor asc";
        Conta conta = new Conta();
        conta.setId(6L);
        TypedQuery<Movimentacao> query = entityManager.createQuery(sql,Movimentacao.class);
        query.setParameter("pConta", conta);
        List<Movimentacao> movimentacoes = query.getResultList();
        for(Movimentacao movimentacao : movimentacoes){
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao() +
                    "\t --  Valor: " + movimentacao.getValor() +
                    "\t --  Descrição: " + movimentacao.getDescricao()
            );
        }
    }
}
