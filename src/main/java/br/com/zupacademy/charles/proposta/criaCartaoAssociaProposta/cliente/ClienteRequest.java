package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.cliente;

import javax.validation.constraints.NotBlank;

public class ClienteRequest {

    @NotBlank
    private String ipCliente;
    @NotBlank
    private String userAgent;

    public ClienteRequest(String ipCliente, String userAgent) {
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
    }

    public String getIpCliente() { return ipCliente; }

    public String getUserAgent() { return userAgent; }

    public Cliente toModel(){
        return new Cliente(this.ipCliente, this.userAgent);
    }

}
