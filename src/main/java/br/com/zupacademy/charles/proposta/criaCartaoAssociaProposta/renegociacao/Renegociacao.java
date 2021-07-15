package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.renegociacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/*
*
* Esta classe foi comentada pois o cliente externo está retornando um valor nulo.
* Na documentação no Swagger o cliente externo deveria retornar os atributos aqui constantes
*
@Entity
public class Renegociacao {

    @Id
    private String id;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDateTime dataDeCriacao;
    @OneToOne
    private Cartao cartao;

    @Deprecated
    public Renegociacao(){}

    public Renegociacao(String id, int quantidade, BigDecimal valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() { return id; }

    public Integer getQuantidade() { return quantidade; }

    public BigDecimal getValor() { return valor; }

    public LocalDateTime getDataDeCriacao() { return dataDeCriacao; }

    public Cartao getCartao() { return cartao; }
}
 */

