package br.com.zupacademy.charles.proposta.criaCartaoAssociaProposta.avisos;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

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
        return new Avisos(LocalDate.parse(this.validoAte), this.destino);
    }
}