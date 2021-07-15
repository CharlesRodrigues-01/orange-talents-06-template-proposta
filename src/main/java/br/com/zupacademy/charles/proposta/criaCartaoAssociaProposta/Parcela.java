package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Parcela {

    @Id
    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    @ManyToOne
    @JsonIgnore
    private Cartao cartao;

    @Deprecated
    public Parcela() {}

    public Parcela(String id, int quantidade, BigDecimal valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    public String getId() { return id; }

    public Integer getQuantidade() { return quantidade; }

    public BigDecimal getValor() { return valor; }

    public Cartao getCartao() { return cartao; }
}
