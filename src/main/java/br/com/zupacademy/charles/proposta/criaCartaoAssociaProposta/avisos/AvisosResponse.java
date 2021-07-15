package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos;

import br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos.Avisos;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class AvisosResponse {

    @NotBlank
    private String validoAte;
    @NotBlank
    private String destino;

    public AvisosResponse(String validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public String getValidoAte() { return validoAte; }

    public String getDestino() { return destino; }

    public Avisos toModel(){
        return new Avisos(LocalDateTime.parse(this.validoAte), this.destino);
    }
}