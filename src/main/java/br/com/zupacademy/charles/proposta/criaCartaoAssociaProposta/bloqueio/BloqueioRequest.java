package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.bloqueio;

public class BloqueioRequest {

    private String sistemaResponsavel;

    public BloqueioRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }

    public String getSistemaResponsavel() { return sistemaResponsavel; }
}
