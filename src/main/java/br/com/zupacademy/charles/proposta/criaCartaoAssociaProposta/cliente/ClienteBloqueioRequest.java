package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente;

import javax.validation.constraints.NotBlank;

public class ClienteBloqueioRequest {

    @NotBlank
    private String ipCliente;
    @NotBlank
    private String userAgent;

    public ClienteBloqueioRequest(String ipCliente, String userAgent) {
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public String getIpCliente() { return ipCliente; }

    public String getUserAgent() { return userAgent; }

    public ClienteBloqueio toModel(){
        return new ClienteBloqueio(this.ipCliente, this.userAgent);
    }

}
