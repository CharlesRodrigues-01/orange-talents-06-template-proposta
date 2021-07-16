package br.com.zupacademy.charles.proposta.cadastroBiometria;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fingerprint;
    @NotNull
    private final LocalDate dataRegistro = LocalDate.now();

    @ManyToOne
    private Cartao cartao;

    @Deprecated
    public Biometria(){}

    public Biometria(Cartao cartao, String fingerprint) {
        this.cartao = cartao;
        this.fingerprint = fingerprint;
    }

    public Long getId() { return id; }

    public String getFingerprint() { return fingerprint; }

    public LocalDate getDataRegistro() { return dataRegistro; }

    public Cartao getCartao() { return cartao; }
}
