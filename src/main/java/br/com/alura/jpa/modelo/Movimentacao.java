package br.com.alura.jpa.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime data;
    private String descricao;
    private BigDecimal valor;
    @ManyToOne
    private Conta conta;

    @ManyToMany
    private List<Categoria> categoria;


    public Movimentacao(TipoMovimentacao tipoMovimentacao, LocalDateTime data, String descricao, BigDecimal valor) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;

    }

    public Movimentacao(){}

    public Long getId() {
        return id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }
}
