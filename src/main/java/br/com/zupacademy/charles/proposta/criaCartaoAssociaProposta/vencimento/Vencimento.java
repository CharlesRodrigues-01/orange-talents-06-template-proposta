package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.vencimento;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Embeddable
public class Vencimento {

    @Id
    private String id;
    @Column(name="DIA_VENCIMENTO")
    private Integer dia;
    @Column(name="DATA_VENCIMENTO")
    private LocalDateTime dataDeCriacao;


    @Deprecated
    public Vencimento(){}

    public Vencimento(String id, int dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() { return id; }

    public Integer getDia() { return dia; }

    public LocalDateTime getDataDeCriacao() { return dataDeCriacao; }

}
