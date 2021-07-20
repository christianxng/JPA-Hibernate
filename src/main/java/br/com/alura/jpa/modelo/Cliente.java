package br.com.alura.jpa.modelo;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String profissao;
    private String endereco;
    @JoinColumn(unique = true)
    @OneToOne
    private Conta conta;

    public Cliente(String nome, String profissao, String endereco) {
        this.nome = nome;
        this.profissao = profissao;
        this.endereco = endereco;
    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
