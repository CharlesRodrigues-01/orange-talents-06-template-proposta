package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Avisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate validoAte;
    @NotBlank
    private String destino;
    @NotNull
    private LocalDateTime momentoAviso;
    @ManyToOne
    @JsonIgnore
    private Cartao cartao;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Cliente cliente;

    @Deprecated
    public Avisos(){}

    public Avisos(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public Avisos(LocalDate validoAte, String destino, Cliente cliente, Cartao cartao) {
        this.validoAte = validoAte;
        this.destino = destino;
        this.cliente = cliente;
        this.cartao = cartao;
        this.momentoAviso = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public LocalDate getValidoAte() { return validoAte; }

    public String getDestino() { return destino; }

    public Cartao getCartao() { return cartao; }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getMomentoAviso() {
        return momentoAviso;
    }
}
