package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Avisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime validoAte;
    @NotBlank
    private String destino;
    @ManyToOne
    @JsonIgnore
    private Cartao cartao;

    @Deprecated
    public Avisos(){}

    public Avisos(LocalDateTime validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public Long getId() { return id; }

    public LocalDateTime getValidoAte() { return validoAte; }

    public String getDestino() { return destino; }

    public Cartao getCartao() { return cartao; }
}
