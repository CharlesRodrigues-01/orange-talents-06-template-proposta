package br.com.zupacademy.charles.proposta.cadastroNovaProposta;

public class StatusPropostaResponse {

    private StatusProposta statusProposta;

    public StatusPropostaResponse(StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }

    public StatusProposta getStatusProposta() {
        return statusProposta;
    }
}
