package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Bloqueio {

    @Id
    private String id;
    private LocalDateTime bloqueadoEm;
    private String sistemaResponsavel;
    private boolean ativo;
    @ManyToOne
    @JsonIgnore
    private Cartao cartao;

    @Deprecated
    public Bloqueio() {}

    public Bloqueio(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {
        this.id = id;
        this.bloqueadoEm = bloqueadoEm;
        this.sistemaResponsavel = sistemaResponsavel;
        this.ativo = ativo;
    }

    public String getId() { return id; }

    public LocalDateTime getBloqueadoEm() { return bloqueadoEm; }

    public String getSistemaResponsavel() { return sistemaResponsavel; }

    public boolean isAtivo() { return ativo; }

    public Cartao getCartao() { return cartao; }
}
