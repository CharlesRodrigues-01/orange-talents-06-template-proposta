package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.renegociacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/*
*
* Esta classe foi comentada pois o cliente externo está retornando um valor nulo.
* Na documentação no Swagger o cliente externo deveria retornar os atributos aqui constantes
*
public class RenegociacaoResponse {

    private String id;
    private int quantidade;
    private int valor;
    private String dataDeCriacao;

    public RenegociacaoResponse(String id, int quantidade, int valor, String dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() { return id; }

    public int getQuantidade() { return quantidade; }

    public int getValor() { return valor; }

    public String getDataDeCriacao() { return dataDeCriacao; }

    public Renegociacao toModel() {
        return new Renegociacao(this.id, this.quantidade, new BigDecimal(this.valor),
                                LocalDateTime.parse(this.dataDeCriacao));
    }
}
*/