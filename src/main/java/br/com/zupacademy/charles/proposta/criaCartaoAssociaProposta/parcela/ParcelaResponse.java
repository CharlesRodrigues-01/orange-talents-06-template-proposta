package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.parcela;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.parcela.Parcela;

import java.math.BigDecimal;


public class ParcelaResponse {

    private String id;
    private int quantidade;
    private int valor;

    public ParcelaResponse(String id, int quantidade, int valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getId() { return id; }

    public int getQuantidade() { return quantidade; }

    public int getValor() { return valor; }

    public Parcela toModel() {
        return new Parcela(this.id, this.quantidade, new BigDecimal(this.valor));
    }
}
