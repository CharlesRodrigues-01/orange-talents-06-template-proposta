package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio.Bloqueio;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ClienteBloqueio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String ipCliente;
    @NotBlank
    private String userAgent;

    @OneToOne(mappedBy = "clienteBloqueio")
    private Bloqueio bloqueio;

    @Deprecated
    public ClienteBloqueio(){}

    public ClienteBloqueio(String ipCliente, String userAgent) {
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public Long getId() { return id; }

    public String getIpCliente() { return ipCliente; }

    public String getUserAgent() { return userAgent; }
}
