package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.vencimento;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.vencimento.Vencimento;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class VencimentoResponse {

    private String id;
    private int dia;
    private String dataDeCriacao;

    public VencimentoResponse(String id, int dia, String dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() { return id; }

    public int getDia() { return dia; }

    public String getDataDeCriacao() { return dataDeCriacao; }

    public Vencimento toModel() {
        return new Vencimento(this.id, this.dia, LocalDateTime.parse(this.dataDeCriacao, ISO_LOCAL_DATE_TIME));
    }
}
