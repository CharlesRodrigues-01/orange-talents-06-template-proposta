package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos.Avisos;
import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.Bloqueio;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String ipCliente;
    @NotBlank
    private String userAgent;

    @OneToOne(mappedBy = "cliente")
    private Bloqueio bloqueio;

    @OneToOne(mappedBy = "cliente")
    private Avisos avisos;

    @Deprecated
    public Cliente(){}

    public Cliente(String ipCliente, String userAgent) {
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public Long getId() { return id; }

    public String getIpCliente() { return ipCliente; }

    public String getUserAgent() { return userAgent; }

    public Bloqueio getBloqueio() {
        return bloqueio;
    }

    public Avisos getAvisos() {
        return avisos;
    }
}
