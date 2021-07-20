package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.carteiraDigital;

import javax.validation.constraints.NotBlank;

public class ResultadoAssociacao {

    @NotBlank
    private String resultado;
    @NotBlank
    private String id;

    public ResultadoAssociacao(@NotBlank String resultado, @NotBlank String id) {
        this.resultado = resultado;
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }

}
